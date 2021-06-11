package com.company.View.Dialogs.Files;

import com.company.View.Dialogs.BaseDialog;

import javax.swing.*;
import java.awt.*;

public class FilesDialogCustomers extends BaseDialog {
    public FilesDialogCustomers() {
        // initialize objects
        JPanel toolBarPanel = new JPanel();
        JPanel tablePanel = new JPanel();
        JToolBar toolBar = new JToolBar();
        JButton buttonFirst = new JButton("First");
        JButton buttonPrevious = new JButton("Previous");
        JButton buttonNext = new JButton("Next");
        JButton buttonLast = new JButton("Last");
        JButton buttonAdd = new JButton("Add");
        JButton buttonModify = new JButton("Modify");
        JButton buttonDelete = new JButton("Delete");
        JButton buttonOK = new JButton("OK");
        JButton buttonCancel = new JButton("Cancel");
        JButton[] toolBarButtons = {
                buttonFirst, buttonPrevious, buttonNext,
                buttonLast, buttonAdd, buttonModify,
                buttonDelete, buttonOK, buttonCancel
        };
        InformationPanel informationID = new InformationPanel("ID");
        InformationPanel informationLastName = new InformationPanel("Last Name");
        InformationPanel informationFirstName = new InformationPanel("First Name");
        InformationPanel informationAFM = new InformationPanel("AFM");
        InformationPanel informationTelephone = new InformationPanel("Telephone");
        InformationPanel[] informationPanels = {
                informationID, informationLastName, informationFirstName,
                informationAFM, informationTelephone
        };

        // toolbar preferences
        toolBar.setFloatable(false);

        // panel preferences
        tablePanel.setLayout(new GridLayout(5,1));

        // dialog preferences
        setTitle("Customer");
        setSize(390, 270);
        setLayout(new BorderLayout());

        // add buttons to toolbar
        for (JButton toolBarButton : toolBarButtons) {
            toolBar.add(toolBarButton);
        }

        // add information panels to table panel
        for (InformationPanel informationPanel : informationPanels) {
            tablePanel.add(informationPanel);
        }

        // add toolbar to panel
        toolBarPanel.add(toolBar);

        // add panels and split pane to dialog
        add(toolBarPanel, BorderLayout.PAGE_START);
        add(tablePanel, BorderLayout.LINE_END);

        // button functions
        buttonCancel.addActionListener(l -> setVisible(false));
    }
}
