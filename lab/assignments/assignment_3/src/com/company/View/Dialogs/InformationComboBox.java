package com.company.View.Dialogs;

import com.company.View.Dialogs.Orders.CustomComboBoxModel;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InformationComboBox extends JPanel {
    private final JLabel label = new JLabel();
    private final JComboBox<String> comboBox = new JComboBox<>();
    private Connection connection;

    public InformationComboBox(String elementName, String query, String[] columnNames) {
        databaseConnection();
        prepareElementPanel(elementName, query, columnNames);
    }

    private void prepareElementPanel(String elementName, String query, String[] columnNames) {
        // panel preferences
        setLayout(new GridLayout(1, 2));

        // label preferences
        label.setText(elementName);
        label.setHorizontalAlignment(SwingConstants.RIGHT);

        // combobox preferences
        comboBox.setPreferredSize(new Dimension(270, 12));
        comboBox.setModel(new CustomComboBoxModel(connection, query, columnNames));
        comboBox.setSelectedIndex(0);
        comboBox.addActionListener(l -> refreshLabel());

        // add label and combobox to panel
        add(label);
        add(comboBox);
    }

    protected void databaseConnection() {
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "secret";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            String message = "\"com.mysql.cj.jdbc.Driver\" is missing.";
            JOptionPane.showMessageDialog(this, message, "Database Connection", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            String message = "Error connecting to database:\n" + e.getMessage();
            JOptionPane.showMessageDialog(this, message, "Database Connection", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void refreshLabel() {
        label.setText((String) comboBox.getSelectedItem());
    }
}
