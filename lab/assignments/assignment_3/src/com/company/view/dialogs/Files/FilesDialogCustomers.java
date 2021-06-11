package com.company.view.dialogs.Files;

import com.company.view.dialogs.BaseDialog;

import javax.swing.*;
import java.awt.*;

public class FilesDialogCustomers extends BaseDialog {
    public FilesDialogCustomers() {
        JPanel jPanel = new JPanel();
        JToolBar jToolBar = new JToolBar();
        JButton[] toolBarButtons = {
                new JButton("First"),
                new JButton("Previous"),
                new JButton("Next"),
                new JButton("Last"),
                new JButton("Add"),
                new JButton("Modify"),
                new JButton("Delete"),
                new JButton("OK"),
                new JButton("Cancel")
        };

        for (JButton toolBarButton : toolBarButtons) {
//            toolBarButton.setEnabled(false);
            jToolBar.add(toolBarButton);
        }

        jToolBar.setFloatable(false);

        jPanel.add(jToolBar, BorderLayout.NORTH);

        add(jPanel);

        setSize(390,270);
        setTitle("Customer");
        setVisible(true);
    }
}
