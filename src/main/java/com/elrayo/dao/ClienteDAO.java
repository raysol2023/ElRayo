package com.elrayo.dao;

import com.elrayo.entidad.Cliente;
import java.sql.Connection;
import com.elrayo.util.ConexionDB;
import com.elrayo.modelo.IClienteDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends ConexionDB implements IClienteDao {

    @Override
    public void registrar(Cliente objCliente) throws Exception {
        String sql = "INSERT INTO clientes(nombre, dni, telefono, direccion) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = getConexion().prepareStatement(sql)) {
            stmt.setString(1, objCliente.getNombre());
            stmt.setString(2, objCliente.getDni());
            stmt.setString(3, objCliente.getTelefono());
            stmt.setString(4, objCliente.getDireccion());

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("Cliente guardado correctamente en la base de datos.");
            } else {
                System.out.println("No se pudo guardar el cliente.");
            }

        } catch (SQLException e) {
            System.out.println("Error al guardar cliente: " + e.getMessage());
            throw e; // vuelve a lanzar la excepción si quieres manejarla desde otro lugar
        }
    }

    @Override
    public void modificar(Cliente objCliente) throws Exception {
        String sql = "UPDATE clientes SET nombre = ?, dni = ?, telefono = ?, direccion = ? WHERE id_cliente = ?";

        try (Connection conn = new ConexionDB().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, objCliente.getNombre());
            stmt.setString(2, objCliente.getDni());
            stmt.setString(3, objCliente.getTelefono());
            stmt.setString(4, objCliente.getDireccion());
            stmt.setInt(5, objCliente.getId());  // Usa el ID del cliente

            stmt.executeUpdate();
            System.out.println("Cliente actualizado: " + objCliente.toString());

        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int clienteId) throws Exception {
        String sql = "DELETE FROM clientes WHERE id_cliente = ?";

        try (PreparedStatement stmt = getConexion().prepareStatement(sql)) {
            stmt.setInt(1, clienteId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
        }
    }

    @Override
    public List<Cliente> listar(String busqueda) throws Exception {
        List<Cliente> lista = new ArrayList<>();

        String sql = busqueda.isEmpty()
                ? "SELECT * FROM clientes"
                : "SELECT * FROM clientes WHERE nombre LIKE ? OR dni LIKE ? OR telefono LIKE ? OR direccion LIKE ?";

        try (PreparedStatement stmt = getConexion().prepareStatement(sql)) {

            if (!busqueda.isEmpty()) {
                String filtro = "%" + busqueda + "%";
                stmt.setString(1, filtro);
                stmt.setString(2, filtro);
                stmt.setString(3, filtro);
                stmt.setString(4, filtro);
            }

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id_cliente"));
                c.setNombre(rs.getString("nombre"));
                c.setDni(rs.getString("dni"));
                c.setTelefono(rs.getString("telefono"));
                c.setDireccion(rs.getString("direccion"));
                lista.add(c);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener clientes: " + e.getMessage());
        }

        return lista;
    }

    @Override
    public Cliente getClientById(int clientId) throws Exception {
        Cliente objCliente = new Cliente();
        String sql = "SELECT * FROM clientes WHERE id_cliente  = ? LIMIT 1";

        try (PreparedStatement stmt = getConexion().prepareStatement(sql)) {
            stmt.setInt(1, clientId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                objCliente.setId(rs.getInt("id_cliente"));
                objCliente.setNombre(rs.getString("nombre"));
                objCliente.setDni(rs.getString("dni"));
                objCliente.setTelefono(rs.getString("telefono"));
                objCliente.setDireccion(rs.getString("direccion"));
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener clientes: " + e.getMessage());
        }

        return objCliente;
    }

    @Override
    public boolean tieneComandas(int idCliente) {
        String sql = "SELECT COUNT(*) FROM comandas WHERE id_cliente = ?";

        try (PreparedStatement stmt = getConexion().prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar comandas: " + e.getMessage());
        }

        return false;
    }
}
