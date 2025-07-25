package com.elrayo.modelo;

import javax.swing.JOptionPane;

public class ValidadorMotorizado {

    public static boolean esDniValido(String dni) {
        if (dni == null || !dni.matches("\\d{8}")) {
            JOptionPane.showMessageDialog(null, "❌ DNI inválido. Deben ser 8 dígitos.");
            return false;
        }
        return true;
    }

    public static boolean noVacioNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "⚠ Rellena el campo NOMBRE.");
            return false;
        }
        return true;
    }

    public static boolean esTelefonoValido(String telefono) {
        if (telefono == null || telefono.trim().isEmpty() || !telefono.matches("\\+51\\s9\\d{2}\\s\\d{3}\\s\\d{3}")) {
            JOptionPane.showMessageDialog(null, "❌ Teléfono inválido. Usa el formato: +51 9xx xxx xxx");
            return false;
        }
        return true;
    }
}
