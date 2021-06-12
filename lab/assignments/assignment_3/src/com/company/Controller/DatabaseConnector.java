package com.company.Controller;

import java.sql.*;

public class DatabaseConnector {
    public static void databaseConnector() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet;

        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "secret";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            resultSet = statement.executeQuery("SELECT * FROM inventory_logistics.customers");

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}