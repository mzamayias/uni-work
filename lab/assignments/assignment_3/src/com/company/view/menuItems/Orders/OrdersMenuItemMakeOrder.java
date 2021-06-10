package com.company.view.menuItems.Orders;

import com.company.view.dialogs.Orders.OrdersDialogMakeOrder;

import javax.swing.*;

public class OrdersMenuItemMakeOrder extends JMenuItem {
    public OrdersMenuItemMakeOrder() {
        setText("Make Purchase");
        addActionListener(l -> new OrdersDialogMakeOrder());
    }
}
