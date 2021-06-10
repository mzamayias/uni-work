package com.company.view.dialogs.Orders;

import com.company.view.dialogs.BaseDialog;

import javax.swing.*;
import java.awt.*;

public class OrdersDialogMakeOrder extends BaseDialog {
    public OrdersDialogMakeOrder() {
        JPanel jPanel = new JPanel();

        jPanel.setLayout(new FlowLayout());

        add(jPanel);

        setTitle("Make Order");
        setVisible(true);
    }
}
