package com.company.GUI.Dialogs;

import javax.swing.*;
import java.awt.*;

public class DialogCustomers extends BaseDialog {
    public DialogCustomers() {
        setTitle("Customers");

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        add(jPanel);
    }
}
