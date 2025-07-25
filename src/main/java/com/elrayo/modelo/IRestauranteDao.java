
package com.elrayo.modelo;

import com.elrayo.entidad.Restaurante;
import java.util.List;

public interface IRestauranteDao {
    public void registrar(Restaurante objRestaurante) throws Exception;
    public void modificar(Restaurante objRestaurante) throws Exception;
    public void eliminar(int restauranteId) throws Exception;
    public List<Restaurante> listar(String name) throws Exception;
    public Restaurante getRestauranteById(int restauranteId) throws Exception;
    public boolean tieneComandas(int idRestaurante) throws Exception;
}
