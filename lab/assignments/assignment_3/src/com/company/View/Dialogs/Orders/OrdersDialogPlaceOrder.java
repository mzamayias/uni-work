package com.company.View.Dialogs.Orders;

import com.company.View.Dialogs.BaseDialog;

import javax.swing.*;
import java.awt.*;

public class OrdersDialogPlaceOrder extends BaseDialog {
    public OrdersDialogPlaceOrder() {
        super(new Dimension(480, 510));
        prepareBaseDialog();
    }

    private void prepareBaseDialog() {
        JPanel panel = new JPanel();

        panel.setLayout(new FlowLayout());

        add(panel);

        setTitle("Place Order");
        setVisible(true);
    }
}
