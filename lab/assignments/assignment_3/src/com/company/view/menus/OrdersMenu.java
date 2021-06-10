package com.company.view.menus;

import com.company.view.menuItems.Orders.OrdersMenuItemMakeOrder;

import javax.swing.JMenu;

public class OrdersMenu extends JMenu {
    public OrdersMenu() {
        setText("Orders");
        add(new OrdersMenuItemMakeOrder());
    }
}
