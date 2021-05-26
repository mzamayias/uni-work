package com.company.GUI.MenuItems.Purchases;

import com.company.GUI.Dialogs.PurchasesDialogMakePurchase;

import javax.swing.*;

public class PurchasesMenuItemMakePurchase extends JMenuItem {
    public PurchasesMenuItemMakePurchase() {
        setText("Make Purchase");
        addActionListener(l -> new PurchasesDialogMakePurchase());
    }
}
