package com.company.view.dialogs.Files;

import com.company.view.dialogs.BaseDialog;

import javax.swing.*;
import java.awt.*;

public class FilesDialogCustomers extends BaseDialog {
    public FilesDialogCustomers() {
        JPanel jPanel = new JPanel();
        JToolBar jToolBar = new JToolBar();

        jPanel.setLayout(new BorderLayout());




        add(jToolBar, BorderLayout.PAGE_START);

        add(jPanel);
        setTitle("Customer");
        setVisible(true);
    }
}
