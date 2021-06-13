package com.company.View.Dialogs.Reports;

import com.company.View.Dialogs.BaseDialog;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReportsInvoiceDialog extends BaseDialog {
    private static String table;
    private static String[] columnNames = new String[5];
    private ResultSet resultSet = null;

    public ReportsInvoiceDialog(String table, String[] columnNames) {
        super(new Dimension(240, 69));
        databaseConnection();
        ReportsInvoiceDialog.table = table;
        ReportsInvoiceDialog.columnNames = columnNames;
        improveBaseDialog();
    }

    private void improveBaseDialog() {
        // initialize and declare objects
        JPanel backPanel = new JPanel(new FlowLayout());
        JButton button = new JButton();

        // set dialog preferences
        if (table.equals("inventory")) {
            setTitle("Print Inventory Items");
            button.setText("Print Inventory Items");
        } else if (table.equals("customers")) {
            setTitle("Print Customers");
            button.setText("Print Customers");
        }

        // add panel to base dialog
        backPanel.add(button);
        add(backPanel, BorderLayout.CENTER);

        // add action to button
        button.addActionListener(l -> printTable());
    }

    private void printTable() {
        try {
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            );
            resultSet = statement.executeQuery("SELECT * FROM inventory_logistics.%s;".formatted(table));
        } catch (SQLException e) {
            System.out.printf("error querying customers table %s in ReportsInvoiceCustomers%n", table);
            e.printStackTrace();
        }
        try {
            System.out.printf(
                    "%6s %-20s %-20s %-20s %-20s\n",
                    columnNames[0],
                    columnNames[1],
                    columnNames[2],
                    columnNames[3],
                    columnNames[4]
            );
            prettyPrint(resultSet);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    static void prettyPrint(ResultSet resultSet) throws SQLException {
        for (int i = 0; i < 84; i++)
            System.out.print("=");
        System.out.println();
        while (resultSet.next()) {
            System.out.printf(
                    "%6s  %-20s %-20s %-20s %-20s\n",
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            );
        }
        for (int i = 0; i < 84; i++)
            System.out.print("=");
        System.out.println();
    }
}
