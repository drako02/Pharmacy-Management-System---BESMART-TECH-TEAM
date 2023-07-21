package com.example.demo4;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.*;

public class PurchaseHistoryDialog extends Stage {
    private PharmacyManagementSystem pharmacySystem;

    public PurchaseHistoryDialog(PharmacyManagementSystem pharmacySystem) {
        this.pharmacySystem = pharmacySystem;

        setTitle("Purchase History");
        initModality(Modality.APPLICATION_MODAL);

        // Implement the UI to view purchase history
        // You can display a table or a list of purchase history records
    }
}
