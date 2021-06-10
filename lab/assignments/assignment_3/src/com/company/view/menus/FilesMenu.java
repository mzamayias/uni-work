package com.company.view.menus;

import com.company.view.menuItems.Files.*;

import javax.swing.JMenu;

public class FilesMenu extends JMenu {
    public FilesMenu() {
        setText("Files");
        add(new FilesMenuItemInventory());
        add(new FilesMenuItemCustomers());
        add(new FilesMenuItemExit());
    }
}
