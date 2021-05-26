package com.company.GUI.Dialogs.Purchases;

import com.company.GUI.Dialogs.BaseDialog;

import javax.swing.*;
import java.awt.*;

public class PurchasesDialogMakePurchase extends BaseDialog {
    public PurchasesDialogMakePurchase() {
        setTitle("Make Purchase");

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        add(jPanel);

        setVisible(true);
    }
}
