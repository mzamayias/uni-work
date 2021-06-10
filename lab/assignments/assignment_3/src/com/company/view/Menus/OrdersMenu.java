package com.company.view.Menus;

import com.company.view.MenuItems.Orders.OrdersMenuItemMakeOrder;

import javax.swing.JMenu;

public class OrdersMenu extends JMenu {
    public OrdersMenu() {
        setText("Orders");
        add(new OrdersMenuItemMakeOrder());
    }
}
