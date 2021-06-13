package com.company.View.Dialogs.Files;

import com.company.View.Dialogs.BaseDialog;
import com.company.View.Dialogs.InformationPanel;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FilesDialog extends BaseDialog {
    protected static final InformationPanel[] informationPanels = new InformationPanel[5];
    protected final JButton buttonFirst = new JButton("First");
    protected final JButton buttonPrevious = new JButton("Previous");
    protected final JButton buttonNext = new JButton("Next");
    protected final JButton buttonLast = new JButton("Last");
    protected final JButton buttonAdd = new JButton("Add");
    protected final JButton buttonModify = new JButton("Modify");
    protected final JButton buttonDelete = new JButton("Delete");
    protected final JButton buttonOK = new JButton("OK");
    protected final JButton buttonCancel = new JButton("Cancel");
    protected ResultSet resultSet = null;
    protected Statement statement;
    protected static String[] columnNames = new String[5];
    protected int currentIndex = 0;
    protected int mode = 0;

    public FilesDialog(String title, String[] informationElements, String[] columnNames, String query) {
        improveBaseDialog(title, informationElements, columnNames);
        databaseConnection();
        prepareForm(query);
    }

    public void improveBaseDialog(String title, String[] informationElements, String[] columnNames) {
        // initialize and declare objects
        JPanel tablePanel = new JPanel();
        JPanel toolBarPanel = new JPanel();
        JToolBar toolBar = new JToolBar();
        JButton[] toolBarButtons = {
                buttonFirst, buttonPrevious, buttonNext,
                buttonLast, buttonAdd, buttonModify,
                buttonDelete, buttonOK, buttonCancel
        };
        for (int i = 0; i < informationPanels.length; i++) {
            informationPanels[i] = new InformationPanel(informationElements[i]);
        }
        FilesDialog.columnNames = columnNames;

        // set toolbar preferences
        toolBar.setFloatable(false);

        // set dialog preferences
        tablePanel.setLayout(new GridLayout(5, 1));

        // set dialog preferences
        setTitle(title);

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

    public void prepareForm(String query) {
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
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

    private void currentIndexCheck(String action) {
        if (currentIndex > 0) {
            try {
                currentIndex = resultSet.getInt(1);
                if (action.equals("DELETE")) {
                    resultSet.deleteRow();
                }
                showInformation();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
        for (int i = 1; i < informationPanels.length; i++) {
            informationPanels[i].setEditable(true);
        }
    }

    private void doDelete() {
        mode = 0;
        currentIndexCheck("DELETE");
        clearInformation();
        buttonOK.setEnabled(true);
        buttonCancel.setEnabled(true);
    }

    private void doModify() {
        mode = 1;
        currentIndexCheck("MODIFY");
        buttonOK.setEnabled(true);
        buttonCancel.setEnabled(true);
    }

    private void showInformation() {
        try {
            informationPanels[0].setText(String.valueOf(resultSet.getInt(columnNames[0])));
            for (int i = 1; i < columnNames.length; i++) {
                informationPanels[i].setText(String.valueOf(resultSet.getString(columnNames[i])));
            }
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
            for (int i = 1; i < columnNames.length; i++) {
                resultSet.updateString(columnNames[i], informationPanels[i].getText());
            }
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