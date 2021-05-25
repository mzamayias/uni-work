package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/purchases";
        String user = "root";
        String password = "secret";
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            String sqlQuery = "select * from `customer`;";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                System.out.printf(
                        "%s %s\n",
                        resultSet.getString("first_name"), resultSet.getString("last_name")
                );
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
