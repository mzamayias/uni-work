package com.company.view.dialogs.Help;

import com.company.view.dialogs.BaseDialog;

import javax.swing.*;
import java.awt.*;

public class HelpDialogAbout extends BaseDialog {
    public HelpDialogAbout() {
        JPanel jPanel = new JPanel();
        JLabel[] labelsAuthor = {
                new JLabel("Application Author:"),
                new JLabel("Mike Zamayias")
        };
        JLabel[] labelsVersion = {
                new JLabel("Application Version:"),
                new JLabel("Under Development")
        };
        JLabel[] labelsReach = {
                new JLabel("GitHub:"),
                new JLabel("@mzamayias")
        };

        jPanel.setLayout(new GridLayout(3, 2));
        for (JLabel jLabel : labelsAuthor) {
            jPanel.add(jLabel);
        }
        for (JLabel jLabel : labelsVersion) {
            jPanel.add(jLabel);
        }
        for (JLabel jLabel : labelsReach) {
            jPanel.add(jLabel);
        }

        add(jPanel);

        setTitle("About");
        setSize(300, 150);
        setResizable(false);
        setVisible(true);
        pack();
    }
}
