
package DAO;

import Interface.IRol;
import Negocio.DTOs.RolDTO;
import Repositorio.RepositorioBase;
import javax.persistence.EntityManager;

/**
 *
 * @author Dórame
 */
public class Rol  extends RepositorioBase <RolDTO> implements IRol{
      public Rol (EntityManager em){
        super(em);
    }
}
