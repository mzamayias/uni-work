package com.company.View.Menus;

import com.company.View.MenuItems.Help.HelpMenuItemAbout;

import javax.swing.JMenu;

public class HelpMenu extends JMenu {
    public HelpMenu() {
        setText("Help");
        add(new HelpMenuItemAbout());
    }
}
