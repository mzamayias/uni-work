package com.company.View.Dialogs.Help;

import com.company.View.Dialogs.BaseDialog;
import com.company.View.Dialogs.InformationTextField;

import javax.swing.*;
import java.awt.*;

public class HelpDialogAbout extends BaseDialog {
    public HelpDialogAbout() {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        InformationTextField informationAppAuthor = new InformationTextField(
                "Application Author:",
                "Mike Zamayias"
        );
        InformationTextField informationAppVersion = new InformationTextField(
                "Application Version:",
                "Beta"
        );
        InformationTextField informationSocial = new InformationTextField(
                "GitHub:",
                "@mzamayias"
        );
        InformationTextField[] informationTextFields = {
                informationAppAuthor, informationAppVersion, informationSocial
        };

        for (InformationTextField informationTextField : informationTextFields) {
            panel.add(informationTextField);
        }

        add(panel);

        setTitle("About");
        setResizable(false);
        pack();
        setVisible(true);
    }
}
