
package com.elrayo.modelo;

import javax.swing.JOptionPane;


public class ValidadorCliente {
 
    public static boolean esTelefonoValido(String Telefono) {
       if (Telefono == null || !Telefono.matches("\\d{9}")) {
            JOptionPane.showMessageDialog(null, "❌ TELEFONO inválido. Deben ser 9 dígitos.");
            return false;
        }
        return true;
    }
    public static boolean noVacioNombre(String Nombre){
        if(Nombre.isEmpty()){
            JOptionPane.showMessageDialog(null, "RELLENAR EL CAMPO DE NOMBRE");
            return false;
        }
        return  true;
    }
        public static boolean noVacioDireccion(String Direccion){
        if(Direccion.isEmpty()){
            JOptionPane.showMessageDialog(null, "RELLENAR EL CAMPO DE NOMBRE");
            return false;
        }
        return  true;
    }
}
