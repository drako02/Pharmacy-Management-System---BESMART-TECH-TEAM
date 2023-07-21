package com.example.demo4;

import java.util.ArrayList;
import java.util.List;

public class PharmacyManagementSystem {
    private List<Drug> drugs;

    public PharmacyManagementSystem() {
        drugs = new ArrayList<>();
    }

    // Method to add drugs
    public void addDrug(Drug drug) {
        drugs.add(drug);
    }

    // Method to search for a drug by name
    public Drug searchDrug(String drugName) {
        for (Drug drug : drugs) {
            if (drug.getName().equalsIgnoreCase(drugName)) {
                return drug;
            }
        }
        return null;
    }

    // Method to get all drugs and their suppliers
    public List<Drug> getAllDrugsWithSuppliers() {
        return drugs;
    }

    // Method to get purchase history for a drug
    public List<PurchaseHistory> getPurchaseHistoryForDrug(Drug drug) {
        return drug.getPurchaseHistory();
    }
}
