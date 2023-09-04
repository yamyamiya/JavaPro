package de.telran.g240123mbelesson331082023.controllers;

import de.telran.g240123mbelesson331082023.domain.entity.CommonProduct;
import de.telran.g240123mbelesson331082023.domain.entity.Product;
import de.telran.g240123mbelesson331082023.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping()
    public List<Product> getAll() {
        return service.getAll();
    }

    @GetMapping("/id/{id}")
    public Product getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public void add(@RequestBody CommonProduct product) {
        service.add(product);
    }

    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable int id) {
        service.deleteById(id);
    }

    @DeleteMapping("/name/{name}")
    public void deleteByName(@PathVariable String name) {
        service.deleteByName(name);
    }

    @GetMapping("/getCount")
    public int getCount() {
        return service.getCount();
    }

    @GetMapping("/getTotalPrice")
    public double getTotalPrice() {
        return service.getTotalPrice();
    }

    @GetMapping("/getAveragePrice")
    double getAveragePrice() {
        return service.getAveragePrice();
    }
}
