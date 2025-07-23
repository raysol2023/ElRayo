package com.elrayo.modelo;

import com.elrayo.entidad.Cliente;

import java.util.List;

public interface IClienteDao {
    public void registrar(Cliente objCliente) throws Exception;
    public void modificar(Cliente objCliente) throws Exception;
    public void eliminar(int clienteId) throws Exception;
    public List<Cliente> listar(String name) throws Exception;
    public Cliente getClientById(int clienteId) throws Exception;
    public boolean tieneComandas(int idCliente) throws Exception;
}
