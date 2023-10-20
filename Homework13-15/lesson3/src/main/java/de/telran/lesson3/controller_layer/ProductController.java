package de.telran.lesson3.controller_layer;

import de.telran.lesson3.domain_layer.entity.common.CommonProduct;
import de.telran.lesson3.domain_layer.entity.Product;
import de.telran.lesson3.domain_layer.entity.jpa.JpaProduct;
import de.telran.lesson3.exception_layer.Response;
import de.telran.lesson3.exception_layer.exceptions.EntityValidationException;
import de.telran.lesson3.exception_layer.exceptions.FirstTestException;
import de.telran.lesson3.exception_layer.exceptions.SecondTestException;
import de.telran.lesson3.exception_layer.exceptions.ThirdTestException;
import de.telran.lesson3.service_layer.ProductService;
import de.telran.lesson3.service_layer.jpa.JpaProductService;
import jakarta.validation.Valid;
import org.hibernate.action.internal.EntityActionVetoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController implements Controller{

    @Autowired
    private ProductService service;

    //Для просмотра общего списка товаров и покупателей не требуется авторизация.
    @GetMapping
    public List<Product> getAll() {
        ((JpaProductService) service).test(new JpaProduct(0, "Test Name", 100));
        List<Product> products= service.getAll();
        if(products.size()==0) {
            throw new ThirdTestException("Список продуктов пуст.");
        }
        return products;
    }

//этот метод доступен аутентифицированным пользователям, менеджерам и администраторам
    @GetMapping("/id/{id}")
    public Product getById(@PathVariable int id) {
        return service.getById(id);
    }

    //этот метод доступен аутентифицированным администраторам
    @PostMapping
    public Product add(@Valid @RequestBody CommonProduct product) {

        try{
            service.add(product);
            return product;
        } catch(Exception e){
            throw new EntityValidationException(e.getMessage());
        }

    }

    //этот метод доступен аутентифицированным администраторам
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        service.deleteById(id);
    }

    //этот метод доступен аутентифицированным администраторам
    @GetMapping("/deletename/{name}")
    public void delete(@PathVariable String name) {
        service.deleteByName(name);
    }

    //этот метод доступен аутентифицированным менеджерам и администраторам
    @GetMapping("/count")
    public int getCount() {
        return service.getCount();
    }

    //этот метод доступен аутентифицированным менеджерам и администраторам
    @GetMapping("/total")
    public double getTotalPrice() {
        return service.getTotalPrice();
    }


    //этот метод доступен аутентифицированным менеджерам и администраторам
    @GetMapping("/average")
    public double getAverage() {
        return service.getAveragePrice();
    }


}