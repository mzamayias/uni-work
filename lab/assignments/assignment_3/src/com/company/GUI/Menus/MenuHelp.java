package com.company.GUI.Menus;

import com.company.GUI.MenuItems.Help.HelpAbout;

import javax.swing.JMenu;

public class MenuHelp extends JMenu {
    public MenuHelp() {
        setText("Help");
        add(new HelpAbout());
    }
}
