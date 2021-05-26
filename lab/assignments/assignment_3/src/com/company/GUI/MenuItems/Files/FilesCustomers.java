package com.company.GUI.MenuItems.Files;

import com.company.GUI.Dialogs.DialogCustomers;

import javax.swing.*;

public class FilesCustomers extends JMenuItem {
    public FilesCustomers() {
        setText("Customers");
        addActionListener(l -> new DialogCustomers());
    }
}
