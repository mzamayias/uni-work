package com.company.GUI;

import com.company.GUI.Menus.MenuFiles;
import com.company.GUI.Menus.MenuHelp;
import com.company.GUI.Menus.MenuPurchases;
import com.company.GUI.Menus.MenuReports;

import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar {
    public MenuBar() {
        add(new MenuFiles());
        add(new MenuPurchases());
        add(new MenuReports());
        add(new MenuHelp());
    }
}
