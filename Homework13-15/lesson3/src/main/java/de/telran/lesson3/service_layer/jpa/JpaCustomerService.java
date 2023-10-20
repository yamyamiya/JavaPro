package de.telran.lesson3.service_layer.jpa;

import de.telran.lesson3.domain_layer.entity.Cart;
import de.telran.lesson3.domain_layer.entity.Customer;
import de.telran.lesson3.domain_layer.entity.Product;
import de.telran.lesson3.domain_layer.entity.jpa.*;
import de.telran.lesson3.exception_layer.exceptions.CustomerNotFoundException;
import de.telran.lesson3.exception_layer.exceptions.ProductNotFoundException;
import de.telran.lesson3.repository_layer.jpa.JpaCartRepository;
import de.telran.lesson3.repository_layer.jpa.JpaCustomerRepository;
import de.telran.lesson3.repository_layer.jpa.JpaProductRepository;
import de.telran.lesson3.repository_layer.jpa.JpaTaskRepository;
import de.telran.lesson3.schedule_layer.ScheduleExecutor;
import de.telran.lesson3.service_layer.CustomerService;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class JpaCustomerService implements CustomerService, UserDetailsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(JpaCustomerService.class);

    @Autowired
    private JpaCustomerRepository repository;

    @Autowired
    private JpaCartRepository cartRepository;
    @Autowired
    private JpaProductRepository productRepository;

    @Autowired
    private JpaTaskRepository taskRepository;

    @Autowired
    private ScheduleExecutor executor;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public List<Customer> getAll() {
        return new ArrayList<>(repository.findAll());
    }

    @Override
    public Customer getById(int id) {
        LOGGER.info(String.format("INFO Запрошен клиент с идентификатором %d.", id));
        LOGGER.warn(String.format("WARN Запрошен клиент с идентификатором %d.", id));
        LOGGER.error(String.format("ERROR Запрошен клиент с идентификатором %d.", id));

        Optional<JpaCustomer> customer = repository.findById(id);
        if (customer.isEmpty()) {
            throw new CustomerNotFoundException("There is no customer for that ID.");
        }
        return customer.orElse(null);
    }


    @Override
    public void add(Customer customer) {
        JpaCustomer jpaCustomer = repository.findByName(customer.getName());
        if(jpaCustomer!=null){
            return;
        }
        jpaCustomer = new JpaCustomer(0, customer.getName());

        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1, "ROLE_USER"));
        jpaCustomer.setRoles(roles);

        String encodedPassword= encoder.encode(customer.getPassword());
        jpaCustomer.setPassword(encodedPassword);
        jpaCustomer.setAge(customer.getAge());
        jpaCustomer.setEmail(customer.getEmail());


        JpaCustomer savedCustomer = repository.save(jpaCustomer);
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
        if (size == 0) {
            return 0;
        }
        return cart.getTotalPrice() / size;
    }

    @Transactional
    @Override
    public void addToCartById(int customerId, int productId) {
        Customer customer = getById(customerId);
        Product product = productRepository.findById(productId).orElse(null);
        if (product == null) {
            throw new ProductNotFoundException("There is no product for that ID.");
        }
        Cart cart = customer.getCart();
        cart.addProduct(product);
    }

    @Transactional
    @Override
    public void deleteFromCart(int customerId, int productId) {

        JpaProduct product = productRepository.findById(productId).orElse(null);
        if (product == null) {
            throw new ProductNotFoundException("There is no product for that ID.");
        }
        ((JpaCart) getById(customerId).getCart()).removeProduct(product);

    }

    @Transactional
    @Override
    public void clearCart(int customerId) {
        JpaCart temp_cart = (JpaCart) getById(customerId).getCart();
        int random = (new Random().nextInt(temp_cart.getProducts().size()));
        JpaProduct discount_product = (JpaProduct) temp_cart.getProducts().get(random);
//Вывод в консоль должен быть осуществлён через логирование поля description созданной задачи.
//    Поле description задачи должно содержать предложение приобрести все товары из корзины,
//    список товаров из корзины (каждый товар с новой строки), причём товар со скидкой должен быть указан с новой ценой,
//    а также с новой строки - старую стоимость корзины и новую стоимость корзины.
//    Указание скидки для данного предложения не должно влиять на базовую цену товара в БД.
        double old_cost = temp_cart.getTotalPrice();
        double new_cost = temp_cart.getTotalPrice() - discount_product.getPrice() * 0.15;
                String productsList = temp_cart.getProducts().stream()
                .map(x -> {
                    if (x.getId() == discount_product.getId()) {
                        return x.getName() + " with price: " + x.getPrice()*0.85;
                    } else {
                        return x.getName() + " with price: " + x.getPrice();
                    }
                }).collect(Collectors.joining("\n"));

        ((JpaCart) getById(customerId).getCart()).clear();

        Task task = new Task("New Offer! Buy all your products with discount: \n" +
                productsList + "\n Old cost of your cart: " + old_cost + ". New cost of your cart: " + new_cost);
        System.out.println("Random= "+random);
        taskRepository.save(task);
        ScheduleExecutor.taskSchedulerForClearCart(task);


    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        JpaCustomer customer = repository.findByName(username);
        if(customer==null){
            throw new UsernameNotFoundException("Customer not found");
        }

        return customer;
    }
}
