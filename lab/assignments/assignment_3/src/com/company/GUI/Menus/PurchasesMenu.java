package com.company.GUI.Menus;

import com.company.GUI.MenuItems.Purchases.PurchasesMenuItemMakePurchase;

import javax.swing.JMenu;

public class PurchasesMenu extends JMenu {
    public PurchasesMenu() {
        setText("Purchases");
        add(new PurchasesMenuItemMakePurchase());
    }
}
