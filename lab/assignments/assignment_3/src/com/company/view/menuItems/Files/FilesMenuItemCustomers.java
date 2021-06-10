package com.company.view.menuItems.Files;

import com.company.view.dialogs.Files.FilesDialogCustomers;

import javax.swing.*;

public class FilesMenuItemCustomers extends JMenuItem {
    public FilesMenuItemCustomers() {
        setText("Customers");
        addActionListener(l -> new FilesDialogCustomers());
    }
}
