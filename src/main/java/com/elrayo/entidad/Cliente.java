package com.elrayo.entidad;

public class Cliente extends Persona {
    public Cliente() {}
    public Cliente(String nombre, String telefono, String direccion) {
        super(nombre, telefono, direccion);
    }

    public String getDireccion() {
        return this.direccion;
    }
}
