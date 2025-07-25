package com.elrayo.entidad;

public class DetallePago {

    private double montoPedido;
    private String metodoPago;
    private boolean pagado;
    private String observacion;

    private double totalPagado;
    private double saldo;

    public void calcularSaldo(double tarifaTotal) {
        this.saldo = tarifaTotal - totalPagado;
    }

    public double getMontoPedido() {
        return montoPedido;
    }

    public void setMontoPedido(double montoPedido) {
        this.montoPedido = montoPedido;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public double getTotalPagado() {
        return totalPagado;
    }

    public void setTotalPagado(double totalPagado) {
        this.totalPagado = totalPagado;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "DetallePago{" + "montoPedido=" + montoPedido + ", metodoPago=" + metodoPago + ", pagado=" + pagado + ", observacion=" + observacion + ", totalPagado=" + totalPagado + ", saldo=" + saldo + '}';
    }
}
