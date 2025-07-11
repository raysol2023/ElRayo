package com.elrayo.entidad;

import com.elrayo.modelo.IReportable;

public class Motorizado extends Persona implements IReportable {
    private int idMotorizado;
    private String dni;
    private boolean activo;

    public Motorizado() {}

    public Motorizado(String nombre, String telefono, String direccion, String dni, boolean activo) {
        super(nombre, telefono, direccion);
        this.dni = dni;
        this.activo = activo;
    }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    @Override
    public String generarReporte() {
        return "Reporte del motorizado: " + this.nombre;
    }


}