package com.company.View.MenuItems.Help;

import com.company.View.Dialogs.Help.HelpDialogAbout;

import javax.swing.JMenuItem;

public class HelpMenuItemAbout extends JMenuItem {
    public HelpMenuItemAbout() {
        setText("About");
        addActionListener(l -> new HelpDialogAbout());
    }
}
