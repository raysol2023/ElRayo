package com.elrayo.controlador;

import com.elrayo.dao.ClienteDAO;
import com.elrayo.entidad.Cliente;
import com.elrayo.modelo.ValidadorCliente;
import java.util.List;

public class ControladorCliente {

    private ClienteDAO dao = new ClienteDAO();

    public boolean registrarCliente(Cliente cliente) {
        if (ValidadorCliente.esDniValido(cliente.getDni())
                && ValidadorCliente.esTelefonoValido(cliente.getTelefono())
                && ValidadorCliente.noVacioNombre(cliente.getNombre())
                && ValidadorCliente.noVacioDireccion(cliente.getDireccion())) {
            dao.GuardarCliente(cliente);
            return true;
        }
        return false;
    }

    public List<Cliente> mostrarClientes() {
        return dao.ObtenerTodos();
    }
    
    public boolean editarCliente(Cliente cliente){
        if (ValidadorCliente.esDniValido(cliente.getDni())
                && ValidadorCliente.esTelefonoValido(cliente.getTelefono())
                && ValidadorCliente.noVacioNombre(cliente.getNombre())
                && ValidadorCliente.noVacioDireccion(cliente.getDireccion())) {
            dao.actualizar(cliente);
            return true;
        }
        return false;
    }
            
}
