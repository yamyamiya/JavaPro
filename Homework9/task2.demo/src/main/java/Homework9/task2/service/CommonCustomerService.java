package Homework9.task2.service;

import Homework9.task2.domain.entity.Customer;
import Homework9.task2.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommonCustomerService implements CustomerService{
    @Autowired
    private CustomerRepository repository;

    @Autowired
    private ProductService productService;
    @Override
    public List<Customer> getAll() {
        return repository.getAll();
    }

    @Override
    public Customer getById(int id) {
        return repository.getById(id);
    }

    @Override
    public void add(Customer customer) {
        repository.add(customer.getName());

    }

    @Override
    public double getCartAmount(int id) {
        return repository.getById(id).getShoppingCart().getShoppingCartAmount();
    }
}
