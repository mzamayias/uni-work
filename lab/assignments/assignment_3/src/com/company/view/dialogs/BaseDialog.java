package com.company.view.dialogs;

import javax.swing.*;
import java.awt.*;

public class BaseDialog extends JDialog {
    public BaseDialog() {
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        setResizable(false);
        pack();
    }
}
