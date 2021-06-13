package com.company.View.Dialogs.Orders;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrdersComboModelInventory extends DefaultComboBoxModel<String> {
    private ResultSet resultSet;

    public OrdersComboModelInventory(Connection connection) {
        try {
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            );
            resultSet = statement.executeQuery("SELECT * FROM inventory_logistics.inventory;");
        } catch (SQLException e) {
            System.out.println("error querying customers table in InventoryComboModel");
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
            System.out.println("error counting in InventoryComboModel");
            e.printStackTrace();
        }
        return counter;
    }
}
