package com.example.demo4;

import java.util.Date;

public class PurchaseHistory {
    private int id;
    private Date purchaseDate;
    private int quantity;
    private double totalAmount;
    private String buyer;

    public PurchaseHistory(int id, Date purchaseDate, int quantity, double totalAmount, String buyer) {
        this.id = id;
        this.purchaseDate = purchaseDate;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.buyer = buyer;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }
}
