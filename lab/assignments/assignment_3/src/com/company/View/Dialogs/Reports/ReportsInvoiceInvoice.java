package com.company.View.Dialogs.Reports;

import com.company.View.Dialogs.BaseDialog;
import com.company.View.Dialogs.UniversalComboBox;

import java.awt.*;
import java.sql.ResultSet;

public class ReportsInvoiceInvoice extends BaseDialog {
    private ResultSet resultSet = null;

    public ReportsInvoiceInvoice() {
        super(new Dimension(309, 99));
        databaseConnection();
        improveBaseDialog();
    }

    private void improveBaseDialog() {
        // initialize and declare objects
        UniversalComboBox informationCustomers = new UniversalComboBox(
                "Invoice for customer:",
                new ReportsComboModelCustomers(connection)
        );

        // add universal combobox to base dialog
        add(informationCustomers, BorderLayout.EAST);

        // base dialog preferences
        setTitle("Print Invoice");
    }
}
