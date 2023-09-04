package Homework9.task2.config;

import Homework9.task2.domain.database.CommonDatabase;
import Homework9.task2.domain.database.Database;
import Homework9.task2.repository.CommonCustomerRepository;
import Homework9.task2.repository.CommonProductRepository;
import Homework9.task2.repository.CustomerRepository;
import Homework9.task2.repository.ProductRepository;
import Homework9.task2.service.CommonCustomerService;
import Homework9.task2.service.CommonProductService;
import Homework9.task2.service.CustomerService;
import Homework9.task2.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

        @Bean
        public Database database(){
            return new CommonDatabase();
        }

        @Bean
        public CustomerService clientService(){
            return new CommonCustomerService();
        }

        @Bean
        public ProductService productService(){
            return new CommonProductService();
        }

        @Bean
        public CustomerRepository customerRepository(){
            return new CommonCustomerRepository();
        }

        @Bean
        public ProductRepository productRepository(){
            return new CommonProductRepository();
        }
    }

