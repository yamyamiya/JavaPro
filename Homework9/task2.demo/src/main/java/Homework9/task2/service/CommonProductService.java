package Homework9.task2.service;

import Homework9.task2.domain.entity.Product;
import Homework9.task2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommonProductService implements ProductService{
    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> getAll() {
        return repository.getAll();
    }

    @Override
    public Product getById(int id) {
        return repository.getById(id);
    }

    @Override
    public void add(Product product) {
        repository.add(product.getCode(), product.getLabel(), product.getPrice());

    }

    @Override
    public double getCartAmount() {
        return repository.getAll().stream().mapToDouble(x->x.getPrice()).sum();
    }
}
