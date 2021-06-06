package com.company.GUI;

import javax.swing.*;

public class Frame extends JFrame {
    public Frame() {
        setJMenuBar(new MenuBar());
        setTitle("Inventory Logistics");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setVisible(true);
        pack();
    }
}
