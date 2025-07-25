package com.elrayo.dao;

import com.elrayo.entidad.Motorizado;
import com.elrayo.modelo.IMotorizadoDao;
import com.elrayo.util.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotorizadoDAO extends ConexionDB implements IMotorizadoDao {

    @Override
    public void registrar(Motorizado ObjMotorizado) throws Exception {
        String sql = "INSERT INTO motorizados (nombres, dni, telefono, activo) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = getConexion().prepareStatement(sql)) {
            stmt.setString(1, ObjMotorizado.getNombre());
            stmt.setString(2, ObjMotorizado.getDni());
            stmt.setString(3, ObjMotorizado.getTelefono());
            stmt.setBoolean(4, ObjMotorizado.isActivo());

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("Motorizado guardado correctamente en la base de datos.");
            } else {
                System.out.println("No se pudo guardar el motorizado.");
            }

        } catch (SQLException e) {
            System.out.println("Error al guardar motorizado: " + e.getMessage());
            throw e; // vuelve a lanzar la excepción si quieres manejarla desde otro lugar
        }

    }

    @Override
    public void modificar(Motorizado ObjMotorizado) throws Exception {
        String sql = "UPDATE motorizados SET nombres = ?, dni = ?, telefono = ?, activo = ? WHERE id_motorizado = ?";

        try (Connection conn = new ConexionDB().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, ObjMotorizado.getNombre());
            stmt.setString(2, ObjMotorizado.getDni());
            stmt.setString(3, ObjMotorizado.getTelefono());
            stmt.setBoolean(4, ObjMotorizado.isActivo());
            stmt.setInt(5, ObjMotorizado.getIdMotorizado());  // Usa el ID del motorizado

            stmt.executeUpdate();
            System.out.println("Motorizado actualizado: " + ObjMotorizado.toString());

        } catch (SQLException e) {
            System.out.println("Error al actualizar motorizado: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int motorizadoId) throws Exception {
        String sql = "DELETE FROM motorizados WHERE id_motorizado = ?";

        try (PreparedStatement stmt = getConexion().prepareStatement(sql)) {
            stmt.setInt(1, motorizadoId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al eliminar motorizado: " + e.getMessage());
        }
    }

    @Override
    public List<Motorizado> listar(String busqueda) throws Exception {
        List<Motorizado> lista = new ArrayList<>();
        String sql = busqueda.isEmpty()
                ? "SELECT * FROM motorizados"
                : "SELECT * FROM motorizados WHERE nombre LIKE ? OR dni LIKE ? OR telefono LIKE ?";

        try (PreparedStatement stmt = getConexion().prepareStatement(sql)) {
            if (!busqueda.isEmpty()) {
                String filtro = "%" + busqueda + "%";
                stmt.setString(1, filtro);
                stmt.setString(2, filtro);
                stmt.setString(3, filtro);
            }

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Motorizado m = new Motorizado();
                m.setIdMotorizado(rs.getInt("id_motorizado"));
                m.setNombre(rs.getString("nombres"));
                m.setDni(rs.getString("dni"));
                m.setTelefono(rs.getString("telefono"));
                m.setActivo(rs.getBoolean("activo"));
                lista.add(m);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener motorizados: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public Motorizado getMotorizadoById(int motorizadoId) throws Exception {
        Motorizado ObjMotorizado = new Motorizado();
        String sql = "SELECT * FROM motorizados WHERE id_motorizado  = ? LIMIT 1";

        try (PreparedStatement stmt = getConexion().prepareStatement(sql)) {
            stmt.setInt(1, motorizadoId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ObjMotorizado.setIdMotorizado(rs.getInt("id_motorizado"));
                ObjMotorizado.setNombre(rs.getString("nombres"));
                ObjMotorizado.setDni(rs.getString("dni"));
                ObjMotorizado.setTelefono(rs.getString("telefono"));
                ObjMotorizado.setActivo(rs.getBoolean("activo"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener motorizados: " + e.getMessage());
        }
        return ObjMotorizado;
    }

    @Override
    public boolean tieneComandas(int idMotorizado) throws Exception {
        String sql = "SELECT COUNT(*) FROM comandas WHERE id_motorizado = ?";

        try (PreparedStatement stmt = getConexion().prepareStatement(sql)) {
            stmt.setInt(1, idMotorizado);
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
