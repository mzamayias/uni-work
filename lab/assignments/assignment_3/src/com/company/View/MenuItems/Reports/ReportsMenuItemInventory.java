package com.company.View.MenuItems.Reports;

import com.company.View.Dialogs.Reports.ReportsInvoiceCustomers;

import javax.swing.JMenuItem;

public class ReportsMenuItemInventory extends JMenuItem {
    public ReportsMenuItemInventory() {
        setText("Inventory");
        addActionListener(l -> new ReportsInvoiceCustomers());
    }
}
