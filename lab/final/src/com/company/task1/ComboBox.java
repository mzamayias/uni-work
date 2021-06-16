package com.company.task1;

import javax.swing.*;
import javax.swing.ComboBoxModel;

public class ComboBox extends JComboBox<String> {
    public ComboBox(ComboBoxModel<String> aModel) {
        super(aModel);
    }

    public String[] getSelectedItemAsStringArray() {
        return "%s".formatted(this.getSelectedItem()).split(", ");
    }

    public String getSelectedItemIndex() {
        // you could argue it's jerry rigged, and i'd say it works just fine
        String[] array = getSelectedItemAsStringArray();
        return array[array.length - 1];
    }
}
