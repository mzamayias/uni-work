package com.company.View.Dialogs.Orders;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UniversalComboBox extends JPanel {
    private final JLabel label = new JLabel();
    private final JComboBox<String> comboBox = new JComboBox<>();

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
        comboBox.setPreferredSize(new Dimension(300, 15));
        comboBox.setModel(comboBoxModel);
        comboBox.setEditable(false);
        comboBox.setSelectedIndex(0);
        System.out.printf("%s, %s%n", elementName, comboBox.getSelectedIndex());

        // add label and combobox to panel
        add(label);
        add(comboBox);
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
            Connection connection = DriverManager.getConnection(url, user, password);
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
}
