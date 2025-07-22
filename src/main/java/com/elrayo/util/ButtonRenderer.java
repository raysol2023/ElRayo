package com.elrayo.util;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class ButtonRenderer extends JPanel implements TableCellRenderer {

    private final JButton button;

    public ButtonRenderer(String text) {
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0)); // sin margen vertical
        setOpaque(false);

        button = new JButton(text);
        button.setFocusable(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setBackground(new Color(37, 211, 102));
        button.setForeground(Color.WHITE);
        button.setOpaque(false);

        // FlatLaf: bordes redondeados
        button.putClientProperty("JButton.arc", 999);
        button.putClientProperty("JButton.buttonType", "roundRect");

        // Tamaño compacto
        button.setPreferredSize(new Dimension(70, 24)); // ancho, alto

        add(button);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        button.setText((value == null) ? "" : value.toString());
        return this;
    }
}
