package com.company.GUI.MenuItems.Help;

import com.company.GUI.Dialogs.Help.HelpDialogAbout;

import javax.swing.JMenuItem;

public class HelpMenuItemAbout extends JMenuItem {
    public HelpMenuItemAbout() {
        setText("About");
        addActionListener(l -> new HelpDialogAbout());
    }
}
