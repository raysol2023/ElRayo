package com.elrayo.entidad;

public class Cliente extends Persona {

    private int id;
    private String dni;

    public Cliente() {
    }

    public Cliente(String dni, String nombre, String telefono, String direccion) {

        super(nombre, telefono, direccion);
        this.dni = dni;
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
