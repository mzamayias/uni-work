package com.company.View.Dialogs.Orders;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerComboModel extends DefaultComboBoxModel<String> {
    private ResultSet resultSet;

    public CustomerComboModel(Connection connection) {
        try {
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            );
            resultSet = statement.executeQuery("SELECT * FROM inventory_logistics.customers;");
        } catch (SQLException e) {
            System.out.println("error querying customers table in customercombomodel");
            e.printStackTrace();
        }
    }

    @Override
    public String getElementAt(int index) {
        String line = null;
        try {
            resultSet.absolute(index + 1);
            line = "%s, %s, %s, %s".formatted(
                    resultSet.getString("last_name"),
                    resultSet.getString("first_name"),
                    resultSet.getString("trn"),
                    resultSet.getString("phone_number")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println(line);
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
            System.out.println("error counting in customercombomodel");
            e.printStackTrace();
        }
        return counter;
    }

    public int getCustomerID(int index) {
        int customer_id = 0;
        try {
            resultSet.absolute(index+1);
            customer_id = resultSet.getInt("customer_id");
        } catch (SQLException e) {
            System.out.println("error getting customer id in customercombomodel");
            e.printStackTrace();
        }
        return customer_id;
    }
}
