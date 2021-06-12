package com.company.View.Dialogs.Files;

import javax.swing.*;
import java.awt.*;

public class InformationPanel extends JPanel {
    private final JLabel label = new JLabel();
    private final JTextField textField = new JTextField();

    public InformationPanel(String elementName) {
        prepareElementPanel(elementName);
    }

    private void prepareElementPanel(String elementName) {
        setLayout(new GridLayout(1, 2));

        label.setText(elementName);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label);

        textField.setPreferredSize(new Dimension(270, 12));
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
