package com.company.View.Dialogs.Reports;

import com.company.View.Dialogs.BaseDialog;
import com.company.View.Dialogs.UniversalComboBox;

import javax.swing.*;
import java.awt.*;

public class ReportsInvoiceInvoice extends BaseDialog {
    private UniversalComboBox informationCustomers;

    public ReportsInvoiceInvoice() {
        super(new Dimension(309, 99));
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
        add(panel);

        // base dialog preferences
        setTitle("Print Invoice");

        // set button actions
        button.addActionListener(l -> printInvoice());
    }

    private void printInvoice() {
        String[] customerText = informationCustomers.getSelectedItemIndex();
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
                "Order",
                "Category",
                "Description",
                "Quantity",
                "Price"
        );
        for (int i = 0; i < 84; i++)
            System.out.print("=");
        System.out.println();
        for (int i = 0; i < 84; i++)
            System.out.print("=");
        System.out.println();
    }
}
