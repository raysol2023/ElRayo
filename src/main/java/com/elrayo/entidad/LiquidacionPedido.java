package com.elrayo.entidad;

public class LiquidacionPedido {

    private double total;
    private double parteLocal;
    private double parteRayo;
    private double parteMotorizado;

    public void repartir(double total, double pctLocal, double pctRayo, double pctMotorizado) {
        this.total = total;
        parteLocal = total * pctLocal;
        parteRayo = total * pctRayo;
        parteMotorizado = total * pctMotorizado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getParteLocal() {
        return parteLocal;
    }

    public void setParteLocal(double parteLocal) {
        this.parteLocal = parteLocal;
    }

    public double getParteRayo() {
        return parteRayo;
    }

    public void setParteRayo(double parteRayo) {
        this.parteRayo = parteRayo;
    }

    public double getParteMotorizado() {
        return parteMotorizado;
    }

    public void setParteMotorizado(double parteMotorizado) {
        this.parteMotorizado = parteMotorizado;
    }

    @Override
    public String toString() {
        return "LiquidacionPedido{" + "total=" + total + ", parteLocal=" + parteLocal + ", parteRayo=" + parteRayo + ", parteMotorizado=" + parteMotorizado + '}';
    }   
}
