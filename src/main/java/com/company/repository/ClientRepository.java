package com.company.repository;

import com.company.config.DatabaseConfiguration;
import com.company.models.Client;
import com.company.models.Sponsor;
import com.company.services.AuditService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientRepository {
    private static ClientRepository instance = null;
    AuditService audit = AuditService.getInstance();
    private ClientRepository() throws IOException {

    }

    public static ClientRepository getInstance() throws IOException {
        if (instance != null) {
            return instance;
        }
        instance = new ClientRepository();
        return instance;
    }
    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS client " +
                "(id int PRIMARY KEY AUTO_INCREMENT, " +
                "name varchar(50)," +
                "lastname varchar(30))";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            Statement stat = connection.createStatement();
            stat.execute(createTableSql);
            audit.writeToAudit("createClientTabletDB");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
    public void addClient(Client client) {
        String insertPersonSql = "INSERT INTO client(firstname, lastname) VALUES(?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertPersonSql)) {
            preparedStatement.setString(1, client.getFirstName());
            preparedStatement.setString(2, client.getLastName());

            preparedStatement.executeUpdate();
            audit.writeToAudit("addClientDB");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
