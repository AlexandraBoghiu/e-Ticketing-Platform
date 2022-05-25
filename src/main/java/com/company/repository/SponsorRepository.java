package com.company.repository;

import com.company.config.DatabaseConfiguration;
import com.company.models.Sponsor;
import com.company.services.AuditService;
import com.company.services.ClientService;

import java.io.IOException;
import java.sql.*;

public class SponsorRepository {
    private static SponsorRepository instance = null;
    AuditService audit = AuditService.getInstance();

    private SponsorRepository() throws IOException {

    }

    public static SponsorRepository getInstance() throws IOException {
        if (instance != null) {
            return instance;
        }
        instance = new SponsorRepository();
        return instance;
    }
    public void createTable() throws IOException {
        String createTableSql = "CREATE TABLE IF NOT EXISTS sponsor " +
                "(id int PRIMARY KEY AUTO_INCREMENT, " +
                "name varchar(30), " +
                "type varchar(30))";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            Statement stat = connection.createStatement();
            stat.execute(createTableSql);
            audit.writeToAudit("createSponsorTableDB");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void addSponsor(Sponsor sponsor) throws IOException {
        String insertPersonSql = "INSERT INTO sponsor(name, type) VALUES(?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertPersonSql)) {
            preparedStatement.setString(1, sponsor.getName());
            preparedStatement.setString(2, sponsor.getType());
            audit.writeToAudit("addSponsorDB");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public Sponsor getSponsorByType(String type) throws IOException {
        String selectSql = "SELECT * FROM sponsor WHERE type=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, type);

            ResultSet resultSet = preparedStatement.executeQuery();
            audit.writeToAudit("getSponsorByTypeDB");
            return mapToSponsor(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void updateSponsorName(String name, int id) {
        String updateNameSql = "UPDATE sponsor SET name=? WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
            audit.writeToAudit("updateSponsorNameDB");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteSponsor(int id) {
        String deleteSql = "DELETE FROM sponsor WHERE id=?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
       try(PreparedStatement statement = connection.prepareStatement(deleteSql)) {
           statement.setInt(1, id);
           statement.executeUpdate();
           audit.writeToAudit("deleteSponsorDB");
       }
       catch (SQLException | IOException e) {
           e.printStackTrace();
       }
    }
    private Sponsor mapToSponsor(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new Sponsor(resultSet.getString(2), resultSet.getString(3));
        }
        return null;
    }


}
