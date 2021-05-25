package com.company.GUI.Menus;

import com.company.GUI.MenuItems.Reports.*;

import javax.swing.*;

public class MenuReports extends JMenu {
    public MenuReports() {
        setText("Reports");
        add(new ReportsCustomers());
        add(new ReportsInventory());
        add(new JSeparator());
        add(new ReportsInvoice());
    }
}
