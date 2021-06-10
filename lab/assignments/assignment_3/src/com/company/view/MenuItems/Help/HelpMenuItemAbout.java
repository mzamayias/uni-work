package com.company.view.MenuItems.Help;

import com.company.view.Dialogs.Help.HelpDialogAbout;

import javax.swing.JMenuItem;

public class HelpMenuItemAbout extends JMenuItem {
    public HelpMenuItemAbout() {
        setText("About");
        addActionListener(l -> new HelpDialogAbout());
    }
}
