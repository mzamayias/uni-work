package com.company.GUI.Dialogs;

import javax.swing.*;
import java.awt.*;

public class DialogMakePurchase extends JDialog {
    public DialogMakePurchase() {
        setTitle("Make Purchase");
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        setVisible(true);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        add(jPanel);
        pack();
    }
}
