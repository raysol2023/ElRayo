package com.elrayo.entidad;

import com.elrayo.modelo.IReportable;

public class Restaurante extends Persona implements IReportable {

    private int idRestaurante;
    private String ruc;
    private boolean tieneConvenio;
    

    public Restaurante() {
    }

    public Restaurante(String nombre, String telefono, String direccion, boolean tieneConvenio) {
        super(nombre, telefono, direccion);
        this.tieneConvenio = tieneConvenio;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
    
    public boolean isTieneConvenio() {
        return tieneConvenio;
    }

    public void setTieneConvenio(boolean tieneConvenio) {
        this.tieneConvenio = tieneConvenio;
    }

    public void generarReporteDeuda() {
        System.out.println("Generando reporte de deuda para restaurante: " + this.nombre);
    }

    @Override
    public String generarReporte() {
        return "Reporte general del restaurante: " + this.nombre;
    }

    public int getidRestaurante() {
        return idRestaurante;
    }

    public void setidRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

 @Override

public String toString() {
    return this.nombre;
}
 
}
