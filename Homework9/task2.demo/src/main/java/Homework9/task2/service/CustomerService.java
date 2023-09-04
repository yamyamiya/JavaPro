package Homework9.task2.service;

import Homework9.task2.domain.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAll();

    Customer getById(int id);

    void add(Customer customer);

    double getCartAmount(int id);


}
