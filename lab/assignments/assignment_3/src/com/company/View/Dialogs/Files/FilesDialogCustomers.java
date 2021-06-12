package com.company.View.Dialogs.Files;

import com.company.View.Dialogs.BaseDialog;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class FilesDialogCustomers extends BaseDialog {
    // initialize and declare objects
    private final InformationPanel informationID = new InformationPanel("ID:");
    private final InformationPanel informationLastName = new InformationPanel("Last Name:");
    private final InformationPanel informationFirstName = new InformationPanel("First Name:");
    private final InformationPanel informationTRN = new InformationPanel("TRN:");
    private final InformationPanel informationPhoneNumber = new InformationPanel("Phone Number:");
    private final InformationPanel[] informationPanels = {
            informationID, informationLastName, informationFirstName, informationTRN, informationPhoneNumber
    };
    private final JButton buttonFirst = new JButton("First");
    private final JButton buttonPrevious = new JButton("Previous");
    private final JButton buttonNext = new JButton("Next");
    private final JButton buttonLast = new JButton("Last");
    private final JButton buttonAdd = new JButton("Add");
    private final JButton buttonModify = new JButton("Modify");
    private final JButton buttonDelete = new JButton("Delete");
    private final JButton buttonOK = new JButton("OK");
    private final JButton buttonCancel = new JButton("Cancel");
    private ResultSet resultSet = null;
    private Statement statement;
    private String query;
    private int currentIndex = 0;
    private int mode = 0;

    public FilesDialogCustomers() {
        improveBaseDialog();
        databaseConnection();
        prepareForm();
    }

    private void improveBaseDialog() {
        // initialize and declare objects
        JPanel tablePanel = new JPanel();
        JPanel toolBarPanel = new JPanel();
        JToolBar toolBar = new JToolBar();
        JButton[] toolBarButtons = {
                buttonFirst, buttonPrevious, buttonNext,
                buttonLast, buttonAdd, buttonModify,
                buttonDelete, buttonOK, buttonCancel
        };

        // set toolbar preferences
        toolBar.setFloatable(false);

        // set dialog preferences
        tablePanel.setLayout(new GridLayout(5, 1));

        // set dialog preferences
        setTitle("Inventory");

        // set button preferences
        buttonOK.setEnabled(false);

        // set button action listeners
        buttonFirst.addActionListener(e -> doFirst());
        buttonPrevious.addActionListener(e -> doPrevious());
        buttonNext.addActionListener(e -> doNext());
        buttonLast.addActionListener(e -> doLast());
        buttonAdd.addActionListener(e -> doAdd());
        buttonModify.addActionListener(e -> doModify());
        buttonDelete.addActionListener(e -> doDelete());
        buttonOK.addActionListener(e -> doOK());
        buttonCancel.addActionListener(e -> doCancel());

        // add buttons to toolbar
        for (JButton toolBarButton : toolBarButtons) {
            toolBar.add(toolBarButton);
        }

        // add toolbar to panel
        toolBarPanel.add(toolBar);

        // add information panels to information panel
        for (InformationPanel informationPanel : informationPanels) {
            tablePanel.add(informationPanel);
        }

        // add toolbar panel and information panels to dialog
        add(toolBarPanel, BorderLayout.PAGE_START);
        add(tablePanel, BorderLayout.LINE_END);

        pack();
    }


    public void prepareForm() {
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            query = "SELECT * FROM inventory_logistics.customers";
            resultSet = statement.executeQuery(query);
            if (resultSet.first()) {
                showInformation();
                currentIndex = 1;
            } else {
                currentIndex = 0;
            }
            for (InformationPanel informationPanel : informationPanels) {
                informationPanel.setEditable(false);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void doFirst() {
        try {
            if (resultSet.first()) {
                showInformation();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void doLast() {
        try {
            if (resultSet.last()) {
                showInformation();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void doAdd() {
        for (int i = 1; i < informationPanels.length; i++) {
            informationPanels[i].setEditable(true);
        }
        buttonOK.setEnabled(true);
    }

    private void doPrevious() {
        try {
            if (!resultSet.isFirst()) {
                if (resultSet.previous()) {
                    showInformation();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void doNext() {
        try {
            if (!resultSet.isLast()) {
                if (resultSet.next()) {
                    showInformation();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void doOK() {
        updateDatabase();
        if (mode == 0) {
            doLast();
        }
        currentIndex += 1;
        for (int i = 1; i < informationPanels.length; i++) {
            informationPanels[i].setEditable(false);
        }
        buttonOK.setEnabled(false);
    }

    private void doCancel() {
        setVisible(false);
        closeDatabase(resultSet, statement, connection);
    }

    private void currentIndexCheck() {
        if (currentIndex > 0) {
            try {
                currentIndex = resultSet.getInt(1);
            } catch (SQLException e) {
                System.out.println("doRegister: " + e.getMessage());
            }
        }
        for (int i = 1; i < informationPanels.length; i++) {
            informationPanels[i].setEditable(true);
        }
    }

    private void doDelete() {
        mode = 0;
        currentIndexCheck();
        clearInformation();
        buttonOK.setEnabled(true);
        buttonCancel.setEnabled(true);
    }

    private void doModify() {
        mode = 1;
        currentIndexCheck();
        buttonOK.setEnabled(true);
        buttonCancel.setEnabled(true);
    }

    private void showInformation() {
        try {
            informationID.setText(String.valueOf(resultSet.getInt("customer_id")));
            informationLastName.setText(resultSet.getString("last_name"));
            informationFirstName.setText(resultSet.getString("first_name"));
            informationTRN.setText(resultSet.getString("trn"));
            informationPhoneNumber.setText(resultSet.getString("phone_number"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void clearInformation() {
        for (InformationPanel informationPanel : informationPanels) {
            informationPanel.setText(null);
        }
    }

    private void updateDatabase() {
        try {
            if (mode == 0) {
                resultSet.moveToInsertRow();
            }
            resultSet.updateString("last_name", informationLastName.getText());
            resultSet.updateString("first_name", informationFirstName.getText());
            resultSet.updateString("trn", informationTRN.getText());
            resultSet.updateString("phone_number", informationPhoneNumber.getText());
            if (mode == 0) {
                resultSet.insertRow();
            } else {
                resultSet.updateRow();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}