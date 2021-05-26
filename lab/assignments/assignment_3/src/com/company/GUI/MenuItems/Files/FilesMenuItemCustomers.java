package com.company.GUI.MenuItems.Files;

import com.company.GUI.Dialogs.Files.FilesDialogCustomers;

import javax.swing.*;

public class FilesMenuItemCustomers extends JMenuItem {
    public FilesMenuItemCustomers() {
        setText("Customers");
        addActionListener(l -> new FilesDialogCustomers());
    }
}
