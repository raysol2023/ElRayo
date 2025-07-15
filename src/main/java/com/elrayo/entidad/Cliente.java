package com.elrayo.entidad;

public class Cliente extends Persona {

    private int id;

    public Cliente() {
    }

    public Cliente(String nombre, String telefono, String direccion) {
        super(nombre, telefono, direccion);
    }

    public String getDireccion() {
        return this.direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

}
