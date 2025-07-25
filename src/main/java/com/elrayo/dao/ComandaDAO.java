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
        String sql = "INSERT INTO comandas (id_cliente, id_restaurante, fecha_hora, requiere_compra, distancia_km, tarifa_total, tipo_pedido, monto_pedido, metodo_pago, pagado, observacion, comision, penalidad, id_motorizado) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
            stmt.setDouble(6, c.getTarifaTotal()); // usa método que invoca TarifaComanda

            stmt.setString(7, c.getTipoPedido());
            stmt.setDouble(8, c.getMontoPedido());
            stmt.setString(9, c.getMetodoPago());
            stmt.setBoolean(10, c.isPagado());
            stmt.setString(11, c.getObservacion());
            stmt.setDouble(12, c.getComision());
            stmt.setDouble(13, c.getPenalidad());

            if (c.getIdMotorizado() != null) {
                stmt.setInt(14, c.getIdMotorizado());
            } else {
                stmt.setNull(14, java.sql.Types.INTEGER);
            }

            return stmt.executeUpdate() > 0;

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

        try (Connection conn = new ConexionDB().getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Comanda c = new Comanda();

                c.setIdComanda(rs.getInt("id_comanda"));
                c.setIdCliente(rs.getInt("id_cliente"));
                c.setIdRestaurante(rs.getObject("id_restaurante") != null ? rs.getInt("id_restaurante") : null);
                c.setFechaHora(rs.getTimestamp("fecha_hora").toLocalDateTime());
                c.setRequiereCompra(rs.getBoolean("requiere_compra"));
                c.setDistanciaKm(rs.getDouble("distancia_km"));

                // Campos de lógica separada (internamente setean tarifa y pago)
                c.setTipoPedido(rs.getString("tipo_pedido"));
                c.setMontoPedido(rs.getDouble("monto_pedido"));
                c.setMetodoPago(rs.getString("metodo_pago"));
                c.setPagado(rs.getBoolean("pagado"));
                c.setObservacion(rs.getString("observacion"));
                c.setComision(rs.getDouble("comision"));
                c.setPenalidad(rs.getDouble("penalidad"));
                c.setIdMotorizado(rs.getObject("id_motorizado") != null ? rs.getInt("id_motorizado") : null);

                // Cliente asociado
                Cliente cliente = new Cliente();
                cliente.setNombre(rs.getString("nombre_cliente"));
                c.setCliente(cliente);

                // Restaurante asociado (opcional)
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
