package com.elrayo.entidad;

public class Pago {
    private String metodoPago;
    private double monto;

    public Pago() {}

    public Pago(String metodoPago, double monto) {
        this.metodoPago = metodoPago;
        this.monto = monto;
    }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }

    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }
}
