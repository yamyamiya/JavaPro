package de.telran.lesson3.domain_layer.entity.jpa;

import de.telran.lesson3.domain_layer.entity.Cart;
import de.telran.lesson3.domain_layer.entity.Customer;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.NonNull;

@Entity
@Table(name = "customer")
public class JpaCustomer implements Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NonNull
    @NotBlank
    private String name;

    @Column(name = "age")
    @Min(value=14)
    @Max(value = 130)
    private int age;

    @Column(name = "email")
    @Pattern(regexp = "\\w{1,}[@][a-z]{1,}[.][a-z]{2,4}")
    private String email;

    @OneToOne(mappedBy = "customer",
            cascade = CascadeType.ALL)
    private JpaCart cart;

    public JpaCustomer() {
    }

    public JpaCustomer(int id, String name, JpaCart cart) {
        this.id = id;
        this.name = name;
        this.cart = cart;
    }

    public JpaCustomer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Cart getCart() {
        return cart;
    }
}
