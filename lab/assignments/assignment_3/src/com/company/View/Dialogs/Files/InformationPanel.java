package com.company.View.Dialogs.Files;

import javax.swing.*;
import java.awt.*;

public class InformationPanel extends JPanel {
    public InformationPanel(String elementName) {
        prepareElementPanel(elementName);
    }

    private void prepareElementPanel(String elementName) {
        setLayout(new GridLayout(1, 2));

        JLabel label = new JLabel(elementName, SwingConstants.RIGHT);
        add(label);

        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(270, 12));
        add(textField);
    }
}
