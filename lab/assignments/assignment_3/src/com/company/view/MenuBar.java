package com.company.view;

import com.company.view.Menus.FilesMenu;
import com.company.view.Menus.HelpMenu;
import com.company.view.Menus.OrdersMenu;
import com.company.view.Menus.ReportsMenu;

import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar {
    public MenuBar() {
        add(new FilesMenu());
        add(new OrdersMenu());
        add(new ReportsMenu());
        add(new HelpMenu());
    }
}
