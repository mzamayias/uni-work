package com.company.View.Dialogs.Files;

public class FilesDialogCustomers extends FilesDialog {
    // initialize and declare objects
    static String[] informationElements = {
            "ID",
            "Last Name",
            "First Name",
            "TRN",
            "Phone Number"
    };
    static String[] tableCharacteristics = {
            "customer_id",
            "last_name",
            "first_name",
            "trn",
            "phone_number"
    };
    static String query = "SELECT * FROM inventory_logistics.customers";

    public FilesDialogCustomers() {
        super(informationElements, tableCharacteristics, query);
    }
}