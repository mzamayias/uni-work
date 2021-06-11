package com.company.View.Menus;

import com.company.View.MenuItems.Files.*;

import javax.swing.JMenu;

public class FilesMenu extends JMenu {
    public FilesMenu() {
        setText("Files");
        add(new FilesMenuItemInventory());
        add(new FilesMenuItemCustomers());
        add(new FilesMenuItemExit());
    }
}
