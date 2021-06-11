package com.company.View.Menus;

import com.company.View.MenuItems.Orders.OrdersMenuItemMakeOrder;

import javax.swing.JMenu;

public class OrdersMenu extends JMenu {
    public OrdersMenu() {
        setText("Orders");
        add(new OrdersMenuItemMakeOrder());
    }
}
