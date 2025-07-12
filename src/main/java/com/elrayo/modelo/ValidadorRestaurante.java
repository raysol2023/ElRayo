
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

    public static boolean noVacioDireccion(String direccion) {
        if (direccion == null || direccion.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "⚠️ Rellene el campo dirección.");
            return false;
        }
        return true;
    }

    public static boolean esTelefonoValido(String telefono) {
        if (telefono == null || !telefono.matches("\\d{9}")) {
            JOptionPane.showMessageDialog(null, "❌ Teléfono inválido. Deben ser 9 dígitos.");
            return false;
        }
        return true;
    }  
}
