package com.example.demo4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnectionTest {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/pharmacy_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Strongest2002";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Step 1: Load and register the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Create a connection
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database!");

            // Step 3: Perform a test query
            Statement statement = connection.createStatement();
            String sqlQuery = "SELECT * FROM drugs";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            // Step 4: Process the query result
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                // ... Other fields if needed
                System.out.println("Drug ID: " + id + ", Name: " + name);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
