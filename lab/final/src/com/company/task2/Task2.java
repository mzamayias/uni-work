package com.company.task2;

import com.company.Frame;

import javax.swing.*;
import java.awt.*;

public class Task2 {
    Frame frame = new Frame();
    JPanel panel = new JPanel(new BorderLayout());
    JSlider slider = new JSlider(JSlider.VERTICAL, 0, 255, 127);

    public Task2() {
        createGUI();
        changePanelColor();
    }

    private void createGUI() {
        setSliderPreferences();
        panel.add(slider, BorderLayout.EAST);
        frame.add(panel);
    }

    private void setSliderPreferences() {
        slider.setMinorTickSpacing(15);
        slider.setMajorTickSpacing(50);
        slider.setPaintTicks(true);
    }

    private void changePanelColor() {
        slider.addChangeListener(l -> {
            if (!slider.getValueIsAdjusting()) {
                int value = slider.getValue();
                panel.setBackground(new Color(value, value, value));
            }
        });
    }
}
