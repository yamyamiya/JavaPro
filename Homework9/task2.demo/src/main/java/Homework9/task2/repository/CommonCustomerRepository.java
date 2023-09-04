package Homework9.task2.repository;

import Homework9.task2.domain.database.Database;
import Homework9.task2.domain.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

public class CommonCustomerRepository implements CustomerRepository{
    @Autowired
    private Database database;
    @Override
    public List<Customer> getAll() {
        try {
            List<Object> selectAllCustomers = database.select("Select all customers");
            return selectAllCustomers.stream().map(o -> (Customer)o).toList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer getById(int id) {
        try {
            return (Customer) database.select("Select customer where id = "+id).get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(String name) {
        try {
            database.execute("Add new customer name = "+name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
