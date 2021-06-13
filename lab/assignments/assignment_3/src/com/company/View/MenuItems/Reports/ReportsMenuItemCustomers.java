package com.company.View.MenuItems.Reports;

import com.company.View.Dialogs.Reports.ReportsInvoiceCustomers;

import javax.swing.JMenuItem;
import java.awt.*;

public class ReportsMenuItemCustomers extends JMenuItem {
    public ReportsMenuItemCustomers() {
        setText("Customers");
        addActionListener(l -> new ReportsInvoiceCustomers());
    }
}
