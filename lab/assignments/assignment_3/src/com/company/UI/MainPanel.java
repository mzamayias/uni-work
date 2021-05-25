package com.company.UI;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    public MainPanel() {
        prepareMainPanel();
    }

    private void prepareMainPanel() {
        setLayout(new FlowLayout());
        setSize(600,300);
    }
}
