package com.company;

import com.company.singletons.DatabaseConnection;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from actor");
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            System.out.println("No. of columns : " + resultSetMetaData.getColumnCount());
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                String columnName = resultSetMetaData.getColumnName(i);
                String getColumnTypeName = resultSetMetaData.getColumnTypeName(i);
                System.out.printf("%-20s | %-20s%n", columnName, getColumnTypeName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
