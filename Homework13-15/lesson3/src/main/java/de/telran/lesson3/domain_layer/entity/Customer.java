package de.telran.lesson3.domain_layer.entity;

import de.telran.lesson3.domain_layer.entity.jpa.Role;

import java.util.Set;

public interface Customer {

    int getId();

    String getName();

    Cart getCart();

    Set<Role> getRoles();

    void setRoles(Set<Role> roles);

    void setPassword(String password);

    String getPassword();

    int getAge();

     String getEmail();

}