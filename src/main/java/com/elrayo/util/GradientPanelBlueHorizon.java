package com.elrayo.util;

import java.awt.*;
import java.awt.LinearGradientPaint;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class GradientPanelBlueHorizon extends JPanel {
    private final List<ModelColor> colors = new ArrayList<>();

    public GradientPanelBlueHorizon() {
        setOpaque(false);
        // Blue Horizon colors
        addColor(
            new ModelColor(new Color(0x0d48a0), 0.0f),
            new ModelColor(new Color(0x1975d2), 0.25f),
            new ModelColor(new Color(0x28b5f6), 0.5f),
            new ModelColor(new Color(0x50c2f7), 0.75f),
            new ModelColor(new Color(0x80d9ff), 1.0f)
        );
    }

    public void addColor(ModelColor... values) {
        for (ModelColor m : values) {
            colors.add(m);
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (!colors.isEmpty()) {
            int width = getWidth();
            int height = getHeight();
            Graphics2D g2 = (Graphics2D) g.create();

            Color[] colorArray = new Color[colors.size()];
            float[] positionArray = new float[colors.size()];
            for (int i = 0; i < colors.size(); i++) {
                colorArray[i] = colors.get(i).getColor();
                positionArray[i] = colors.get(i).getPosition();
            }

            LinearGradientPaint paint = new LinearGradientPaint(
                0, 0, width, 0, positionArray, colorArray
            );

            g2.setPaint(paint);
            g2.fillRect(0, 0, width, height);
            g2.dispose();
        }
        super.paintComponent(g);
    }
}
    