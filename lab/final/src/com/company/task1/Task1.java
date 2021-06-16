package com.company.task1;

import javax.swing.*;
import java.awt.*;

public class Task1 {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel(new BorderLayout());
    JComboBox<String> comboBox = new JComboBox<>(new ComboBoxModel());
    JTextArea textArea = new JTextArea();

    public Task1() {
        createGUI();
        addEntryToTextArea();
    }

    private void addEntryToTextArea() {
        comboBox.addActionListener(l -> {
            String newEntry = "%s\n".formatted(comboBox.getSelectedItem());
            textArea.append(newEntry);
        });
    }

    private void createGUI() {
        setFramePreferences();
        textArea.setEditable(false);
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(comboBox, BorderLayout.NORTH);
        frame.add(panel);
    }

    private void setFramePreferences() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(270,150));
        frame.setResizable(false);
        frame.setVisible(true);
        frame.pack();
    }
}
