package com.company.view;

import com.company.view.menus.FilesMenu;
import com.company.view.menus.HelpMenu;
import com.company.view.menus.OrdersMenu;
import com.company.view.menus.ReportsMenu;

import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar {
    public MenuBar() {
        add(new FilesMenu());
        add(new OrdersMenu());
        add(new ReportsMenu());
        add(new HelpMenu());
    }
}
