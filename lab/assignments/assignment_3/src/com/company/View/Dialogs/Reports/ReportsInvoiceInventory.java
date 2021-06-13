package com.company.View.Dialogs.Reports;

import com.company.View.Dialogs.BaseDialog;
import com.company.View.Dialogs.Orders.CustomerComboModel;
import com.company.View.Dialogs.UniversalComboBox;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class ReportsInvoiceInventory extends BaseDialog {
    private ResultSet resultSet = null;

    public ReportsInvoiceInventory() {
        super(new Dimension(300, 90));
        databaseConnection();
        improveBaseDialog();
    }

    private void improveBaseDialog() {
        // initialize and declare objects
        JPanel backPanel = new JPanel(new FlowLayout());
        UniversalComboBox informationCustomers = new UniversalComboBox(
                "Customer:",
                new CustomerComboModel(connection)
        );

        // add panel to base dialog
//        backPanel.add(informationCustomers);
        add(informationCustomers, BorderLayout.EAST);

        // base dialog preferences
        setTitle("Print Invoice");
    }
}
