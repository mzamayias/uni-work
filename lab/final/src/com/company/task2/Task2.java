package com.company.task2;

import com.company.Frame;

import javax.swing.*;
import java.awt.*;

public class Task2 {
    Frame frame = new Frame();
    JPanel panel = new JPanel(new BorderLayout());
    JSlider slider = new JSlider();

    public Task2() {
        createGUI();
    }

    private void createGUI() {
        setSliderPreferences();
        panel.add(slider, BorderLayout.EAST);
        frame.add(panel);
    }

    private void setSliderPreferences() {
        slider.setOrientation(JSlider.VERTICAL);
        slider.setMinimum(0);
        slider.setMaximum(255);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
    }
}
