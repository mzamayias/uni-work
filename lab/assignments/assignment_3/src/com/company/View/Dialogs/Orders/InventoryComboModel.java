package com.company.View.Dialogs.Orders;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InventoryComboModel extends DefaultComboBoxModel<String> {
    private ResultSet resultSet;

    public InventoryComboModel(Connection connection) {
        try {
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            );
            resultSet = statement.executeQuery("SELECT * FROM inventory_logistics.inventory;");
        } catch (SQLException e) {
            System.out.println("error querying customers table in inventorycombomodel");
            e.printStackTrace();
        }
    }

    @Override
    public String getElementAt(int index) {
        String line = null;
        try {
            resultSet.absolute(index + 1);
            line = "%s, %s, %s, %s".formatted(
                    resultSet.getString("category"),
                    resultSet.getString("description"),
                    resultSet.getString("quantity"),
                    resultSet.getString("price")
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
            System.out.println("error counting in inventorycombomodel");
            e.printStackTrace();
        }
        return counter;
    }

    public int getCustomerID(int index) {
        int customer_id = 0;
        try {
            resultSet.absolute(index+1);
            customer_id = resultSet.getInt("inventory_id");
        } catch (SQLException e) {
            System.out.println("error getting customer id in inventorycombomodel");
            e.printStackTrace();
        }
        return customer_id;
    }
}
