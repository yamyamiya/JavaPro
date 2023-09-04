package de.telran.g240123mbelesson331082023.controllers;

import de.telran.g240123mbelesson331082023.domain.entity.Client;
import de.telran.g240123mbelesson331082023.domain.entity.CommonClient;
import de.telran.g240123mbelesson331082023.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService service;

    @GetMapping
    public List<Client> getAll() {
        return service.getAll();
    }

    @GetMapping("/id/{id}")
    public Client getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping()
    public void add(@RequestBody CommonClient customer) {
        service.add(customer);
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

    @GetMapping("/getTotalPriceById/{id}")
    public double getTotalPriceById(@PathVariable int id) {
        return service.getTotalPriceById(id);
    }

    @GetMapping("/getAveragePriceById/{id}")
    public double getAveragePriceById(@PathVariable int id) {
        return service.getAveragePriceById(id);
    }

    @PostMapping("/addToCartById/{customerId}/{productId}")
    public void addToCartById(@PathVariable int customerId, @PathVariable int productId) {
        service.addToCartById(customerId, productId);
    }

    @DeleteMapping("/deleteFromCart/{customerId}/{productId}")
    public void deleteFromCart(@PathVariable int customerId, @PathVariable int productId) {
        service.deleteFromCart(customerId, productId);
    }

    @DeleteMapping("/clearCart/{customerId}")
    public void clearCart(@PathVariable int customerId) {
        service.clearCart(customerId);
    }
}
