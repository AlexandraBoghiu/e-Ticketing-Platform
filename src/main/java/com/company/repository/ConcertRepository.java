package com.company.repository;

import com.company.config.DatabaseConfiguration;
import com.company.models.Concert;
import com.company.services.AuditService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ConcertRepository {
    private static ConcertRepository instance = null;
    AuditService audit = AuditService.getInstance();
    private ConcertRepository() throws IOException {

    }

    public static ConcertRepository getInstance() throws IOException {
        if (instance != null) {
            return instance;
        }
        instance = new ConcertRepository();
        return instance;
    }
    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS concert " +
                "(id int PRIMARY KEY AUTO_INCREMENT, " +
                "name varchar(50)," +
                "numberOfTickets int," +
                "price double," +
                "genre varchar(30), " +
                "artist varchar(30))";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            Statement stat = connection.createStatement();
            stat.execute(createTableSql);
            audit.writeToAudit("createConcertTableDB");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
    public void addConcert(Concert concert) {
        String insertPersonSql = "INSERT INTO concert(name, numberOfTickets, price, genre, artist) VALUES(?, ?, ?, ?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertPersonSql)) {
            preparedStatement.setString(1, concert.getName());
            preparedStatement.setInt(2, concert.getNumberOfTickets());
            preparedStatement.setDouble(3, concert.getTicketPrice());
            preparedStatement.setString(4, concert.getGenre());
            preparedStatement.setString(5, concert.getArtist());

            preparedStatement.executeUpdate();
            audit.writeToAudit("addConcertDB");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}

