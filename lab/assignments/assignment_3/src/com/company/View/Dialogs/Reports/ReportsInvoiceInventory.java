package com.company.View.Dialogs.Reports;

public class ReportsInvoiceInventory extends ReportsInvoiceDialog {
    private static final String table = "inventory";
    private static final String[] columnNames = {"ID", "Category", "Description", "Price", "Quantity"};

    public ReportsInvoiceInventory() {
        super(table, columnNames);
    }
}
