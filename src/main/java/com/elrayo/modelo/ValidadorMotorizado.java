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

    public static boolean esTelefonoValido(String telefono) {
        if (telefono == null || !telefono.matches("\\d{9}")) {
            JOptionPane.showMessageDialog(null, "❌ Teléfono inválido. Deben ser 9 dígitos.");
            return false;
        }
        return true;
    }
}