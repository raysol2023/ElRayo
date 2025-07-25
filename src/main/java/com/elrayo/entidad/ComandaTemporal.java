package com.elrayo.entidad;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class ComandaTemporal {
    private int idComanda;
    private Cliente idCliente;
    private Restaurante idRestaurante;
    private Timestamp fechaHora;
    private boolean requiereCompra;
    private double distanciaKm;
    private double tarifaTotal;
    private String tipoPedido;
    private double montoPedido;
    private double montoDelivery;
    private Motorizado idMotorizado;
    private String metodoPago;
    private String observacion;
    private double comision;
    private BigDecimal penalidad;
    private boolean pagado;

    public ComandaTemporal() {
    }

    public int getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(int idComanda) {
        this.idComanda = idComanda;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Restaurante getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(Restaurante idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }

    public boolean isRequiereCompra() {
        return requiereCompra;
    }

    public void setRequiereCompra(boolean requiereCompra) {
        this.requiereCompra = requiereCompra;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public double getTarifaTotal() {
        return tarifaTotal;
    }

    public void setTarifaTotal(double tarifaTotal) {
        this.tarifaTotal = tarifaTotal;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public double getMontoPedido() {
        return montoPedido;
    }

    public void setMontoPedido(double montoPedido) {
        this.montoPedido = montoPedido;
    }

    public double getMontoDelivery() {
        return montoDelivery;
    }

    public void setMontoDelivery(double montoDelivery) {
        this.montoDelivery = montoDelivery;
    }

    public Motorizado getIdMotorizado() {
        return idMotorizado;
    }

    public void setIdMotorizado(Motorizado idMotorizado) {
        this.idMotorizado = idMotorizado;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public BigDecimal getPenalidad() {
        return penalidad;
    }

    public void setPenalidad(BigDecimal penalidad) {
        this.penalidad = penalidad;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    @Override
    public String toString() {
        return "Resumen del pedido" +
                
                "\n\nCliente" +
                "\nNombres: " + idCliente.getNombre() + 
                "\nWhhatsApp: " + idCliente.getTelefono() +
                "\nDireccion: " + idCliente.getDireccion() +
                "\nDistanciaKm: " + distanciaKm + 
                
                "\n\nRestaurante"+
                "\nNombre: " + idRestaurante.getNombre() +
                "\nDireccion: " + idRestaurante.getDireccion() + 
                
                "\n\nMotorizado" +
                "\nNombre: " + idMotorizado.getNombre() +
                "\nDni: " + idMotorizado.getDni() + 
                
                "\n\nTarifa" +
                "\nTarifa Total: " + tarifaTotal +
                "\nMonto Pedido: " + montoPedido +
                "\nMonto del Delivery: " + montoDelivery +
                "\nObservacion:" + observacion;
    }

    
}
