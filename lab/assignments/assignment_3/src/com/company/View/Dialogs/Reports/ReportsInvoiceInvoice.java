package com.company.View.Dialogs.Reports;

import com.company.View.Dialogs.BaseDialog;
import com.company.View.Dialogs.UniversalComboBox;

import javax.swing.*;
import java.awt.*;

public class ReportsInvoiceInvoice extends BaseDialog {
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
        UniversalComboBox informationCustomers = new UniversalComboBox(
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
        button.addActionListener(l -> System.out.println(informationCustomers.getSelectedItem()));
    }
}
