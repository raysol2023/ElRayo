package com.elrayo.controlador;

import com.elrayo.dao.ClienteDAO;
import com.elrayo.entidad.Cliente;
import com.elrayo.modelo.ValidadorCliente;

public class ControladorCliente {

    private ClienteDAO dao = new ClienteDAO();

    public boolean registrarCliente(Cliente cliente) {
        if (
            ValidadorCliente.esTelefonoValido(cliente.getTelefono()) &&
            ValidadorCliente.noVacioNombre(cliente.getNombre()) &&
            ValidadorCliente.noVacioDireccion(cliente.getDireccion())
        ) {
            dao.GuardarCliente(cliente);
            return true;
        }
        return false;
    }
}

