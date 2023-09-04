package de.telran.g240123mbelesson331082023.repository;

import de.telran.g240123mbelesson331082023.domain.database.CommonDatabase;
import de.telran.g240123mbelesson331082023.domain.database.Database;
import de.telran.g240123mbelesson331082023.domain.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

public class CommonClientRepository implements ClientRepository{
    @Autowired
    private Database database;
    @Override
    public Client findById(int id) {
        try {
            return (Client)database.select("Select client where id = "+id).get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Client> getClients() {
        try {
             List<Object> selectAllClients = database.select("Select all clients");
             return selectAllClients.stream().map(o -> (Client)o).toList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(int id) {
        try {
            database.execute("Delete client where id = "+id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void addClient(String name) {
        try {
            database.execute("Add new client name = "+name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
