package com.company.controller;

import java.sql.*;

public class DatabaseConnector {
    public static void databaseConnector() {
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "secret";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            String sqlQuery = "select * from inventory_logistics.customers;";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                System.out.printf(
                        "%s %s\n",
                        resultSet.getString("first_name"), resultSet.getString("last_name")
                );
            }
        } catch (
                SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
