package de.telran.lesson3.domain_layer.entity.jpa;

import de.telran.lesson3.domain_layer.entity.Cart;
import de.telran.lesson3.domain_layer.entity.Product;
import jakarta.persistence.*;

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


    public JpaCart(List<JpaProduct> products) {
        this.products = products;
    }

    public JpaCart(JpaCustomer customer) {
        this.customer = customer;
    }

    public JpaCart() {
    }


    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public void addProduct(Product product) {
        products.add(new JpaProduct(product.getId(), product.getName(), product.getPrice()));
    }

    @Override
    public double getTotalPrice() {
        return products.stream().mapToDouble(x -> x.getPrice()).sum();
    }

    public int getId() {
        return id;
    }


    public void clear() {
        products.clear();
    }


    public void removeProduct(JpaProduct product) {
        products.remove(product);
    }
}
