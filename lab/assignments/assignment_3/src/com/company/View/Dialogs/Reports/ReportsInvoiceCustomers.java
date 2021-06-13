package com.company.View.Dialogs.Reports;

public class ReportsInvoiceCustomers extends ReportsInvoiceDialog {
    private static final String table = "customers";
    private static final String[] columnNames = {"ID", "Last name", "First name", "TRN", "Phone number"};

    public ReportsInvoiceCustomers() {
        super(table, columnNames);
    }
}
