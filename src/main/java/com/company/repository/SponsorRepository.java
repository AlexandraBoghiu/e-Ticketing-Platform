package com.company.repository;

import com.company.config.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SponsorRepository {
    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS sponsor " +
                "(id int PRIMARY KEY AUTO_INCREMENT, " +
                "name varchar(30), " +
                "type varchar(30))";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            Statement stat = connection.createStatement();
            stat.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
//    final private Integer id;
//    private static Integer idSponsor = 0;
//    private String name;
//    private String type;