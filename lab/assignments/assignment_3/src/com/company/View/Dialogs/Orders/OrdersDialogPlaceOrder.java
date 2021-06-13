package com.company.View.Dialogs.Orders;

import com.company.View.Dialogs.BaseDialog;
import com.company.View.Dialogs.InformationTextField;
import com.company.View.Dialogs.UniversalComboBox;

import javax.swing.*;
import java.awt.*;

public class OrdersDialogPlaceOrder extends BaseDialog {
    protected static String[] informationElements = {"Order ID", "Customer", "Category", "Description", "Price"};

    public OrdersDialogPlaceOrder() {
        super(new Dimension(480, 510));
        databaseConnection();
        improveBaseDialog();
    }

    private void improveBaseDialog() {
        // initialize and declare objects
        JPanel upperPanel = new JPanel(new GridLayout(6, 1));
        JPanel lowerPanel = new JPanel(new FlowLayout());
        JPanel upperButtonsPanel = new JPanel(new GridLayout(1, 2));
        JButton buttonAddLine = new JButton("Add Line");
        JButton buttonDeleteLine = new JButton("Delete line");
        JButton buttonExit = new JButton("Exit");
        JTable table = new JTable(new TableModel());
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, upperPanel, lowerPanel);
        JScrollPane scrollPane = new JScrollPane(table);
        UniversalComboBox informationCustomers = new UniversalComboBox(
                "Customer:",
                new OrdersComboModelCustomers(connection)
        );
        UniversalComboBox informationInventoryItem = new UniversalComboBox(
                "Inventory Item:",
                new OrdersComboModelInventory(connection)
        );
        InformationTextField informationItemPrice = new InformationTextField("Item Price:");
        InformationTextField informationQuantity = new InformationTextField("Quantity:");
        InformationTextField InformationTotalPrice = new InformationTextField("Total Price:");
        UniversalComboBox[] universalComboBoxes = {
                informationCustomers, informationInventoryItem,
        };
        InformationTextField[] informationTextFields = {
                informationItemPrice, informationQuantity, InformationTotalPrice
        };

        // set split pane preferences
        splitPane.setEnabled(false);

        // set table preferences
        for (int i = 0; i < informationElements.length; i++) {
            table.getColumnModel().getColumn(i).setHeaderValue(informationElements[i]);
        }
        table.setEnabled(false);

        // make information panels not editable
        for (InformationTextField informationTextField : informationTextFields) {
            informationTextField.setEditable(false);
        }

        // add information panels to upper panel
        for (UniversalComboBox universalComboBox : universalComboBoxes) {
            upperPanel.add(universalComboBox);
        }
        for (InformationTextField informationTextField : informationTextFields) {
            upperPanel.add(informationTextField);
        }

        // add upper buttons to their panel
        upperButtonsPanel.add(buttonAddLine);
        upperButtonsPanel.add(buttonDeleteLine);

        // add upper buttons panel to the upper panel
        upperPanel.add(upperButtonsPanel);

        // add scroll pane and exit button to lower panel
        lowerPanel.add(scrollPane);
        lowerPanel.add(buttonExit, FlowLayout.LEFT);

        // add split pane to dialog
        add(splitPane);

        // add exit button to dialog
        add(buttonExit, BorderLayout.SOUTH);

        // set dialog preferences
        pack();
        setTitle("Place Order");
        setVisible(true);

        // set button actions
        buttonExit.addActionListener(l -> setVisible(false));
    }
}
