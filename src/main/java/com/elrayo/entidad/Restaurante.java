package com.elrayo.entidad;

import com.elrayo.modelo.IReportable;

public class Restaurante extends Persona implements IReportable {
    private boolean tieneConvenio;
    private String ruc;

    public Restaurante() {}

    public Restaurante(String nombre, String telefono, String direccion, boolean tieneConvenio) {
        super(nombre, telefono, direccion);
        this.tieneConvenio = tieneConvenio;
    }

    public boolean isTieneConvenio() { return tieneConvenio; }
    public void setTieneConvenio(boolean tieneConvenio) { this.tieneConvenio = tieneConvenio; }

    public void generarReporteDeuda() {
        System.out.println("Generando reporte de deuda para restaurante: " + this.nombre);
    }

    @Override
    public String generarReporte() {
        return "Reporte general del restaurante: " + this.nombre;
    }
}
