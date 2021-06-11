package com.company.View.Menus;

import com.company.View.MenuItems.Reports.*;

import javax.swing.*;

public class ReportsMenu extends JMenu {
    public ReportsMenu() {
        setText("Reports");
        add(new ReportsMenuItemCustomers());
        add(new ReportsMenuItemInventory());
        add(new JSeparator());
        add(new ReportsMenuItemInvoice());
    }
}
