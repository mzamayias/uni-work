package com.company.GUI.MenuItems.Orders;

import com.company.GUI.Dialogs.Orders.OrdersDialogMakeOrder;

import javax.swing.*;

public class OrdersMenuItemMakeOrder extends JMenuItem {
    public OrdersMenuItemMakeOrder() {
        setText("Make Purchase");
        addActionListener(l -> new OrdersDialogMakeOrder());
    }
}
