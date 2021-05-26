package com.company.GUI.Menus;

import com.company.GUI.MenuItems.Purchases.PurchasesMakePurchase;

import javax.swing.JMenu;

public class MenuPurchases extends JMenu {
    public MenuPurchases() {
        setText("Purchases");
        add(new PurchasesMakePurchase());
    }
}
