package com.company.View.Dialogs.Orders;

import com.company.View.Dialogs.BaseDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OrdersDialogPlaceOrder extends BaseDialog {
    public OrdersDialogPlaceOrder() {
        super(new Dimension(480, 510));
        prepareBaseDialog();
    }

    private void prepareBaseDialog() {
        JPanel panel = new JPanel();

        panel.setLayout(new FlowLayout());

        setTitle("Place Order");
        setVisible(true);

        JTable table = new JTable();

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                int row = table.rowAtPoint(evt.getPoint());
                int col = table.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {
                    System.out.println("Selected: Row: " + row + " Column: " + col);
                    Object objectAtClick = table.getModel().getValueAt(row, col);
                    System.out.println("StudentID is: " + table.getModel().getValueAt(row, 0) + " - Object clicked is: " + objectAtClick);
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
        add(panel);
        pack();
    }
}
