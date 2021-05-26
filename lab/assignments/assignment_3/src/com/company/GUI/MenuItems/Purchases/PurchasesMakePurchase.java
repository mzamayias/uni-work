package com.company.GUI.MenuItems.Purchases;

import com.company.GUI.Dialogs.JDialogMakePurchase;

import javax.swing.*;

public class PurchasesMakePurchase extends JMenuItem {
    public PurchasesMakePurchase() {
        setText("Make Purchase");
        addActionListener(l -> new JDialogMakePurchase());
    }
}
