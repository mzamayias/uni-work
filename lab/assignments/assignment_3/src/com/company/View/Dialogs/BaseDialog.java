package com.company.View.Dialogs;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class BaseDialog extends JDialog {
    protected Connection connection = null;

    public BaseDialog() {
        setPreferredSize(new Dimension(390, 270));
        prepareBaseDialog();
    }

    public BaseDialog(Dimension dimension) {
        setPreferredSize(dimension);
        prepareBaseDialog();
    }

    private void prepareBaseDialog(){
//        setAlwaysOnTop(true);
        setLayout(new BorderLayout(6, 3));
        setVisible(true);
        setResizable(false);
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL); // setModal(true); is deprecated
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        pack();
    }

    protected void databaseConnection() {
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "secret";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            String message = "\"com.mysql.cj.jdbc.Driver\" is missing.";
            JOptionPane.showMessageDialog(this, message, this.getTitle(), JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            String message = "Error connecting to database:\n" + e.getMessage();
            JOptionPane.showMessageDialog(this, message, this.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    protected static void closeDatabase(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                if (!resultSet.isClosed()) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                if (!statement.isClosed()) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
