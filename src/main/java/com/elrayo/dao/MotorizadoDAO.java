package com.elrayo.dao;

import com.elrayo.entidad.Motorizado;
import com.elrayo.util.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotorizadoDAO {

    public void guardar(Motorizado m) {
        String sql = "INSERT INTO motorizados (nombres, telefono, dni, activo) VALUES (?, ?, ?, ?)";

        ConexionDB db = new ConexionDB();

        try (Connection conn = db.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, m.getNombre());
            stmt.setString(2, m.getTelefono());
            stmt.setString(3, m.getDni());
            stmt.setBoolean(4, m.isActivo());

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("✔ Motorizado guardado correctamente en la base de datos.");
            } else {
                System.out.println("❌ No se pudo guardar el motorizado.");
            }

        } catch (SQLException e) {
            System.out.println("⚠ Error al guardar motorizado: " + e.getMessage());
        }

    }

    public boolean eliminarPorDni(String dni) {
        String sql = "DELETE FROM motorizados WHERE dni = ?";

        try (Connection conn = new ConexionDB().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dni);

            int filas = stmt.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            System.out.println("⚠ Error al eliminar motorizado: " + e.getMessage());
            return false;
        }
    }

    public List<Motorizado> obtenerTodos() {
        List<Motorizado> lista = new ArrayList<>();
        String sql = "SELECT * FROM motorizados";

        try (Connection conn = new ConexionDB().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Motorizado m = new Motorizado();
                m.setNombre(rs.getString("nombres"));
                m.setTelefono(rs.getString("telefono"));
                m.setDni(rs.getString("dni"));
                m.setActivo(rs.getBoolean("activo"));
                lista.add(m);
            }

        } catch (SQLException e) {
            System.out.println("⚠ Error al obtener motorizados: " + e.getMessage());
        }

        return lista;
    }

    public boolean actualizar(Motorizado m) {
        String sql = "UPDATE motorizados SET nombres = ?, telefono = ?, activo = ? WHERE dni = ?";

        try (Connection conn = new ConexionDB().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, m.getNombre());
            stmt.setString(2, m.getTelefono());
            stmt.setBoolean(3, m.isActivo());
            stmt.setString(4, m.getDni());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("⚠ Error al actualizar motorizado: " + e.getMessage());
            return false;
        }
    }
}
