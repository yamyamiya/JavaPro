package de.telran.g240123mbelesson331082023.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;

@Data
public class CommonBasket implements Basket{
    private List<Product> products = new ArrayList();

    @Override
    public double getTotalCost() {
        return products.stream().mapToDouble(x -> x.getPrice()).reduce((x1,x2) -> x1+x2).orElse(0);
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
