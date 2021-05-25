package com.company.GUI.Menus;

import com.company.GUI.MenuItems.Files.*;

import javax.swing.JMenu;

public class MenuFiles extends JMenu {
    public MenuFiles() {
        setText("Files");
        add(new FilesInventory());
        add(new FilesCustomers());
        add(new FilesExit());
    }
}
