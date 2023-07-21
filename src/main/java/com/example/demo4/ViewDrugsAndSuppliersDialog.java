package com.example.demo4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ViewDrugsAndSuppliersDialog extends Stage {
    private PharmacyManagementSystem pharmacySystem;

    public ViewDrugsAndSuppliersDialog(PharmacyManagementSystem pharmacySystem) {
        this.pharmacySystem = pharmacySystem;

        setTitle("All Drugs and Suppliers");
        initModality(Modality.APPLICATION_MODAL);

        TableView<Drug> drugTable = new TableView<>();
        TableColumn<Drug, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Drug, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Drug, String> descriptionColumn = new TableColumn<>("Description");
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Drug, String> suppliersColumn = new TableColumn<>("Suppliers");
        suppliersColumn.setCellValueFactory(cellData -> {
            Drug drug = cellData.getValue();
            StringBuilder suppliers = new StringBuilder();
            for (drugSupplier supplier : drug.getSuppliers()) {
                suppliers.append(supplier.getName()).append(", ");
            }
            return new javafx.beans.property.SimpleStringProperty(suppliers.toString());
        });

        drugTable.getColumns().addAll(idColumn, nameColumn, descriptionColumn, suppliersColumn);

        ObservableList<Drug> drugsData = FXCollections.observableArrayList(pharmacySystem.getAllDrugsWithSuppliers());
        drugTable.setItems(drugsData);

        VBox layout = new VBox(10);
        layout.getChildren().add(drugTable);

        Scene scene = new Scene(layout);
        setScene(scene);
    }
}

