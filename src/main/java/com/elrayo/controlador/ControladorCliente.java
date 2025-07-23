package com.elrayo.controlador;

import com.elrayo.dao.ClienteDAO;
import com.elrayo.entidad.Cliente;
import com.elrayo.modelo.ValidadorCliente;
import java.util.List;

public class ControladorCliente {

    private ClienteDAO dao = new ClienteDAO();

    public void registrarCliente(Cliente ObjCliente) throws Exception {
        if (ValidadorCliente.esDniValido(ObjCliente.getDni())
                && ValidadorCliente.esTelefonoValido(ObjCliente.getTelefono())
                && ValidadorCliente.noVacioNombre(ObjCliente.getNombre())
                && ValidadorCliente.noVacioDireccion(ObjCliente.getDireccion())) {
            dao.registrar(ObjCliente);
        }
    }

    public List<Cliente> mostrarClientes(String name) throws Exception {
        return dao.listar(name);
    }

    public boolean editarCliente(Cliente objCliente) throws Exception {
        if (ValidadorCliente.esDniValido(objCliente.getDni())
                && ValidadorCliente.esTelefonoValido(objCliente.getTelefono())
                && ValidadorCliente.noVacioNombre(objCliente.getNombre())
                && ValidadorCliente.noVacioDireccion(objCliente.getDireccion())) {
            dao.modificar(objCliente);
            return true;
        }
        return false;
    }

    public void eliminar(int id) throws Exception {
        dao.eliminar(id);
    }

    public boolean tieneComandas(int id) throws Exception{
        return dao.tieneComandas(id);
    }
    
    public Cliente editarUnCliente(int id) throws Exception {
        return dao.getClientById(id);
    }

}
