package com.example.demo4;

import java.util.ArrayList;
import java.util.List;

public class Drug {
    private int id;
    private String name;
    private String description;
    // Other drug-related fields
    private List<drugSupplier> suppliers;
    private List<PurchaseHistory> purchaseHistory;

    public Drug(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        suppliers = new ArrayList<>();
        purchaseHistory = new ArrayList<>();
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<drugSupplier> getSuppliers() {
        return suppliers;
    }

    public List<PurchaseHistory> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Add methods to add suppliers and update purchase history
    public void addSupplier(drugSupplier supplier) {
        suppliers.add(supplier);
    }

    public void addPurchaseHistory(PurchaseHistory purchase) {
        purchaseHistory.add(purchase);
    }
}

