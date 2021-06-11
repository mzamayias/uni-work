package com.company.View.Dialogs;

import javax.swing.*;
import java.awt.*;

public class BaseDialog extends JDialog {
    public BaseDialog() {
        setLayout(new BorderLayout());
        setVisible(true);
        setResizable(false);
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        pack();
    }
}
