package com.company.View.MenuItems.Files;

import com.company.View.Dialogs.Files.FilesDialogInventory;

import javax.swing.*;

public class FilesMenuItemInventory extends JMenuItem {
    public FilesMenuItemInventory() {
        setText("Inventory");
        addActionListener(l -> new FilesDialogInventory());
    }
}
