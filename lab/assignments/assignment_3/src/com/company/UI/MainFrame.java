package com.company.UI;

import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        prepareFrame();
    }

    private void prepareFrame() {
        JPanel mainPanel = new MainPanel();
        add(mainPanel);

        setTitle("Invoices");
        setSize(600,300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }
}
