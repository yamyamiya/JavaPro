package de.telran.lesson3.service_layer.jpa;

import de.telran.lesson3.domain_layer.entity.Product;
import de.telran.lesson3.domain_layer.entity.jpa.JpaProduct;
import de.telran.lesson3.domain_layer.entity.jpa.Task;
import de.telran.lesson3.exception_layer.exceptions.ProductNotFoundException;
import de.telran.lesson3.repository_layer.jpa.JpaProductRepository;
import de.telran.lesson3.repository_layer.jpa.JpaTaskRepository;
import de.telran.lesson3.schedule_layer.ScheduleExecutor;
import de.telran.lesson3.service_layer.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JpaProductService implements ProductService {

    private static final Logger LOGGER = LogManager.getLogger(JpaProductService.class);
    @Autowired
    private JpaProductRepository repository;

    @Autowired
    private JpaTaskRepository taskRepository;
    @Autowired
    private ScheduleExecutor executor;

    @Override
    public List<Product> getAll() {
//        Task task = new Task("Task scheduled after getting all products.");
        Task task = new Task("Task scheduled for single execution after getting all products.");
        taskRepository.save(task);
//        ScheduleExecutor.taskSchedulerTaskWithTrigger(task);
        ScheduleExecutor.taskSchedulerTaskWithInstant(task);
        return new ArrayList<>(repository.findAll());
    }

    @Override
    public Product getById(int id) {

//        LOGGER.log(Level.INFO, String.format("INFO Запрошен продукт с идентификатором %d", id));
//        LOGGER.log(Level.WARN, String.format("WARN Запрошен продукт с идентификатором %d", id));
//        LOGGER.log(Level.ERROR, String.format("ERROR Запрошен продукт с идентификатором %d", id));
//
//        LOGGER.info(String.format("INFO Запрошен продукт с идентификатором %d.", id));
//        LOGGER.warn(String.format("WARN Запрошен продукт с идентификатором %d.", id));
//        LOGGER.error(String.format("ERROR Запрошен продукт с идентификатором %d.", id));
        Optional<JpaProduct> product = repository.findById(id);
        if(product.isEmpty()){
            throw new ProductNotFoundException("There is no product for that ID.");
        }

        Task task = new Task("Buy this product: " +product.get().getName()+ " with old price: "+ product.get().getPrice() +" with the new price: "+product.get().getPrice()*0.9);
        executor.taskSchedulerForCertainProduct(task);
//        return product.orElse(null);
        return product.get();

    }

    @Override
    public void add(Product product) {
        repository.save(new JpaProduct(0, product.getName(), product.getPrice()));

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
        return (int)repository.count();
    }

    @Override
    public double getTotalPrice() {
        return repository.getTotalPrice();
    }

    @Override
    public double getAveragePrice() {
        return repository.getAveragePrice();
    }

    public void test(JpaProduct product){
        product.setName("New Name");
    }
}
