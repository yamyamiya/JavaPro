package Homework9.task2.domain.entity;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommonCustomer implements Customer{
    private int id;
    private String name;
    private CommonShoppingCart shoppingCart;

}
