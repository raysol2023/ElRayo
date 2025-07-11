package com.elrayo.entidad;

public class ProductoComanda {
    private String nombreProducto;
    private double precioUnitario;

    public ProductoComanda() {}

    public ProductoComanda(String nombreProducto, double precioUnitario) {
        this.nombreProducto = nombreProducto;
        this.precioUnitario = precioUnitario;
    }

    public String getNombreProducto() { return nombreProducto; }
    public void setNombreProducto(String nombreProducto) { this.nombreProducto = nombreProducto; }

    public double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(double precioUnitario) { this.precioUnitario = precioUnitario; }
}
