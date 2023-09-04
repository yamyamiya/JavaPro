package Homework9.task2.domain.database;

import Homework9.task2.domain.entity.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CommonDatabase implements Database{
    private List<Customer> customers = new ArrayList<>();
    private List<Product> products = new ArrayList<>();

    private int idProductCounter = 5;
    private int idCustomerCounter = 5;

    public CommonDatabase() {
        customers.add(new CommonCustomer(1, "Vasya", new CommonShoppingCart()));
        customers.add(new CommonCustomer(2, "Masha", new CommonShoppingCart()));
        customers.add(new CommonCustomer(3, "Dasha", new CommonShoppingCart()));
        customers.add(new CommonCustomer(4, "Sasha", new CommonShoppingCart()));
        customers.add(new CommonCustomer(5, "Ivan", new CommonShoppingCart()));

        products.add(new CommonProduct(1, "Drinks","Milk", 3.5));
        products.add(new CommonProduct(2, "Fruits","Apple", 4.0));
        products.add(new CommonProduct(3, "Vegetables", "Potato",2.0));
        products.add(new CommonProduct(4, "Meat", "Pork",9.5));
        products.add(new CommonProduct(5, "Sweets", "Cookies",4.5));
    }

    @Override
    public void execute(String query) throws SQLException {
        //	"Add new customer name = Vasya"
        //	"Add new product code = Vegetables label = Potato price = 2.4"
        if (!query.startsWith("Add")){
            throw new SQLException();
        }
        String[] parts = query.split(" ");
        if (parts[0].equals("Add")) {
            if (parts[2].equals("customer")) {
                customers.add(new CommonCustomer(++idCustomerCounter, parts[5], new CommonShoppingCart()));
            }
            if (parts[2].equals("product")) {
                products.add(new CommonProduct(++idProductCounter, parts[5], parts[8], Double.parseDouble(parts[11])));
            }
        }
    }

    @Override
    public List<Object> select(String query) throws SQLException {
        //	"Select all customers" - такие запросы выполняет метод select
//	"Select customer where id = 1" - такие запросы выполняет метод select
        //	"Select all products" - такие запросы выполняет метод select
//	"Select product where id = 1" - такие запросы выполняет метод select
        if (!query.startsWith("Select")) {
            throw new SQLException();
        }

        String[] parts = query.split(" ");
        List<Object> result = new ArrayList<>();

        if (parts.length == 3) {
            if (parts[2].equals("customers")) {
                result.addAll(customers);
            }

            if (parts[2].equals("products")) {
                result.addAll(products);
            }
        }

        if (parts.length == 6) {
            if (parts[1].equals("customer")) {
                result.add(customers.stream().filter(x -> x.getId() == Integer.parseInt(parts[5])).toList().get(0));
            }

            if (parts[1].equals("product")) {
                result.add(products.stream().filter(x -> x.getId() == Integer.parseInt(parts[5])).toList().get(0));
            }
        }

        return result;
    }
}
