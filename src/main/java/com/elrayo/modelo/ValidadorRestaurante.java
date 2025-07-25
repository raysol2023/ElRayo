package com.elrayo.modelo;

import javax.swing.JOptionPane;

public class ValidadorRestaurante {

    public static boolean noVacioNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "⚠️ Rellene el campo nombre.");
            return false;
        }
        return true;
    }

    public static boolean esRUCValido(String ruc) {
        if (ruc == null || !ruc.matches("\\d{11}")) {
            JOptionPane.showMessageDialog(null, "❌ RUC inválido. Deben ser 11 dígitos.");
            return false;
        }
        return true;
    }

    public static boolean noVacioDireccion(String direccion) {
        if (direccion == null || direccion.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "⚠️ Rellene el campo dirección.");
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
