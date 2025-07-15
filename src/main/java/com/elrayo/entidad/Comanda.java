package com.elrayo.entidad;

import java.time.LocalDateTime;

public class Comanda {

    private int idCliente;
    private Integer idRestaurante;
    private boolean requiereCompra;
    private double distanciaKm;
    private double tarifaTotal;
    private LocalDateTime fechaHora;

  
    private Cliente cliente;
    private Restaurante restaurante;
    private int idComanda;

    public int getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(int idComanda) {
        this.idComanda = idComanda;
    }

    public Comanda() {
    }

    public Comanda(int idCliente, Integer idRestaurante, boolean requiereCompra,
                   double distanciaKm, LocalDateTime fechaHora) {
        this.idCliente = idCliente;
        this.idRestaurante = idRestaurante;
        this.requiereCompra = requiereCompra;
        this.distanciaKm = distanciaKm;
        this.fechaHora = fechaHora;
        calcularTarifa();
    }

  
    public void calcularTarifa() {
        if (distanciaKm <= 3) {
            tarifaTotal = 6;
        } else {
            tarifaTotal = distanciaKm * 2;
        }

        if (requiereCompra) {
            tarifaTotal += 10;
        }
    }

    // Getters y Setters

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
}
