package Homework9.task2.service;

import Homework9.task2.domain.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Product getById(int id);

    void add(Product product);
    double getCartAmount();

}
