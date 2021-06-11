package com.company.View.MenuItems.Orders;

import com.company.View.Dialogs.Orders.OrdersDialogMakeOrder;

import javax.swing.*;

public class OrdersMenuItemMakeOrder extends JMenuItem {
    public OrdersMenuItemMakeOrder() {
        setText("Place Order");
        addActionListener(l -> new OrdersDialogMakeOrder());
    }
}
