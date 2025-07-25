package com.elrayo.controlador;

import com.elrayo.dao.RestauranteDAO;
import com.elrayo.entidad.Restaurante;
import com.elrayo.modelo.ValidadorRestaurante;
import java.util.List;

public class ControladorRestaurante {

    private RestauranteDAO dao = new RestauranteDAO();

    public void registrarRestaurante(Restaurante objRestaurante) throws Exception {
        if (ValidadorRestaurante.noVacioNombre(objRestaurante.getNombre())
                && ValidadorRestaurante.esRUCValido(objRestaurante.getRuc())
                && ValidadorRestaurante.noVacioDireccion(objRestaurante.getDireccion())
                && ValidadorRestaurante.esTelefonoValido(objRestaurante.getTelefono())) {
            dao.registrar(objRestaurante);
        }
    }

    public List<Restaurante> mostrarRestaurantes(String name) throws Exception {
        return dao.listar(name);
    }

    public boolean editarRestaurante(Restaurante objRestaurante) throws Exception {
        if (ValidadorRestaurante.noVacioNombre(objRestaurante.getNombre())
                && ValidadorRestaurante.esRUCValido(objRestaurante.getRuc())
                && ValidadorRestaurante.noVacioDireccion(objRestaurante.getDireccion())
                && ValidadorRestaurante.esTelefonoValido(objRestaurante.getTelefono())) {
            dao.modificar(objRestaurante);
            return true;
        }
        return false;
    }

    public void eliminar(int idRestaurante) throws Exception {
        dao.eliminar(idRestaurante);
    }

    public boolean tieneComandas(int idRestaurante) throws Exception {
        return dao.tieneComandas(idRestaurante);
    }

    public Restaurante editarUnRestaurante(int idRestaurante) throws Exception {
        return dao.getRestauranteById(idRestaurante);
    }
}
