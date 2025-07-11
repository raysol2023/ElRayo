package com.elrayo.entidad;

public class Asignacion {
    private Motorizado motorizado;
    private Comanda comanda;

    public Asignacion() {}

    public Asignacion(Motorizado motorizado, Comanda comanda) {
        this.motorizado = motorizado;
        this.comanda = comanda;
    }

    public Motorizado getMotorizado() { return motorizado; }
    public void setMotorizado(Motorizado motorizado) { this.motorizado = motorizado; }

    public Comanda getComanda() { return comanda; }
    public void setComanda(Comanda comanda) { this.comanda = comanda; }

    public void marcarEntrega() {
        System.out.println("Entrega marcada para la comanda del cliente: " + comanda.getCliente().getNombre());
    }
}
