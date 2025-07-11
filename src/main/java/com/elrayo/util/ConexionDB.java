package com.elrayo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final String DB = "el_rayo";
    private static final String URL = "jdbc:mysql://localhost:3306/"+DB;
    private static final String USUARIO = "root";
    private static final String CLAVE = "";
    private Connection miConjexion;

    public ConexionDB() {
        try {
            miConjexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("✅ Conexion exitosa a: "+DB);
        } catch (SQLException e) {
            System.out.println("❌ Error de conexión a la base de datos: " + e.getMessage());
        }
    }

    public Connection getConexion() {
        return miConjexion;
    }
}
