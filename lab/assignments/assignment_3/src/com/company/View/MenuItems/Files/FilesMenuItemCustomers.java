package com.company.View.MenuItems.Files;

import com.company.View.Dialogs.Files.FilesDialogCustomers;

import javax.swing.*;

public class FilesMenuItemCustomers extends JMenuItem {
    public FilesMenuItemCustomers() {
        setText("Customers");
        addActionListener(l -> new FilesDialogCustomers());
    }
}
