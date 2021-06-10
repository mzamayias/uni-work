package com.company.view.menuItems.Help;

import com.company.view.dialogs.Help.HelpDialogAbout;

import javax.swing.JMenuItem;

public class HelpMenuItemAbout extends JMenuItem {
    public HelpMenuItemAbout() {
        setText("About");
        addActionListener(l -> new HelpDialogAbout());
    }
}
