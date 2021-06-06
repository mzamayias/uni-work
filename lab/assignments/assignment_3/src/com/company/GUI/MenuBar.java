package com.company.GUI;

import com.company.GUI.Menus.FilesMenu;
import com.company.GUI.Menus.HelpMenu;
import com.company.GUI.Menus.OrdersMenu;
import com.company.GUI.Menus.ReportsMenu;

import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar {
    public MenuBar() {
        add(new FilesMenu());
        add(new OrdersMenu());
        add(new ReportsMenu());
        add(new HelpMenu());
    }
}
