package com.elrayo.modelo;

import javax.swing.JOptionPane;

public class ValidadorCliente {

        public static boolean esDniValido(String dni) {
        if (dni == null || dni.trim().isEmpty() || !dni.matches("\\d{11}")) {
            JOptionPane.showMessageDialog(null, "❌ dni inválido. Deben ser 11 dígitos numéricos.");
            return false;
        }
        return true;
    }
    public static boolean esTelefonoValido(String telefono) {
        if (telefono == null || telefono.trim().isEmpty() || !telefono.matches("\\d{9}")) {
            JOptionPane.showMessageDialog(null, "❌ Teléfono inválido. Deben ser 9 dígitos numéricos.");
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

    public static boolean noVacioDireccion(String direccion) {
        if (direccion == null || direccion.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "⚠ Rellena el campo DIRECCIÓN.");
            return false;
        }
        return true;
    }
}
