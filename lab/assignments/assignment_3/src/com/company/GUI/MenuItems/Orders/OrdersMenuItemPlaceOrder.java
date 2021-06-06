package com.company.GUI.MenuItems.Orders;

import com.company.GUI.Dialogs.Orders.OrdersDialogMakeOrder;

import javax.swing.*;

public class OrdersMenuItemPlaceOrder extends JMenuItem {
    public OrdersMenuItemPlaceOrder() {
        setText("Make Purchase");
        addActionListener(l -> new OrdersDialogMakeOrder());
    }
}
