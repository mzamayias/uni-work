package com.company.View.Dialogs.Files;

public class FilesDialogInventory extends FilesDialog {
    // initialize and declare objects
    static String[] informationElements = {
            "ID",
            "Category",
            "Description",
            "Price",
            "Quantity"
    };
    static String[] tableCharacteristics = {
            "inventory_id",
            "category",
            "description",
            "price",
            "quantity"
    };
    static String query = "SELECT * FROM inventory_logistics.inventory";

    public FilesDialogInventory() {
        super(informationElements, tableCharacteristics, query);
    }
}