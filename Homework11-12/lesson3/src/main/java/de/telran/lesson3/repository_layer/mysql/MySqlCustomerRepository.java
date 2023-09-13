package de.telran.lesson3.repository_layer.mysql;

import de.telran.lesson3.domain_layer.entity.*;
import de.telran.lesson3.domain_layer.entity.common.CommonCart;
import de.telran.lesson3.domain_layer.entity.common.CommonCustomer;
import de.telran.lesson3.domain_layer.entity.common.CommonProduct;
import de.telran.lesson3.repository_layer.CustomerRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;

import static de.telran.lesson3.domain_layer.database.MySqlConnector.getConnection;

public class MySqlCustomerRepository implements CustomerRepository {
    @Override
    public List<Customer> getAll() {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM customer as c left join customer_product as cp on c.id = cp.customer_id left join product as p on cp.product_id = p.id;";
            // Здесь ваш код
            // Создать список клиентов и наполнить корзины каждого клиента их товарами
            // Учесть момент, что у клиента вообще может не быть никаких товаров,
            // в таком случае корзина просто должна быть пустая.
            ResultSet resultSet = connection.createStatement().executeQuery(query);
            Map<Integer, Customer> map = new HashMap<>();
            while (resultSet.next()) {
                int customerId = resultSet.getInt(1);
                String customerName = resultSet.getString(2);

                if (!map.containsKey(customerId)) {
                    map.put(customerId, new CommonCustomer(customerId, customerName, new CommonCart()));
                }
                Customer currentCustomer = map.get(customerId);
                int productId = resultSet.getInt(5);
                String productName = resultSet.getString(7);
                double productPrice = resultSet.getDouble(8);
                if (productName != null) {
                    currentCustomer.getCart().addProduct(new CommonProduct(productId, productName, productPrice));
                }
            }
            return map.values().stream().toList();
        } catch (
                Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer getById(int id) {
        try (Connection connection = getConnection()) {
            String query = String.format("SELECT * FROM customer as c left join customer_product as cp on c.id = cp.customer_id left join product as p on cp.product_id = p.id where c.id = %d;", id);
            // Здесь ваш код
            ResultSet resultSet = connection.createStatement().executeQuery(query);
            Customer customer = null;
            while (resultSet.next()) {
                if (customer == null) {
                    int customerId = resultSet.getInt(1);
                    String customerName = resultSet.getString(2);
                    customer = new CommonCustomer(customerId, customerName, new CommonCart());
                }
                int productId = resultSet.getInt(5);
                String productName = resultSet.getString(7);
                double productPrice = resultSet.getDouble(8);
                if (productName != null) {
                    customer.getCart().addProduct(new CommonProduct(productId, productName, productPrice));
                }
            }

            return customer;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(String name) {
        try (Connection connection = getConnection()) {
            String query = String.format(Locale.US, "INSERT INTO `customer` (`name`) VALUES ('%s');", name);
            connection.createStatement().execute(query);
            // Здесь ваш код
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(int id) {
        try (Connection connection = getConnection()) {
            String query = String.format("DELETE FROM `customer` WHERE (`id` = '%d');", id);
            connection.createStatement().execute(query);
            // Здесь ваш код
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void addToCartById(int customerId, int productId) {
        try (Connection connection = getConnection()) {
            String query = String.format("INSERT INTO `customer_product` (`customer_id`, `product_id`) VALUES ('%d', '%d');", customerId, productId);
            connection.createStatement().execute(query);
            // Здесь ваш код
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteFromCart(int customerId, int productId) {
        try (Connection connection = getConnection()) {
            String query = String.format("DELETE FROM `customer_product` WHERE (`customer_id` = '%d' and `product_id` = '%d');", customerId, productId);
            connection.createStatement().execute(query);
            // Здесь ваш код
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void clearCart(int customerId) {
        try (Connection connection = getConnection()) {
            String query = String.format("DELETE FROM `customer_product` WHERE (`customer_id` = '%d');", customerId);
            connection.createStatement().execute(query);
            // Здесь ваш код
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
