package com.company.view.menus;

import com.company.view.menuItems.Help.HelpMenuItemAbout;

import javax.swing.JMenu;

public class HelpMenu extends JMenu {
    public HelpMenu() {
        setText("Help");
        add(new HelpMenuItemAbout());
    }
}
