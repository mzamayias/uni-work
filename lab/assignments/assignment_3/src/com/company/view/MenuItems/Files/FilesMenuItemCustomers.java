package com.company.view.MenuItems.Files;

import com.company.view.Dialogs.Files.FilesDialogCustomers;

import javax.swing.*;

public class FilesMenuItemCustomers extends JMenuItem {
    public FilesMenuItemCustomers() {
        setText("Customers");
        addActionListener(l -> new FilesDialogCustomers());
    }
}
