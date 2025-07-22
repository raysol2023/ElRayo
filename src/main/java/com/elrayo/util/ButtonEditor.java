package com.elrayo.util;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ButtonEditor extends DefaultCellEditor {

    private final JButton button;
    private final JPanel panel;
    private String label;

    public ButtonEditor(JCheckBox checkBox, ActionListener action) {
        super(checkBox);

        // Crear botón personalizado
        button = new JButton();
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

        button.addActionListener(e -> {
            fireEditingStopped();
            action.actionPerformed(e);
        });

        // Panel contenedor centrado
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panel.setOpaque(false);
        panel.add(button);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return label;
    }
}
