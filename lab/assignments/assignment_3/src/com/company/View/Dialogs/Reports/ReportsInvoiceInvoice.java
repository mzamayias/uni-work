package com.company.View.Dialogs.Reports;

import com.company.View.Dialogs.BaseDialog;
import com.company.View.Dialogs.UniversalComboBox;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReportsInvoiceInvoice extends BaseDialog {
    private UniversalComboBox informationCustomers;
    private ResultSet resultSet = null;

    public ReportsInvoiceInvoice() {
        super(new Dimension(360, 99));
        databaseConnection();
        improveBaseDialog();
    }

    private void improveBaseDialog() {
        // initialize and declare objects
        JPanel panel = new JPanel(new GridLayout(2, 1));
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton button = new JButton("Print");
        informationCustomers = new UniversalComboBox(
                "Invoice for customer:",
                new ReportsComboModelCustomers(connection)
        );

        // set button preferences
        buttonPanel.add(button);

        // add universal combobox to panel
        panel.add(informationCustomers);
        panel.add(buttonPanel);

        // add panel to dialog
        add(panel, BorderLayout.CENTER);

        // base dialog preferences
        setTitle("Print Invoice");

        // set button actions
        button.addActionListener(l -> printInvoice());
    }

    private void printInvoice() {
        String[] customerText = informationCustomers.getSelectedItemAsStringArray();
        String customerID = customerText[2];
        String customerLastName = customerText[0];
        String customerFirstName = customerText[1];
        System.out.printf("For Customer ID: %s%n", customerID);
        System.out.printf(" Customer Name: %s %s%n", customerLastName, customerFirstName);
        for (int i = 0; i < 84; i++)
            System.out.print("=");
        System.out.println();
        System.out.printf(
                "%5s %-20s%-20s%-20s%-20s\n",
                "ID",
                "Category",
                "Description",
                "Quantity",
                "Price"
        );
        for (int i = 0; i < 84; i++)
            System.out.print("=");
        System.out.println();
        executeQuery(customerID);
        for (int i = 0; i < 84; i++)
            System.out.print("=");
        System.out.println();
    }

    private String getQuery(String customerID) {
        return """
                 SELECT
                          orders.order_id, inventory.category, inventory.description, orders.quantity, orders.price
                 FROM inventory_logistics.orders
                          LEFT JOIN inventory_logistics.customers ON customers.customer_id = orders.customer_id
                          LEFT JOIN inventory_logistics.inventory ON inventory.inventory_id = orders.inventory_id
                 WHERE
                          customers.customer_id = %s;
                """.formatted(customerID);
    }

    public void executeQuery(String customerID) {
        try {
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            );
            resultSet = statement.executeQuery(getQuery(customerID));
        } catch (SQLException e) {
            System.out.printf("error querying in ReportsInvoiceInvoice%n");
            e.printStackTrace();
        }
        try {
            while (resultSet.next()) {
                System.out.printf(
                        "%5s %-20s%-20s%-20s%-20s\n",
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
