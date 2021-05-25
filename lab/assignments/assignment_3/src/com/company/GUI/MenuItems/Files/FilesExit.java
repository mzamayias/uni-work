package com.company.GUI.MenuItems.Files;

import javax.swing.JMenuItem;

public class FilesExit extends JMenuItem{
    public FilesExit() {
        setText("Exit");
        addActionListener(l -> System.exit(0));
    }
}
