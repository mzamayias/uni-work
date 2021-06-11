package com.company.View;

import com.company.View.Menus.FilesMenu;
import com.company.View.Menus.HelpMenu;
import com.company.View.Menus.OrdersMenu;
import com.company.View.Menus.ReportsMenu;

import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar {
    public MenuBar() {
        add(new FilesMenu());
        add(new OrdersMenu());
        add(new ReportsMenu());
        add(new HelpMenu());
    }
}
