package com.company.view.Menus;

import com.company.view.MenuItems.Files.*;

import javax.swing.JMenu;

public class FilesMenu extends JMenu {
    public FilesMenu() {
        setText("Files");
        add(new FilesMenuItemInventory());
        add(new FilesMenuItemCustomers());
        add(new FilesMenuItemExit());
    }
}
