package com.company.GUI.Dialogs.Files;

import com.company.GUI.Dialogs.BaseDialog;

import javax.swing.*;
import java.awt.*;

public class FilesDialogCustomers extends BaseDialog {
    public FilesDialogCustomers() {
        setTitle("Customers");

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        add(jPanel);

        setVisible(true);
    }
}
