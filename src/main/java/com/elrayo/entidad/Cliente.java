package com.elrayo.entidad;

public class Cliente extends Persona {

    private String dni;


    private int id;


    public Cliente() {
    }


    public Cliente(String dni, int id, String nombre, String telefono, String direccion) {
        super(nombre, telefono, direccion);
        this.dni = dni;
        this.id = id;
    }
        
        
    public Cliente(String nombre, String telefono, String direccion) {

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
