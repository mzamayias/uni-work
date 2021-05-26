package com.company.GUI.Menus;

import com.company.GUI.MenuItems.Help.HelpMenuItemAbout;

import javax.swing.JMenu;

public class HelpMenu extends JMenu {
    public HelpMenu() {
        setText("Help");
        add(new HelpMenuItemAbout());
    }
}
