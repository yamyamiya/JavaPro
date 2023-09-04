package Homework9.task2.repository;

import Homework9.task2.domain.entity.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> getAll();
    Customer getById(int id);

    void add(String name);
}
