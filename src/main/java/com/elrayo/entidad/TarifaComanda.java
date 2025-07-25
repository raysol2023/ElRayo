package com.elrayo.entidad;

public class TarifaComanda {
  private String tipoPedido; // Regular, Courier, Hora, Comisión, Tardanza
    private double km;
    private boolean requiereCompra;
    private double comision;
    private double penalidad;

    public TarifaComanda() {
    }

    public TarifaComanda(String tipoPedido, double km, boolean requiereCompra, double comision, double penalidad) {
        this.tipoPedido = tipoPedido;
        this.km = km;
        this.requiereCompra = requiereCompra;
        this.comision = comision;
        this.penalidad = penalidad;
    }

    public double calcularTotal() {
        double tarifa = (km <= 3) ? 6 : km * 2;

        switch (tipoPedido.toLowerCase()) {
            case "courier": tarifa += 1.5; break;
            case "hora": tarifa += 2; break;
            case "tardanza": tarifa += penalidad; break;
            case "comision": tarifa += comision; break;
        }

        if (requiereCompra) tarifa += 10;

        return Math.max(tarifa, 7.0);
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public boolean isRequiereCompra() {
        return requiereCompra;
    }

    public void setRequiereCompra(boolean requiereCompra) {
        this.requiereCompra = requiereCompra;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public double getPenalidad() {
        return penalidad;
    }

    public void setPenalidad(double penalidad) {
        this.penalidad = penalidad;
    }

    @Override
    public String toString() {
        return "TarifaComanda{" + "tipoPedido=" + tipoPedido + ", km=" + km + ", requiereCompra=" + requiereCompra + ", comision=" + comision + ", penalidad=" + penalidad + '}';
    }
}
