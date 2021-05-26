package com.company.GUI.Dialogs.Help;

import com.company.GUI.Dialogs.BaseDialog;

import javax.swing.*;
import java.awt.*;

public class HelpDialogAbout extends BaseDialog {
    public HelpDialogAbout() {
        setTitle("About");

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        add(jPanel);

        setVisible(true);
    }
}
