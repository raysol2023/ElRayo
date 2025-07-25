package com.elrayo.util;

import java.awt.Color;

public class ModelColor {
    private final Color color;
    private final float position;

    public ModelColor(Color color, float position) {
        this.color = color;
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public float getPosition() {
        return position;
    }
}
