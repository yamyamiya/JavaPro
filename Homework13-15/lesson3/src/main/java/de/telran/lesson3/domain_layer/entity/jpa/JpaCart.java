package de.telran.lesson3.domain_layer.entity.jpa;

import de.telran.lesson3.domain_layer.entity.Cart;
import de.telran.lesson3.domain_layer.entity.Product;
import de.telran.lesson3.service_layer.jpa.JpaProductService;
import jakarta.persistence.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
public class JpaCart implements Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @OneToOne
    @JoinColumn(name = "customer_id")
    private JpaCustomer customer;

    @ManyToMany
    @JoinTable(
            name = "cart_product",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<JpaProduct> products;

    private static final Logger LOGGER = LogManager.getLogger(JpaCart.class);


    public JpaCart(List<JpaProduct> products) {
        this.products = products;
        LOGGER.info(String.format("INFO Вызван конструктор JpaCart(List<JpaProduct> products) c products "+products.toString()));
    }

    public JpaCart(JpaCustomer customer) {
        this.customer = customer;
        LOGGER.info(String.format("INFO Вызван конструктор JpaCart(JpaCustomer customer) c customer "+customer.toString()));
    }

    public JpaCart() {
        LOGGER.info(String.format("INFO Вызван конструктор JpaCart()"));
    }


    @Override
    public List<Product> getProducts() {
        LOGGER.info(String.format("INFO Вызван метод getProducts()"));
        return new ArrayList<>(products);
    }

    @Override
    public void addProduct(Product product) {
        LOGGER.info(String.format("INFO Вызван метод addProduct()"));
        products.add(new JpaProduct(product.getId(), product.getName(), product.getPrice()));
    }

    @Override
    public double getTotalPrice() {
        LOGGER.info(String.format("INFO Вызван метод getTotalPrice()"));
        return products.stream().mapToDouble(x -> x.getPrice()).sum();
    }

    public int getId() {
        LOGGER.info(String.format("INFO Вызван метод getId()"));
        return id;
    }


    public void clear() {
        LOGGER.info(String.format("INFO Вызван метод clear()"));
        products.clear();
    }


    public void removeProduct(JpaProduct product) {
        LOGGER.info(String.format("INFO Вызван метод removeProduct()"));
        products.remove(product);
    }

    @Override
    public String toString() {
        return "JpaCart{" +
                "id=" + id +
                ", customer=" + customer +
                ", products=" + products +
                '}';
    }
}
