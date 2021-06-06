package com.company.GUI.Menus;

import com.company.GUI.MenuItems.Orders.OrdersMenuItemMakeOrder;

import javax.swing.JMenu;

public class OrdersMenu extends JMenu {
    public OrdersMenu() {
        setText("Orders");
        add(new OrdersMenuItemMakeOrder());
    }
}
