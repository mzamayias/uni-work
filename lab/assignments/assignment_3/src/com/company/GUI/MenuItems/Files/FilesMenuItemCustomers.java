package com.company.GUI.MenuItems.Files;

import com.company.GUI.Dialogs.FilesDialogCustomers;

import javax.swing.*;

public class FilesMenuItemCustomers extends JMenuItem {
    public FilesMenuItemCustomers() {
        setText("Customers");
        addActionListener(l -> new FilesDialogCustomers());
    }
}
