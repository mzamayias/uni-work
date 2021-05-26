package com.company.GUI.MenuItems.Files;

import javax.swing.JMenuItem;

public class FilesMenuItemExit extends JMenuItem{
    public FilesMenuItemExit() {
        setText("Exit");
        addActionListener(l -> System.exit(0));
    }
}
