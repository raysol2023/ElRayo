package com.elrayo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.elrayo.util.ConexionDB;
import com.elrayo.entidad.Restaurante;
import com.elrayo.modelo.IRestauranteDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestauranteDAO extends ConexionDB implements IRestauranteDao {

    @Override
    public void registrar(Restaurante objRestaurante) throws Exception {
        String sql = "INSERT INTO restaurantes (nombre, direccion, ruc, telefono, tiene_convenio) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = getConexion().prepareStatement(sql)) {
            stmt.setString(1, objRestaurante.getNombre());
            stmt.setString(2, objRestaurante.getDireccion());
            stmt.setString(3, objRestaurante.getRuc());
            stmt.setString(4, objRestaurante.getTelefono());
            stmt.setBoolean(5, objRestaurante.isTieneConvenio());

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("Restaurante guardado correctamente en la base de datos.");
            } else {
                System.out.println("No se pudo guardar el restaurante.");
            }

        } catch (SQLException e) {
            System.out.println("Error al guardar restaurante: " + e.getMessage());
            throw e; // vuelve a lanzar la excepción si quieres manejarla desde otro lugar
        }
    }

    @Override
    public void modificar(Restaurante objRestaurante) throws Exception {
        String sql = "UPDATE restaurantes SET nombre = ?, direccion = ?, ruc = ?, telefono = ?, tiene_convenio = ? WHERE id_restaurante = ?";

        try (Connection conn = new ConexionDB().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, objRestaurante.getNombre());
            stmt.setString(2, objRestaurante.getDireccion());
            stmt.setString(3, objRestaurante.getRuc());
            stmt.setString(4, objRestaurante.getTelefono());
            stmt.setBoolean(5, objRestaurante.isTieneConvenio());
            stmt.setInt(6, objRestaurante.getidRestaurante());

            stmt.executeUpdate();
            System.out.println("Restaurante actualizado: " + objRestaurante.toString());

        } catch (SQLException e) {
            System.out.println("Error al actualizar restaurante: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int restauranteId) throws Exception {
        String sql = "DELETE FROM restaurantes WHERE id_restaurante = ?";

        try (PreparedStatement stmt = getConexion().prepareStatement(sql)) {
            stmt.setInt(1, restauranteId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar restaurante: " + e.getMessage());
        }
    }

    @Override
    public List<Restaurante> listar(String busqueda) throws Exception {
        List<Restaurante> lista = new ArrayList<>();

        String sql = busqueda.isEmpty()
                ? "SELECT * FROM restaurantes"
                : "SELECT * FROM restaurantes WHERE nombre LIKE ? OR direccion LIKE ? OR ruc LIKE ? OR telefono LIKE ?";

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
                Restaurante r = new Restaurante();
                r.setidRestaurante(rs.getInt("id_restaurante"));
                r.setNombre(rs.getString("nombre"));
                r.setDireccion(rs.getString("direccion"));
                r.setRuc(rs.getString("ruc"));
                r.setTelefono(rs.getString("telefono"));
                r.setTieneConvenio(rs.getBoolean("tiene_convenio"));
                lista.add(r);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener restaurantes: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public Restaurante getRestauranteById(int restauranteId) throws Exception {
        Restaurante objRestaurante = new Restaurante();
        String sql = "SELECT * FROM restaurantes WHERE id_restaurante  = ? LIMIT 1";

        try (PreparedStatement stmt = getConexion().prepareStatement(sql)) {
            stmt.setInt(1, restauranteId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                objRestaurante.setidRestaurante(rs.getInt("id_restaurante"));
                objRestaurante.setNombre(rs.getString("nombre"));
                objRestaurante.setDireccion(rs.getString("direccion"));
                objRestaurante.setRuc(rs.getString("ruc"));
                objRestaurante.setTelefono(rs.getString("telefono"));
                objRestaurante.setTieneConvenio(rs.getBoolean("tiene_convenio"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener restaurantes: " + e.getMessage());
        }
        return objRestaurante;
    }

    @Override
    public boolean tieneComandas(int idRestaurante) throws Exception {
        String sql = "SELECT COUNT(*) FROM comandas WHERE id_restaurante = ?";
        
        try (PreparedStatement stmt = getConexion().prepareStatement(sql)) {
            stmt.setInt(1, idRestaurante);
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
