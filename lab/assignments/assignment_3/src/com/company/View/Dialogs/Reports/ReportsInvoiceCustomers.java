package com.company.View.Dialogs.Reports;

import com.company.View.Dialogs.BaseDialog;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReportsInvoiceCustomers extends BaseDialog {
    private ResultSet resultSet = null;

    public ReportsInvoiceCustomers() {
        super(new Dimension(240, 69));
        databaseConnection();
        improveBaseDialog();
    }

    private void improveBaseDialog() {
        // initialize and declare objects
        JPanel backPanel = new JPanel(new FlowLayout());
        JButton button = new JButton("Print Customers");

        // add panel to base dialog
        backPanel.add(button);
        add(backPanel, BorderLayout.CENTER);

        // base dialog preferences
        setTitle("Print Customers");

        // add action to button
        button.addActionListener(l -> printCustomers());
    }

    private void printCustomers() {
        try {
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            );
            resultSet = statement.executeQuery("SELECT * FROM inventory_logistics.customers;");
        } catch (SQLException e) {
            System.out.println("error querying customers table in ReportsInvoiceCustomers");
            e.printStackTrace();
        }
        try {
            System.out.printf(
                    "%6s %-20s %-20s %-20s %-20s\n",
                    "ID",
                    "Last name",
                    "First name",
                    "TRN",
                    "Phone number"
            );
            for (int i = 0; i < 84; i++)
                System.out.print("=");
            System.out.println();
            while (resultSet.next()) {
                System.out.printf(
                        "%6s %-20s %-20s %-20s %-20s\n",
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
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
