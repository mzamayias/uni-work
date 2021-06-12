package com.company.View.Dialogs;

import javax.swing.*;
import java.awt.*;

public class BaseDialog extends JDialog {
    public BaseDialog() {
//        setAlwaysOnTop(true);
        setLayout(new BorderLayout(6, 3));
        setPreferredSize(new Dimension(390, 270));
        setVisible(true);
        setResizable(false);
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL); // setModal(true); is deprecated
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        pack();
    }
}
