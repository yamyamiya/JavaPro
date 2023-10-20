package de.telran.lesson3.domain_layer.entity.jpa;

import de.telran.lesson3.domain_layer.entity.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.NonNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="product")
public class JpaProduct implements Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "name")
    @NonNull
    @NotBlank
    // Potato - valid
    // potato - not valid
    // Potato5 - not valid
    // Potato# - not valid
    // Po - not valid
    @Pattern(regexp = "[A-Z][a-z]{2,}")
    private String name;


    @Column(name = "price")
    @NonNull
    @Min(value=1)
    @Max(value = 999999)
    private double price;

    private static final Logger LOGGER = LogManager.getLogger(JpaProduct.class);


    public JpaProduct() {
        LOGGER.info(String.format("INFO Вызван конструктор JpaProduct()"));
    }

    public JpaProduct(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        LOGGER.info(String.format("INFO Вызван конструктор JpaProduct() c id= %d, name= %s и price= %f.", id, name, price));
    }


    @Override
    public int getId() {
        LOGGER.info(String.format("INFO Вызван метод getId()"));
        return id;
    }

    @Override
    public String getName() {
        LOGGER.info(String.format("INFO Вызван метод getName()"));
        return name;
    }

    @Override
    public String toString() {
        return "JpaProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public void setName(String name) {
        LOGGER.info(String.format("INFO Вызван метод setName()"));
        this.name = name;
    }

    @Override
    public double getPrice() {
        LOGGER.info(String.format("INFO Вызван метод getPrice()"));
        return price;
    }
}
