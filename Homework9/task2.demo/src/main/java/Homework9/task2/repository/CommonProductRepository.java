package Homework9.task2.repository;

import Homework9.task2.domain.database.Database;
import Homework9.task2.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

public class CommonProductRepository implements ProductRepository{
    @Autowired
    private Database database;
    @Override
    public List<Product> getAll() {
        try {
            return database.select("Select all products").stream().map(x -> (Product) x).toList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product getById(int id) {
        try {
            return (Product) database.select("Select product where id = " + id).get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(String code, String label, double price) {
        try {
            database.execute("Add new product code = "+code+ " label = "+label+ " price = "+price);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
