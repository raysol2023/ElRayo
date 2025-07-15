package com.elrayo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.elrayo.util.ConexionDB;
import com.elrayo.entidad.Restaurante;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestauranteDAO {

    String sql = "INSERT INTO restaurantes (nombre, direccion, telefono, tiene_convenio) VALUES (?, ?, ?, ?)";

    public void guardar(Restaurante r) {
        try (Connection conn = new ConexionDB().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, r.getNombre());
            stmt.setString(2, r.getDireccion());
            stmt.setString(3, r.getTelefono());
            stmt.setBoolean(4, r.isTieneConvenio());

            stmt.executeUpdate();
            System.out.println("✔ Restaurante guardado.");

        } catch (SQLException e) {
            System.out.println("⚠ Error al guardar restaurante: " + e.getMessage());
        }
    }

    public List<Restaurante> obtenerTodos() {
    List<Restaurante> lista = new ArrayList<>();
    String sql = "SELECT * FROM restaurantes";

    try (Connection conn = new ConexionDB().getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Restaurante r = new Restaurante();
            r.setId(rs.getInt("id_restaurante")); 
            r.setNombre(rs.getString("nombre"));
            r.setDireccion(rs.getString("direccion"));
            r.setTelefono(rs.getString("telefono"));
            r.setTieneConvenio(rs.getBoolean("tiene_convenio"));
            lista.add(r);
        }

    } catch (SQLException e) {
        System.out.println("⚠ Error al obtener restaurantes: " + e.getMessage());
    }

    return lista;
}

    public boolean eliminarPorNombre(String nombre) {
        String sql = "DELETE FROM restaurantes WHERE nombre = ?";

        try (Connection conn = new ConexionDB().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombre);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("⚠ Error al eliminar restaurante: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizar(Restaurante r) {
        String sql = "UPDATE restaurantes SET direccion = ?, telefono = ?, tiene_convenio = ? WHERE nombre = ?";

        try (Connection conn = new ConexionDB().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, r.getDireccion());
            stmt.setString(2, r.getTelefono());
            stmt.setBoolean(3, r.isTieneConvenio());
            stmt.setString(4, r.getNombre());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("⚠ Error al actualizar restaurante: " + e.getMessage());
            return false;
        }
    }

    public List<Restaurante> buscar(String filtro) {
        List<Restaurante> lista = new ArrayList<>();
        String sql = "SELECT * FROM restaurantes WHERE nombre LIKE ? OR telefono LIKE ?";

        try (Connection conn = new ConexionDB().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + filtro + "%");
            stmt.setString(2, "%" + filtro + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Restaurante r = new Restaurante();
                r.setId(rs.getInt("id_restaurante"));
                r.setNombre(rs.getString("nombre"));
                r.setTelefono(rs.getString("telefono"));
                r.setDireccion(rs.getString("direccion"));
                r.setTieneConvenio(rs.getBoolean("tiene_convenio"));
                lista.add(r);
            }

        } catch (SQLException e) {
            System.out.println("⚠ Error al buscar restaurante: " + e.getMessage());
        }

        return lista;
    }

}
