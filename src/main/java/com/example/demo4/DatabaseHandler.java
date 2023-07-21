package com.example.demo4;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/pharmacy_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Strongest2002";

    // Establish the connection to the database
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }

    // Method to add a new drug to the database
    public void addDrug(Drug drug) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO drugs (name, description) VALUES (?, ?)",
                     Statement.RETURN_GENERATED_KEYS)
        ) {
            statement.setString(1, drug.getName());
            statement.setString(2, drug.getDescription());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    drug.setId(id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to add a new supplier to the database
    public void addSupplier(drugSupplier supplier) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO suppliers (name, location) VALUES (?, ?)",
                     Statement.RETURN_GENERATED_KEYS)
        ) {
            statement.setString(1, supplier.getName());
            statement.setString(2, supplier.getLocation());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    supplier.setId(id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to add a new purchase history to the database
    public void addPurchaseHistory(PurchaseHistory purchase) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO purchase_history (drug_id, purchase_date, quantity, total_amount, buyer) " +
                             "VALUES (?, ?, ?, ?, ?)",
                     Statement.RETURN_GENERATED_KEYS)
        ) {
            statement.setInt(1, purchase.getId());
            statement.setTimestamp(2, new Timestamp(purchase.getPurchaseDate().getTime()));
            statement.setInt(3, purchase.getQuantity());
            statement.setDouble(4, purchase.getTotalAmount());
            statement.setString(5, purchase.getBuyer());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    purchase.setId(id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve all drugs from the database
    public List<Drug> getAllDrugs() {
        List<Drug> drugs = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM drugs")
        ) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                Drug drug = new Drug(id, name, description);
                drugs.add(drug);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drugs;
    }

    // Method to retrieve all suppliers from the database
    public List<drugSupplier> getAllSuppliers() {
        List<drugSupplier> suppliers = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM suppliers")
        ) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String location = resultSet.getString("location");
                drugSupplier supplier = new drugSupplier(id, name, location);
                suppliers.add(supplier);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return suppliers;
    }

    // Method to retrieve purchase history for a specific drug from the database
    public List<PurchaseHistory> getPurchaseHistoryForDrug(int drugId) {
        List<PurchaseHistory> purchaseHistory = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM purchase_history WHERE drug_id = ?")
        ) {
            statement.setInt(1, drugId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    Timestamp purchaseDate = resultSet.getTimestamp("purchase_date");
                    int quantity = resultSet.getInt("quantity");
                    double totalAmount = resultSet.getDouble("total_amount");
                    String buyer = resultSet.getString("buyer");
                    PurchaseHistory purchase = new PurchaseHistory(id, purchaseDate, quantity, totalAmount, buyer);
                    purchaseHistory.add(purchase);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return purchaseHistory;
    }
}
