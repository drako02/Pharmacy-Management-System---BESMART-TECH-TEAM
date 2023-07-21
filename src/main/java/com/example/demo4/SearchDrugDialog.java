package com.example.demo4;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.*;

public class SearchDrugDialog extends Stage {
    private PharmacyManagementSystem pharmacySystem;

    public SearchDrugDialog(PharmacyManagementSystem pharmacySystem) {
        this.pharmacySystem = pharmacySystem;

        setTitle("Search Drug");
        initModality(Modality.APPLICATION_MODAL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new javafx.geometry.Insets(10));

        Label nameLabel = new Label("Drug Name:");
        TextField nameField = new TextField();

        Button searchButton = new Button("Search");
        searchButton.setOnAction(e -> {
            String name = nameField.getText();
            if (!name.isEmpty()) {
                Drug drug = pharmacySystem.searchDrug(name);
                if (drug != null) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Result");
                    alert.setHeaderText(drug.getName());
                    alert.setContentText("Description: " + drug.getDescription());
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Result");
                    alert.setHeaderText("Drug not found");
                    alert.setContentText("The drug with the specified name was not found.");
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Please enter a drug name.");
                alert.showAndWait();
            }
        });

        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(searchButton, 1, 1);

        Scene scene = new Scene(grid);
        setScene(scene);
    }
}
