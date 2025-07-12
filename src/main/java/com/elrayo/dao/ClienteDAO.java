
package com.elrayo.dao;
import com.elrayo.entidad.Cliente;
import java.sql.Connection;
import com.elrayo.util.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class ClienteDAO {
    public void GuardarCliente(Cliente n){
        String sql =" INSERT INTO clientes(nombre, telefono, direccion)VALUES(?,?,?)";
        ConexionDB BD= new ConexionDB();
        try (Connection conn = BD.getConexion();
            PreparedStatement stmt = conn.prepareStatement(sql)){
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
                    
    }
   

