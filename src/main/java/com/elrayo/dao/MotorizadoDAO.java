package com.elrayo.dao;

import com.elrayo.entidad.Motorizado;
import com.elrayo.util.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MotorizadoDAO {

    public void guardar(Motorizado m) {
        String sql = "INSERT INTO motorizados (nombres, telefono, dni, activo) VALUES (?, ?, ?, ?)";

        ConexionDB db = new ConexionDB();

        try (Connection conn = db.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

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
}