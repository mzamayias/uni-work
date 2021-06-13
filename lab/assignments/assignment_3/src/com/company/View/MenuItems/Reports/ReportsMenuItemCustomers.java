package com.company.View.MenuItems.Reports;

import com.company.View.Dialogs.Reports.ReportsInvoiceCustomers;

import javax.swing.JMenuItem;

public class ReportsMenuItemCustomers extends JMenuItem {
    public ReportsMenuItemCustomers() {
        setText("Customers");
        addActionListener(l -> new ReportsInvoiceCustomers());
    }
}
