package com.elrayo.entidad;

public class Comanda {
    private Cliente cliente;
    private Restaurante restaurante;
    private boolean requiereCompra;
    private double tarifaTotal;

    public Comanda() {}

    public Comanda(Cliente cliente, Restaurante restaurante, boolean requiereCompra, double tarifaTotal) {
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.requiereCompra = requiereCompra;
        this.tarifaTotal = tarifaTotal;
    }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Restaurante getRestaurante() { return restaurante; }
    public void setRestaurante(Restaurante restaurante) { this.restaurante = restaurante; }

    public boolean isRequiereCompra() { return requiereCompra; }
    public void setRequiereCompra(boolean requiereCompra) { this.requiereCompra = requiereCompra; }

    public double getTarifaTotal() { return tarifaTotal; }
    public void setTarifaTotal(double tarifaTotal) { this.tarifaTotal = tarifaTotal; }

    public void calcularTarifa(double distanciaKm) {
        if (distanciaKm <= 3) {
            tarifaTotal = 6.0;
        } else {
            tarifaTotal = distanciaKm * 2.0;
        }
    }
}
