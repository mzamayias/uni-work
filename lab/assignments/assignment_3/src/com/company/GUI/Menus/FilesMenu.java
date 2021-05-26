package com.company.GUI.Menus;

import com.company.GUI.MenuItems.Files.*;

import javax.swing.JMenu;

public class FilesMenu extends JMenu {
    public FilesMenu() {
        setText("Files");
        add(new FilesMenuItemInventory());
        add(new FilesMenuItemCustomers());
        add(new FilesMenuItemExit());
    }
}
