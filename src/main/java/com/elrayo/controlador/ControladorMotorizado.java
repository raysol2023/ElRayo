package com.elrayo.controlador;

import com.elrayo.dao.MotorizadoDAO;
import com.elrayo.entidad.Motorizado;
import com.elrayo.modelo.ValidadorMotorizado;
import java.util.List;

public class ControladorMotorizado {

    private MotorizadoDAO dao = new MotorizadoDAO();

    public void registrarMotorizado(Motorizado ObjMotorizado) throws Exception {
        if (ValidadorMotorizado.esDniValido(ObjMotorizado.getDni())
                && ValidadorMotorizado.noVacioNombre(ObjMotorizado.getNombre())
                && ValidadorMotorizado.esTelefonoValido(ObjMotorizado.getTelefono())) {
            dao.registrar(ObjMotorizado);
        }
    }

    public List<Motorizado> mostrarMotorizados(String name) throws Exception {
        return dao.listar(name);
    }

    public boolean editarMotorizado(Motorizado ObjMotorizado) throws Exception {
        if (ValidadorMotorizado.esDniValido(ObjMotorizado.getDni())
                && ValidadorMotorizado.esTelefonoValido(ObjMotorizado.getTelefono())
                && ValidadorMotorizado.noVacioNombre(ObjMotorizado.getNombre())) {
            dao.modificar(ObjMotorizado);
            return true;
        }
        return false;
    }

    public void eliminar(int id_motorizado) throws Exception {
        dao.eliminar(id_motorizado);
    }

    public boolean tieneComandas(int id_motorizado) throws Exception {
        return dao.tieneComandas(id_motorizado);
    }

    public Motorizado editarUnMotorizado(int id_motorizado) throws Exception {
        return dao.getMotorizadoById(id_motorizado);
    }
}
