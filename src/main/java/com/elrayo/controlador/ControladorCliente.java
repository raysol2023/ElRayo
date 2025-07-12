package com.elrayo.controlador;

import com.elrayo.dao.ClienteDAO;
import com.elrayo.entidad.Cliente;
import com.elrayo.modelo.ValidadorCliente;

public class ControladorCliente {

    private ClienteDAO dao = new ClienteDAO();

    public boolean RegistrarCliente(Cliente n) {
        if (ValidadorCliente.esTelefonoValido(n.getTelefono())
                && ValidadorCliente.noVacioNombre(n.getNombre())
                && ValidadorCliente.noVacioDireccion(n.getDireccion())) {;
            dao.GuardarCliente(n);
            return true;
        }
        return false;
    }

}
