package de.telran.lesson3.repository_layer.jpa;

import de.telran.lesson3.domain_layer.entity.jpa.JpaCustomer;
import jakarta.persistence.ManyToMany;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface JpaCustomerRepository extends JpaRepository<JpaCustomer, Integer> {

    @Transactional
    void deleteByName(String name);


//    @Query(value = "select sum(price) from product where id = %d;", nativeQuery = true)
//    double getTotalPriceById(int id);
//
//    @Query(value = "select avg(price) from product where id = %d;", nativeQuery = true)
//    double getAveragePriceById(int id);


}
