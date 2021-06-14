package com.company.View.Dialogs;

import javax.swing.*;
import java.awt.*;

public class InformationTextField extends JPanel {
    private final JLabel label = new JLabel();
    private final JTextField textField = new JTextField();

    public InformationTextField(String elementName) {
        prepareElementPanel(elementName);
    }

    public InformationTextField(String elementName, String elementText) {
        prepareElementPanel(elementName, elementText);
    }

    private void prepareElementPanel(String elementName) {
        setLayout(new GridLayout(1, 2));

        label.setText(elementName);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label);

        textField.setPreferredSize(new Dimension(270, 15));
        add(textField);
    }

    private void prepareElementPanel(String elementName, String elementText) {
        setLayout(new GridLayout(1, 2));

        label.setText(elementName);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label);

        textField.setPreferredSize(new Dimension(270, 15));
        textField.setText(elementText);
        add(textField);
    }

    public void setEditable(boolean editable) {
        textField.setEditable(editable);
    }

    public void setText(String text) {
        textField.setText(text);
    }

    public String getText() throws NullPointerException {
        return textField.getText();
    }
}
