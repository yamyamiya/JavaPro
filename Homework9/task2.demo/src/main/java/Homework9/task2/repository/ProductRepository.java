package Homework9.task2.repository;

import Homework9.task2.domain.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAll();

    Product getById(int id);

    void add(String code,String label, double price);
}
