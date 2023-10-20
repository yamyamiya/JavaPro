package de.telran.lesson3.domain_layer.entity.common;

import de.telran.lesson3.domain_layer.entity.Cart;
import de.telran.lesson3.domain_layer.entity.Customer;
import de.telran.lesson3.domain_layer.entity.jpa.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class CommonCustomer implements Customer {

    private int id;
    private String name;
    private CommonCart cart;

    private String email;

    private int age;

    private String password;
    private Set<Role> roles;

    public CommonCustomer(int customerId, String customerName, CommonCart cart) {
    }

    public CommonCustomer() {
    }

    public CommonCustomer(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getEmail() {
        return email;
    }
}