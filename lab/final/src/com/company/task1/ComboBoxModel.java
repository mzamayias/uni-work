package com.company.task1;

import com.company.singletons.DatabaseConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ComboBoxModel extends DefaultComboBoxModel<String> {
    private ResultSet resultSet;

    public ComboBoxModel() {
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            );
            resultSet = statement.executeQuery("SELECT address_id, district, address FROM sakila.address ORDER BY district;");
        } catch (SQLException e) {
            System.out.println("Error querying address table in ComboBoxModel");
            e.printStackTrace();
        }
    }

    @Override
    public String getElementAt(int index) {
        String line = null;
        try {
            resultSet.absolute(index + 1);
            line = "%s, %s, %s".formatted(
                    resultSet.getString("address_id"),
                    resultSet.getString("district"),
                    resultSet.getString("address")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return line;
    }

    @Override
    public int getSize() {
        int counter = 0;
        try {
            resultSet.last();
            counter = resultSet.getRow();
        } catch (SQLException e) {
            System.out.println("Error counting in ComboBoxModel");
            e.printStackTrace();
        }
        return counter;
    }
}
