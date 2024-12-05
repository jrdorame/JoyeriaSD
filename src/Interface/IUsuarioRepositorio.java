
package Interface;

import Negocio.DTOs.UsuarioDTO;
import Repositorio.IRepositorioB;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Dórame
 */
public interface IUsuarioRepositorio  extends IRepositorioB <UsuarioDTO>{
    public List <Object>  getUltimoUsuario(EntityManager em);
    public List <Object>  getUsuario(EntityManager em,String usuario);
    public List <Object[]> obtenerU(EntityManager em, int u);

}
