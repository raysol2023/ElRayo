package com.elrayo.controlador;

import com.elrayo.dao.ComandaDAO;
import com.elrayo.entidad.Comanda;

public class ControladorComanda {

    private ComandaDAO dao = new ComandaDAO();
    
//    public boolean registrarComanda(Comanda c) {
//      
//        c.calcularTarifa();
//
//        
//        if (c.getIdCliente() > 0 && c.getDistanciaKm() > 0) {
//            return dao.guardar(c);
//        }
//
//        return false;
//    }
}