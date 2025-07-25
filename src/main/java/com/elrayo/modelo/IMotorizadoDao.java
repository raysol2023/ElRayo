
package com.elrayo.modelo;
import com.elrayo.entidad.Motorizado;
import java.util.List;

public interface IMotorizadoDao {
    public void registrar(Motorizado ObjMotorizado) throws Exception;
    public void modificar(Motorizado ObjMotorizado) throws Exception;
    public void eliminar(int motorizadoId) throws Exception;
    public List<Motorizado> listar(String name) throws Exception;
    public Motorizado getMotorizadoById(int motorizadoId) throws Exception;
    public boolean tieneComandas(int idMotorizado) throws Exception;
}
