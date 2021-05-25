package com.company.GUI.Menus;

import com.company.GUI.MenuItems.Purchases.PurchasesMakePurchase;

import javax.swing.*;

public class MenuPurchases extends JMenu {
    public MenuPurchases() {
        setText("Purchases");
        add(new PurchasesMakePurchase());
    }
}
