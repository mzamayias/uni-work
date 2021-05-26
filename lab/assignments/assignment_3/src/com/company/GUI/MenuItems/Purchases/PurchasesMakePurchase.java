package com.company.GUI.MenuItems.Purchases;

import com.company.GUI.Dialogs.DialogMakePurchase;

import javax.swing.*;

public class PurchasesMakePurchase extends JMenuItem {
    public PurchasesMakePurchase() {
        setText("Make Purchase");
        addActionListener(l -> new DialogMakePurchase());
    }
}
