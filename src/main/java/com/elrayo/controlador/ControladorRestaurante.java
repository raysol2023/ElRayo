
package com.elrayo.controlador;

import com.elrayo.dao.RestauranteDAO;
import com.elrayo.entidad.Restaurante;
import com.elrayo.modelo.ValidadorRestaurante;


public class ControladorRestaurante {
     private RestauranteDAO dao = new RestauranteDAO();

    public boolean registrarRestaurante(Restaurante r) {
        if (
            ValidadorRestaurante.noVacioNombre(r.getNombre()) &&
            ValidadorRestaurante.noVacioDireccion(r.getDireccion()) &&
            ValidadorRestaurante.esTelefonoValido(r.getTelefono())
        ) {
            dao.guardar(r);
            return true;
        }
        return false;
    }
}
