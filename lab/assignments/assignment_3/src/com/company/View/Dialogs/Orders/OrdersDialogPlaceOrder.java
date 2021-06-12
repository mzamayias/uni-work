package com.company.View.Dialogs.Orders;

import com.company.View.Dialogs.BaseDialog;

import javax.swing.*;
import java.awt.*;

public class OrdersDialogPlaceOrder extends BaseDialog {
    public OrdersDialogPlaceOrder() {
        super(new Dimension(480,510));
        JPanel jPanel = new JPanel();

        jPanel.setLayout(new FlowLayout());

        add(jPanel);

        setTitle("Place Order");
        setVisible(true);
    }
}
