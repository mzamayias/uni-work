package com.company.view.Menus;

import com.company.view.MenuItems.Help.HelpMenuItemAbout;

import javax.swing.JMenu;

public class HelpMenu extends JMenu {
    public HelpMenu() {
        setText("Help");
        add(new HelpMenuItemAbout());
    }
}
