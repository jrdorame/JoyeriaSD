
package Interface;

import Negocio.DTOs.EmpleadoDTO;
import Repositorio.IRepositorioB;
import java.util.List;
import javax.persistence.EntityManager;


/**
 *
 * @author Dórame
 */
public interface IEmpleadoRepositorio extends IRepositorioB<EmpleadoDTO>{
     public List<Object[]> empleadoSinUsuario(EntityManager em);
     public List <Object[]>  empleadoNombres(EntityManager em, int u);
    
}
