package de.telran.g240123mbelesson331082023.config;

import de.telran.g240123mbelesson331082023.domain.database.CommonDatabase;
import de.telran.g240123mbelesson331082023.domain.database.Database;
import de.telran.g240123mbelesson331082023.domain.entity.Client;
import de.telran.g240123mbelesson331082023.repository.ClientRepository;
import de.telran.g240123mbelesson331082023.repository.CommonClientRepository;
import de.telran.g240123mbelesson331082023.repository.CommonProductRepository;
import de.telran.g240123mbelesson331082023.repository.ProductRepository;
import de.telran.g240123mbelesson331082023.service.ClientService;
import de.telran.g240123mbelesson331082023.service.CommonClientService;
import de.telran.g240123mbelesson331082023.service.CommonProductService;
import de.telran.g240123mbelesson331082023.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    public Database database(){
        return new CommonDatabase();
    }

    @Bean
    public ClientService clientService(){
        return new CommonClientService();
    }

    @Bean
    public ProductService productService(){
        return new CommonProductService();
    }

    @Bean
    public ClientRepository clientRepository(){
        return new CommonClientRepository();
    }

    @Bean
    public ProductRepository productRepository(){
        return new CommonProductRepository();
    }
}
