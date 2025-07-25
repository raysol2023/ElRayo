package com.elrayo.entidad;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class SesionComanda {

    private static ComandaTemporal comanda = new ComandaTemporal();

    public static void setIdComanda(int id) {
        comanda.setIdComanda(id);
    }

    public static void setIdCliente(Cliente id) {
        comanda.setIdCliente(id);
    }

    public static void setIdRestaurante(Restaurante id) {
        comanda.setIdRestaurante(id);
    }

    public static void setFechaHora(Timestamp fecha) {
        comanda.setFechaHora(fecha);
    }

    public static void setRequiereCompra(boolean requiere) {
        comanda.setRequiereCompra(requiere);
    }

    public static void setDistanciaKm(double distancia) {
        comanda.setDistanciaKm(distancia);
    }

    public static void setTarifaTotal(double tarifa) {
        comanda.setTarifaTotal(tarifa);
    }

    public static void setTipoPedido(String tipo) {
        comanda.setTipoPedido(tipo);
    }

    public static void setMontoPedido(double monto) {
        comanda.setMontoPedido(monto);
    }

    public static void setIdMotorizado(Motorizado id) {
        comanda.setIdMotorizado(id);
    }

    public static void setMetodoPago(String metodo) {
        comanda.setMetodoPago(metodo);
    }

    public static void setObservacion(String obs) {
        comanda.setObservacion(obs);
    }

    public static void setComision(double comision) {
        comanda.setComision(comision);
    }

    public static void setPenalidad(BigDecimal penalidad) {
        comanda.setPenalidad(penalidad);
    }

    public static void setPagado(boolean pagado) {
        comanda.setPagado(pagado);
    }
    
    public static void setMontoDelivery(double pagado) {
        comanda.setMontoDelivery(pagado);
    }

    public static ComandaTemporal getComanda() {
        return comanda;
    }
    

    public static void reset() {
        comanda = new ComandaTemporal();
    }
}
