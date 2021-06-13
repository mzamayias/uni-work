package com.company.View.Dialogs.Orders;

import javax.swing.table.AbstractTableModel;
import java.sql.*;

public class TableModel extends AbstractTableModel {
    protected static Connection connection;
    protected static Statement statement;
    protected static ResultSet resultSet;
    protected static String query = "SELECT * FROM inventory_logistics.orders" +
            " LEFT JOIN inventory_logistics.customers ON customers.customer_id=orders.customer_id" +
            " LEFT JOIN inventory_logistics.inventory ON inventory.inventory_id=orders.inventory_id";
    protected static String[] columnNames = {"order_id", "customer_id", "inventory_id", "quantity", "price"};
    protected static String[] informationElements = {"ID", "Customer", "Category", "Description", "Price"};

    public TableModel() {
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "secret";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            resultSet = statement.executeQuery(query);
        } catch (Exception e) {
            //Handle errors for JDBC
            e.printStackTrace();
        }
    }

    @Override
    public int getRowCount() {
        int count = 0;
        try {
            resultSet.last();
            count = resultSet.getRow();
            resultSet.beforeFirst();
        } catch (SQLException e) {
            System.out.println("Model" + e.getMessage());
        }
        return count;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object returnValue = null;
        try {
            resultSet.absolute(rowIndex + 1);
            switch (columnIndex) {
                case 0 -> returnValue = resultSet.getInt(columnNames[0]);
                case 1 -> returnValue = resultSet.getInt(columnNames[1]);
                case 2 -> returnValue = resultSet.getString(columnNames[2]);
                case 3 -> returnValue = resultSet.getString(columnNames[3]);
                case 4 -> returnValue = resultSet.getInt(columnNames[4]);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return returnValue;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column] == null ? "No Name" : columnNames[column];
    }
}
