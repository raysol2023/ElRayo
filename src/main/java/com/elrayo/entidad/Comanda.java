package com.elrayo.entidad;

import java.time.LocalDateTime;

public class Comanda {

    private int idComanda;
    private int idCliente;
    private Integer idRestaurante;
    private Integer idMotorizado;
    private boolean requiereCompra;
    private double distanciaKm;
    private LocalDateTime fechaHora;

    private Cliente cliente;
    private Restaurante restaurante;

    private TarifaComanda tarifa;
    private DetallePago detallePago;

    public Comanda() {
        this.fechaHora = LocalDateTime.now();
        this.tarifa = new TarifaComanda();
        this.detallePago = new DetallePago();
    }


    public int getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(int idComanda) {
        this.idComanda = idComanda;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(Integer idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public Integer getIdMotorizado() {
        return idMotorizado;
    }

    public void setIdMotorizado(Integer idMotorizado) {
        this.idMotorizado = idMotorizado;
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

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public TarifaComanda getTarifa() {
        return tarifa;
    }

    public void setTarifa(TarifaComanda tarifa) {
        this.tarifa = tarifa;
    }

    public DetallePago getDetallePago() {
        return detallePago;
    }

    public void setDetallePago(DetallePago detallePago) {
        this.detallePago = detallePago;
    }


    public double getTarifaTotal() {
        return tarifa.calcularTotal();
    }

    public void setTarifaTotal(double valor) {
        // opcional, si decides almacenar el valor en tarifa (no lo necesitas si siempre recalculas)
    }

    public String getTipoPedido() {
        return tarifa.getTipoPedido();
    }

    public void setTipoPedido(String tipo) {
        tarifa.setTipoPedido(tipo);
    }

    public double getMontoPedido() {
        return detallePago.getMontoPedido();
    }

    public void setMontoPedido(double monto) {
        detallePago.setMontoPedido(monto);
    }

    public String getMetodoPago() {
        return detallePago.getMetodoPago();
    }

    public void setMetodoPago(String metodoPago) {
        detallePago.setMetodoPago(metodoPago);
    }

    public boolean isPagado() {
        return detallePago.isPagado();
    }

    public void setPagado(boolean pagado) {
        detallePago.setPagado(pagado);
    }

    public String getObservacion() {
        return detallePago.getObservacion();
    }

    public void setObservacion(String obs) {
        detallePago.setObservacion(obs);
    }

    public double getComision() {
        return tarifa.getComision();
    }

    public void setComision(double comision) {
        tarifa.setComision(comision);
    }

    public double getPenalidad() {
        return tarifa.getPenalidad();
    }

    public void setPenalidad(double penalidad) {
        tarifa.setPenalidad(penalidad);
    }
}
