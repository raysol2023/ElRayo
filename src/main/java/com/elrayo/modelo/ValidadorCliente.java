package com.elrayo.modelo;

import javax.swing.JOptionPane;

public class ValidadorCliente {

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
