package com.company.View.Dialogs.Orders;

import com.company.View.Dialogs.BaseDialog;
import com.company.View.Dialogs.InformationTextField;
import com.company.View.Dialogs.UniversalComboBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrdersDialogPlaceOrder extends BaseDialog {
    private final String[] informationElements = {"Order ID", "Customer", "Category", "Description", "Price"};
    private final JButton buttonDeleteLine = new JButton();
    private final JTable table = new JTable();
    private final UniversalComboBox informationCustomers;
    private final UniversalComboBox informationInventoryItem;
    private final InformationTextField informationItemPrice = new InformationTextField("Item Price:");
    private final InformationTextField informationQuantity = new InformationTextField("Quantity:");
    private final InformationTextField InformationTotalPrice = new InformationTextField("Total Price:");
    private final UniversalComboBox[] universalComboBoxes;
    private final InformationTextField[] informationTextFields;

    public OrdersDialogPlaceOrder() {
        super(new Dimension(480, 510));
        databaseConnection();
        informationCustomers = new UniversalComboBox(
                "Customer:", new OrdersComboModelCustomers(connection)
        );
        informationInventoryItem = new UniversalComboBox(
                "Inventory Item:", new OrdersComboModelInventory(connection)
        );
        universalComboBoxes = new UniversalComboBox[]{
                informationCustomers, informationInventoryItem,
        };
        informationTextFields = new InformationTextField[]{
                informationItemPrice, informationQuantity, InformationTotalPrice
        };
        improveBaseDialog();
    }

    private void improveBaseDialog() {
        // initialize and declare objects
        JPanel upperPanel = new JPanel(new BorderLayout());
        JPanel lowerPanel = new JPanel(new FlowLayout());
        JPanel upperPanelFields = new JPanel(new GridLayout(5, 1));
        JPanel upperPanelButtons = new JPanel(new GridLayout(1, 2));
        JButton buttonAddLine = new JButton("Add Line");
        JButton buttonExit = new JButton("Exit");
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, upperPanel, lowerPanel);
        JScrollPane scrollPane = new JScrollPane(table);

        setTablePreferences();

        // make information panels not editable
        for (InformationTextField informationTextField : informationTextFields) {
            informationTextField.setEditable(false);
        }

        // add information panels to upper panel
        for (UniversalComboBox universalComboBox : universalComboBoxes) {
            upperPanelFields.add(universalComboBox);
        }
        for (InformationTextField informationTextField : informationTextFields) {
            upperPanelFields.add(informationTextField);
        }

        // set button preferences
        buttonDeleteLine.setText("Delete Line");

        // add upper buttons to their panel
        upperPanelButtons.add(buttonAddLine);
        upperPanelButtons.add(buttonDeleteLine);

        // add upper fields and buttons to their panel
        upperPanel.add(upperPanelFields, BorderLayout.EAST);
        upperPanel.add(upperPanelButtons, BorderLayout.SOUTH);

        // add scroll pane and exit button to lower panel
        lowerPanel.add(scrollPane);
        lowerPanel.add(buttonExit, FlowLayout.LEFT);

        // set split pane preferences
        splitPane.setEnabled(false);

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
        buttonAddLine.addActionListener(l -> doAddLine());
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                int row = table.rowAtPoint(evt.getPoint());
                if (row >= 0) {
                    String order_index = (String) table.getModel().getValueAt(row, 0);
                    System.out.printf("Order ID: %s\n", order_index);
                    buttonDeleteLine.addActionListener(l -> doDeleteLine(order_index));
                }
            }
        });
    }

    private void doAddLine() {
        informationQuantity.setEditable(true);
    }

    private void doDeleteLine(String order_id) {
        try {
            String query = "DELETE FROM inventory_logistics.orders WHERE orders.order_id = %s;".formatted(order_id);
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE
            );
            int i = statement.executeUpdate(query);
            System.out.println(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        setTablePreferences();
    }

    private void setTablePreferences() {
        // set table preferences
        table.setModel(new TableModel());
        // change table headers
        for (int i = 0; i < informationElements.length; i++) {
            table.getColumnModel().getColumn(i).setHeaderValue(informationElements[i]);
        }
        table.setEnabled(true);
    }
}
