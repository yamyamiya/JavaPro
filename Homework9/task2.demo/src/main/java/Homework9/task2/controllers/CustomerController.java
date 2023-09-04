package Homework9.task2.controllers;

import Homework9.task2.domain.entity.CommonCustomer;
import Homework9.task2.domain.entity.Customer;
import Homework9.task2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping
    public List<Customer> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public void add(@RequestBody CommonCustomer customer) {
        service.add(customer);
    }
    @GetMapping("/getCartAmount/{id}")
    double getCartAmount(@PathVariable int id){
        return service.getCartAmount(id);
    }
}
