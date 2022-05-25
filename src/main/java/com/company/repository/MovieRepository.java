package com.company.repository;

import com.company.config.DatabaseConfiguration;
import com.company.models.Movie;
import com.company.services.AuditService;

import java.io.IOException;
import java.sql.*;

public class MovieRepository {

    private static MovieRepository instance = null;
    AuditService audit = AuditService.getInstance();

    private MovieRepository() throws IOException {

    }

    public static MovieRepository getInstance() throws IOException {
        if (instance != null) {
            return instance;
        }
        instance = new MovieRepository();
        return instance;
    }
    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS movie " +
                "(id int PRIMARY KEY AUTO_INCREMENT, " +
                "name varchar(50)," +
                "numberOfTickets int," +
                "price double," +
                "genre varchar(30), " +
                "director varchar(30)," +
                "yearOfProduction int)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            Statement stat = connection.createStatement();
            stat.execute(createTableSql);
            audit.writeToAudit("createMovieTableDB");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
    public void addMovie(Movie movie) {
        String insertMovieSql = "INSERT INTO movie(name, numberOfTickets, price, genre, director, yearOfProduction) VALUES(?, ?, ?, ?, ?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertMovieSql)) {
            preparedStatement.setString(1, movie.getName());
            preparedStatement.setInt(2, movie.getNumberOfTickets());
            preparedStatement.setDouble(3, movie.getTicketPrice());
            preparedStatement.setString(4, movie.getGenre());
            preparedStatement.setString(5, movie.getDirector());
            preparedStatement.setInt(6, movie.getYearOfProduction());

            preparedStatement.executeUpdate();
            audit.writeToAudit("addMovieDB");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
