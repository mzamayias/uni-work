package com.company.View.Dialogs.Orders;

import com.company.View.Dialogs.BaseDialog;
import com.company.View.Dialogs.InformationComboBox;
import com.company.View.Dialogs.InformationTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OrdersDialogPlaceOrder extends BaseDialog {
    protected static String[] informationElements = {"Order ID", "Customer", "Category", "Description", "Price"};

    public OrdersDialogPlaceOrder() {
        super(new Dimension(480, 510));
        prepareBaseDialog();
    }

    private void prepareBaseDialog() {
        // initialize and declare objects
        JPanel upperPanel = new JPanel(new GridLayout(6, 1));
        JPanel lowerPanel = new JPanel(new FlowLayout());
        JPanel upperButtonsPanel = new JPanel(new GridLayout(1,2));
        JButton buttonAddLine = new JButton("Add Line");
        JButton buttonDeleteLine = new JButton("Delete line");
        JButton buttonExit = new JButton("Exit");
        JTable table = new JTable(new OrdersDialogModel());
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, upperPanel, lowerPanel);
        JScrollPane scrollPane = new JScrollPane(table);
        InformationComboBox informationCustomer = new InformationComboBox("Customer:");
        InformationComboBox informationInventoryItem = new InformationComboBox("Inventory Item:");
        InformationTextField informationItemPrice = new InformationTextField("Item Price:");
        InformationTextField informationQuantity = new InformationTextField("Quantity:");
        InformationTextField InformationTotalPrice = new InformationTextField("Total Price:");
        InformationComboBox[] informationComboBoxes = {
                informationCustomer, informationInventoryItem,
        };
        InformationTextField[] informationTextFields = {
                informationItemPrice, informationQuantity, InformationTotalPrice
        };

        // change table headers
        for (int i = 0; i < informationElements.length; i++) {
            table.getColumnModel().getColumn(i).setHeaderValue(informationElements[i]);
        }

        // make information panels not editable

        // add mouse actions to the table
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                int row = table.rowAtPoint(evt.getPoint());
                int col = table.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {
                    System.out.println("Selected: Row: " + row + " Column: " + col);
                    Object objectAtClick = table.getModel().getValueAt(row, col);
                    System.out.println("Order ID is: " + table.getModel().getValueAt(row, 0) + " - Object clicked is:" +
                            " " + objectAtClick);
                }
            }
        });

        // add information panels to upper panel
        for (InformationComboBox informationComboBox : informationComboBoxes) {
            upperPanel.add(informationComboBox);
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
    }
}
