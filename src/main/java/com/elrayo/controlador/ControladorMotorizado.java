package com.elrayo.controlador;

import com.elrayo.dao.MotorizadoDAO;
import com.elrayo.entidad.Motorizado;
import com.elrayo.modelo.ValidadorMotorizado;
import java.util.List;

public class ControladorMotorizado {
    private MotorizadoDAO dao = new MotorizadoDAO();

    public boolean registrarMotorizado(Motorizado m) {
        if (ValidadorMotorizado.esDniValido(m.getDni()) &&
            ValidadorMotorizado.esTelefonoValido(m.getTelefono())) {
            dao.guardar(m);
            return true;
        }
        return false;
    }
    
    public List<Motorizado> mostrarMotorizados(){
        return dao.obtenerTodos();
    }
    
    
}