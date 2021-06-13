package com.company.View.MenuItems.Reports;

import com.company.View.Dialogs.Reports.ReportsInvoiceInvoice;

import javax.swing.JMenuItem;

public class ReportsMenuItemInvoice extends JMenuItem {
    public ReportsMenuItemInvoice() {
        setText("Invoice");
        addActionListener(l -> new ReportsInvoiceInvoice());
    }
}
