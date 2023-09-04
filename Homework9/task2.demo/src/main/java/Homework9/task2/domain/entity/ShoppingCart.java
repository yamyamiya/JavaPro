package Homework9.task2.domain.entity;

import java.util.List;

public interface ShoppingCart {
    double getShoppingCartAmount();
    void addProduct(Product product);
    List<Product> getProducts();
}
