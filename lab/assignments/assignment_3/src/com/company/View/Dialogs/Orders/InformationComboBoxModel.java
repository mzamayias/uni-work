package com.company.View.Dialogs.Orders;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InformationComboBoxModel extends DefaultComboBoxModel<String> {
    protected static String[] columnNames = new String[5];
    private ResultSet resultSet;

    public InformationComboBoxModel(Connection connection, String query, String[] columnNames) {
        try {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("CustomComboBoxModel: " + e.getMessage());
        }
        InformationComboBoxModel.columnNames = columnNames;
    }

    @Override
    public String getElementAt(int index) {
        String line = null;
        try {
            resultSet.absolute(index + 1);
            line = resultSet.getString(columnNames[1]) +
                    ", " + resultSet.getString(columnNames[2]) +
                    ", " + resultSet.getString(columnNames[3]) +
                    ", " + resultSet.getString(columnNames[4]);
            System.out.println(line);
        } catch (SQLException e) {
            System.out.println(line);
            System.out.println("getElementAt(): " + e.getMessage());
        }
        return line;
    }

    @Override
    public int getSize() {
        int counter = 0;
        try {
            resultSet.last();
            counter = resultSet.getRow();
        } catch (SQLException ex) {
            System.out.println("getSize(): " + ex.getMessage());
        }
        return counter;
    }
}
