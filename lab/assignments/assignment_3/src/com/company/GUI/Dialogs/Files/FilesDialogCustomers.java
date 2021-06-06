package com.company.GUI.Dialogs.Files;

import com.company.GUI.Dialogs.BaseDialog;

import javax.swing.*;
import java.awt.*;

public class FilesDialogCustomers extends BaseDialog {
    public FilesDialogCustomers() {
        JPanel jPanel = new JPanel();

        jPanel.setLayout(new GridLayout(2, 1));

        add(jPanel);

        setTitle("Customers");
        setVisible(true);
    }
}
