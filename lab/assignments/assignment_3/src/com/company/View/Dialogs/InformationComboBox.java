package com.company.View.Dialogs;

import javax.swing.*;
import java.awt.*;

public class InformationComboBox extends JPanel {
    private final JLabel label = new JLabel();
    private final JComboBox<String> comboBox = new JComboBox<String>();

    public InformationComboBox(String elementName) {
        prepareElementPanel(elementName);
    }

    private void prepareElementPanel(String elementName) {
        setLayout(new GridLayout(1, 2));

        label.setText(elementName);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label);

        comboBox.setPreferredSize(new Dimension(270, 12));
        add(comboBox);
    }

    public void setEditable(boolean editable) {
        comboBox.setEditable(editable);
    }
}
