package com.company.view.MenuItems.Orders;

import com.company.view.Dialogs.Orders.OrdersDialogMakeOrder;

import javax.swing.*;

public class OrdersMenuItemMakeOrder extends JMenuItem {
    public OrdersMenuItemMakeOrder() {
        setText("Make Purchase");
        addActionListener(l -> new OrdersDialogMakeOrder());
    }
}
