package com.example.demo4;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.*;

public class AddDrugDialog extends Stage {
    private PharmacyManagementSystem pharmacySystem;
    private DatabaseHandler databaseHandler;

    public AddDrugDialog(PharmacyManagementSystem pharmacySystem, DatabaseHandler databaseHandler) {
        this.pharmacySystem = pharmacySystem;
        this.databaseHandler = databaseHandler;

        setTitle("Add Drug");
        initModality(Modality.APPLICATION_MODAL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new javafx.geometry.Insets(10));

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        Label descriptionLabel = new Label("Description:");
        TextField descriptionField = new TextField();

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> {
            String name = nameField.getText();
            String description = descriptionField.getText();
            if (!name.isEmpty() && !description.isEmpty()) {
                Drug drug = new Drug(0, name, description);
                databaseHandler.addDrug(drug);
                pharmacySystem.addDrug(drug);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setContentText("Drug added successfully!");
                alert.showAndWait();
                close();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Please enter drug name and description.");
                alert.showAndWait();
            }
        });

        HBox buttonBox = new HBox(10, addButton);
        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(descriptionLabel, 0, 1);
        grid.add(descriptionField, 1, 1);
        grid.add(buttonBox, 1, 2);

        Scene scene = new Scene(grid);
        setScene(scene);
    }
}
