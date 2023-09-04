package Homework9.task2.controllers;

import Homework9.task2.domain.entity.CommonProduct;
import Homework9.task2.domain.entity.Product;
import Homework9.task2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public void add(@RequestBody CommonProduct product) {
        service.add(product);
    }
    @GetMapping("/getCartAmount")
    public double getCartAmount(){
        return service.getCartAmount();
    }
}
