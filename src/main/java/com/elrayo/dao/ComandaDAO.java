package com.elrayo.dao;

import com.elrayo.entidad.Cliente;
import com.elrayo.entidad.Comanda;
import com.elrayo.entidad.Restaurante;
import com.elrayo.util.ConexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComandaDAO {

    public boolean guardar(Comanda c) {
        String sql = "INSERT INTO comandas (id_cliente, id_restaurante, fecha_hora, requiere_compra, distancia_km, tarifa_total) VALUES (?, ?, ?, ?, ?, ?)";

        ConexionDB db = new ConexionDB();

        try (Connection conn = db.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, c.getIdCliente());

            if (c.getIdRestaurante() != null) {
                stmt.setInt(2, c.getIdRestaurante());
            } else {
                stmt.setNull(2, java.sql.Types.INTEGER);
            }

            stmt.setTimestamp(3, Timestamp.valueOf(c.getFechaHora()));
            stmt.setBoolean(4, c.isRequiereCompra());
            stmt.setDouble(5, c.getDistanciaKm());
            stmt.setDouble(6, c.getTarifaTotal());

            int filas = stmt.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            System.out.println("⚠ Error al guardar comanda: " + e.getMessage());
            return false;
        }
    }

    public List<Comanda> obtenerTodas() {
        List<Comanda> lista = new ArrayList<>();
        String sql = "SELECT c.*, cli.nombre AS nombre_cliente, res.nombre AS nombre_restaurante "
                + "FROM comandas c "
                + "JOIN clientes cli ON c.id_cliente = cli.id_cliente "
                + "LEFT JOIN restaurantes res ON c.id_restaurante = res.id_restaurante";

        try (Connection conn = new ConexionDB().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Comanda c = new Comanda();

                // 👇 Esta línea es la que te faltaba
                c.setIdComanda(rs.getInt("id_comanda"));

                c.setIdCliente(rs.getInt("id_cliente"));
                c.setIdRestaurante(rs.getObject("id_restaurante") != null ? rs.getInt("id_restaurante") : null);
                c.setFechaHora(rs.getTimestamp("fecha_hora").toLocalDateTime());
                c.setDistanciaKm(rs.getDouble("distancia_km"));
                c.setRequiereCompra(rs.getBoolean("requiere_compra"));
                c.setTarifaTotal(rs.getDouble("tarifa_total"));

                Cliente cliente = new Cliente();
                cliente.setNombre(rs.getString("nombre_cliente"));
                c.setCliente(cliente);

                if (rs.getString("nombre_restaurante") != null) {
                    Restaurante r = new Restaurante();
                    r.setNombre(rs.getString("nombre_restaurante"));
                    c.setRestaurante(r);
                }

                lista.add(c);
            }

        } catch (SQLException e) {
            System.out.println("⚠ Error al obtener comandas: " + e.getMessage());
        }

        return lista;
    }

    public boolean eliminarPorId(int idComanda) {
        String sql = "DELETE FROM comandas WHERE id_comanda = ?";

        try (Connection conn = new ConexionDB().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idComanda);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("⚠ Error al eliminar comanda: " + e.getMessage());
            return false;
        }
    }

}
