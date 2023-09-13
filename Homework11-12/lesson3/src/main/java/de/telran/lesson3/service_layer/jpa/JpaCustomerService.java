package de.telran.lesson3.service_layer.jpa;

import de.telran.lesson3.domain_layer.entity.Cart;
import de.telran.lesson3.domain_layer.entity.Customer;
import de.telran.lesson3.domain_layer.entity.Product;
import de.telran.lesson3.domain_layer.entity.jpa.JpaCart;
import de.telran.lesson3.domain_layer.entity.jpa.JpaCustomer;
import de.telran.lesson3.domain_layer.entity.jpa.JpaProduct;
import de.telran.lesson3.exception_layer.exceptions.CustomerNotFoundException;
import de.telran.lesson3.exception_layer.exceptions.ProductNotFoundException;
import de.telran.lesson3.repository_layer.jpa.JpaCartRepository;
import de.telran.lesson3.repository_layer.jpa.JpaCustomerRepository;
import de.telran.lesson3.repository_layer.jpa.JpaProductRepository;
import de.telran.lesson3.service_layer.CustomerService;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JpaCustomerService implements CustomerService {

    @Autowired
    private JpaCustomerRepository repository;

    @Autowired
    private JpaCartRepository cartRepository;
    @Autowired
    private JpaProductRepository productRepository;

    @Override
    public List<Customer> getAll() {
        return new ArrayList<>(repository.findAll());
    }

    @Override
    public Customer getById(int id) {
        Optional<JpaCustomer> customer = repository.findById(id);
        if(customer.isEmpty()){
                throw new CustomerNotFoundException("There is no customer for that ID.");
        }
        return customer.orElse(null);
    }


    @Override
    public void add(Customer customer) {
        JpaCustomer savedCustomer = repository.save(new JpaCustomer(0, customer.getName()));
        cartRepository.save(new JpaCart(savedCustomer));
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        repository.deleteByName(name);
    }

    @Override
    public int getCount() {
        return (int) repository.count();
    }

    @Override
    public double getTotalPriceById(int id) {
        return getById(id).getCart().getTotalPrice();
    }

    @Override
    public double getAveragePriceById(int id) {
        Cart cart = getById(id).getCart();
        int size = cart.getProducts().size();
        if(size==0){
            return 0;
        }
        return cart.getTotalPrice() / size;
    }

    @Transactional
    @Override
    public void addToCartById(int customerId, int productId) {
        Customer customer = getById(customerId);
        Product product = productRepository.findById(productId).orElse(null);
        if(product==null){
            throw new ProductNotFoundException("There is no product for that ID.");
        }
        Cart cart = customer.getCart();
        cart.addProduct(product);
    }

    @Transactional
    @Override
    public void deleteFromCart(int customerId, int productId) {

        JpaProduct product = productRepository.findById(productId).orElse(null);
        if(product==null){
            throw new ProductNotFoundException("There is no product for that ID.");
        }
        ((JpaCart) getById(customerId).getCart()).removeProduct(product);

    }

    @Transactional
    @Override
    public void clearCart(int customerId) {
        ((JpaCart) getById(customerId).getCart()).clear();

    }
}
