package com.company.GUI.Dialogs.Orders;

import com.company.GUI.Dialogs.BaseDialog;

import javax.swing.*;
import java.awt.*;

public class OrdersDialogPlaceOrder extends BaseDialog {
    public OrdersDialogPlaceOrder() {
        JPanel jPanel = new JPanel();

        jPanel.setLayout(new FlowLayout());

        add(jPanel);

        setTitle("Make Order");
        setVisible(true);
    }
}
