package com.elrayo.dao;

import com.elrayo.entidad.Cliente;
import java.sql.Connection;
import com.elrayo.util.ConexionDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void GuardarCliente(Cliente n) {
        String sql = " INSERT INTO clientes(nombre, telefono, direccion)VALUES(?,?,?)";
        ConexionDB BD = new ConexionDB();
        try (Connection conn = BD.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, n.getNombre());
            stmt.setString(2, n.getTelefono());
            stmt.setString(3, n.getDireccion());
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("✔ Cliente guardado correctamente en la base de datos.");
            } else {
                System.out.println("❌ No se pudo guardar el Cliente.");
            }

        } catch (SQLException e) {
            System.out.println("⚠ Error al guardar Cliente: " + e.getMessage());
        }
    }

    public List<Cliente> ObtenerTodos() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try (Connection conn = new ConexionDB().getConexion(); PreparedStatement stmt = conn.prepareCall(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id_cliente")); 
                c.setNombre(rs.getString("nombre"));
                c.setTelefono(rs.getString("telefono"));
                c.setDireccion(rs.getString("direccion"));
                lista.add(c);
            }

        } catch (SQLException e) {
            System.out.println("⚠ Error al obtener clientes: " + e.getMessage());
        }
        return lista;
    }

    public boolean eliminarPorNombre(String nombre) {
        String sql = "DELETE FROM clientes WHERE nombre = ?";

        try (Connection conn = new ConexionDB().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombre);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("⚠ Error al eliminar cliente: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizar(Cliente c) {
        String sql = "UPDATE clientes SET telefono = ?, direccion = ? WHERE nombre = ?";

        try (Connection conn = new ConexionDB().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getTelefono());
            stmt.setString(2, c.getDireccion());
            stmt.setString(3, c.getNombre());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("⚠ Error al actualizar cliente: " + e.getMessage());
            return false;
        }
    }

    public List<Cliente> buscar(String filtro) {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes WHERE nombre LIKE ? OR telefono LIKE ?";

        try (Connection conn = new ConexionDB().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + filtro + "%");
            stmt.setString(2, "%" + filtro + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setNombre(rs.getString("nombre"));
                c.setTelefono(rs.getString("telefono"));
                c.setDireccion(rs.getString("direccion"));
                lista.add(c);
            }

        } catch (SQLException e) {
            System.out.println("⚠ Error al buscar cliente: " + e.getMessage());
        }

        return lista;
    }
}
