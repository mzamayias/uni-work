package com.company.View.Dialogs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UniversalComboBox extends JPanel {
    private final JLabel label = new JLabel();
    private JComboBox<String> comboBox;
    private Connection connection;
    public ActionListener l;
    private String rowIndex;

    public UniversalComboBox(String elementName, DefaultComboBoxModel<String> comboBoxModel) {
        databaseConnection();
        prepareElementPanel(elementName, comboBoxModel);
    }

    private void prepareElementPanel(String elementName, DefaultComboBoxModel<String> comboBoxModel) {
        // panel preferences
        setLayout(new GridLayout(1, 2));

        // label preferences
        label.setText(elementName);
        label.setHorizontalAlignment(SwingConstants.RIGHT);

        // combobox preferences
        comboBox = new JComboBox<>(comboBoxModel);
        comboBox.setEditable(false);
        comboBox.setSelectedIndex(0);

        // add label and combobox to panel
        add(label);
        add(comboBox);

//        comboBox.addActionListener(l -> System.out.println(getSelectedItemIndex()));
    }

    private void databaseConnection() {
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "secret";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            String message = "\"com.mysql.cj.jdbc.Driver\" is missing.";
            JOptionPane.showMessageDialog(
                    this,
                    message,
                    "Database Connection",
                    JOptionPane.ERROR_MESSAGE
            );
            System.exit(1);
        }
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            String message = "Error connecting to database:\n" + e.getMessage();
            JOptionPane.showMessageDialog(
                    this,
                    message,
                    "Database Connection",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public String[] getSelectedItemAsStringArray() {
        return "%s".formatted(comboBox.getSelectedItem()).split(", ");
    }

    public String getSelectedItemIndex() {
        // you could argue it's jerry rigged, and i'd say it works just fine
        String[] array = getSelectedItemAsStringArray();
        return array[array.length - 1];
    }

    public void doAddActionListener(ActionListener l) {
        // taken from `JComboBox.java`
        comboBox.addActionListener(l);
    }
}
