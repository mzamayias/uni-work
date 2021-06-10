package com.company.view.Dialogs.Orders;

import com.company.view.Dialogs.BaseDialog;

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
