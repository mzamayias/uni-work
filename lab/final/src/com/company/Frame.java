package com.company;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame() throws HeadlessException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(270,150));
        setResizable(false);
        setVisible(true);
        pack();
    }
}
