package Homework9.task2.domain.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CommonShoppingCart implements ShoppingCart{
    private List<Product> products = new ArrayList();

    @Override
    public double getShoppingCartAmount() {
        return products.stream().mapToDouble(x -> x.getPrice()).sum();
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }
    @Override
    public List<Product> getProducts(){
        return products;
    }
}
