package com.elrayo.modelo;

public class ValidadorMotorizado {
    public static boolean esDniValido(String dni) {
        return dni != null && dni.matches("\\d{8}");
    }
    public static boolean esTelefonoValido(String telefono) {
        return telefono != null && telefono.matches("\\d{9}");
    }
}