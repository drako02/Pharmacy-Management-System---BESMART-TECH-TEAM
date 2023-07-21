package com.example.demo4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApplication extends Application {
    private PharmacyManagementSystem pharmacySystem;
    private DatabaseHandler databaseHandler;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        pharmacySystem = new PharmacyManagementSystem();
        databaseHandler = new DatabaseHandler();

        primaryStage.setTitle("Pharmacy Management System");
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        Scene scene = new Scene(root, 300, 200);

        Button addDrugButton = new Button("Add Drug");
        addDrugButton.setOnAction(e -> openAddDrugDialog());

        Button searchDrugButton = new Button("Search Drug");
        searchDrugButton.setOnAction(e -> openSearchDrugDialog());

        Button viewDrugsButton = new Button("View All Drugs and Suppliers");
        viewDrugsButton.setOnAction(e -> viewAllDrugsAndSuppliers());

        Button viewPurchaseHistoryButton = new Button("View Purchase History");
        viewPurchaseHistoryButton.setOnAction(e -> openPurchaseHistoryDialog());

        root.getChildren().addAll(addDrugButton, searchDrugButton, viewDrugsButton, viewPurchaseHistoryButton);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void openAddDrugDialog() {
        AddDrugDialog dialog = new AddDrugDialog(pharmacySystem, databaseHandler);
        dialog.show();
    }

    private void openSearchDrugDialog() {
        SearchDrugDialog dialog = new SearchDrugDialog(pharmacySystem);
        dialog.show();
    }

    private void viewAllDrugsAndSuppliers() {
        ViewDrugsAndSuppliersDialog dialog = new ViewDrugsAndSuppliersDialog(pharmacySystem);
        dialog.show();

        // Display all drugs and suppliers in a new window
        // You can implement this based on your UI design
    }

    private void openPurchaseHistoryDialog() {
        PurchaseHistoryDialog dialog = new PurchaseHistoryDialog(pharmacySystem);
        dialog.show();
    }
}
