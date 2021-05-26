package com.company.GUI.Dialogs;

import javax.swing.*;
import java.awt.*;

public class DialogMakePurchase extends BaseDialog {
    public DialogMakePurchase() {
        setTitle("Make Purchase");

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        add(jPanel);

        setVisible(true);
    }
}
