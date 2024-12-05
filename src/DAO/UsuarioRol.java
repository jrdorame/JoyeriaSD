
package DAO;

import Interface.IUsuarioRol;
import Negocio.DTOs.UsuarioRolDTO;
import Repositorio.RepositorioBase;
import javax.persistence.EntityManager;

/**
 *
 * @author Dórame
 */
public class UsuarioRol extends RepositorioBase <UsuarioRolDTO> implements IUsuarioRol{
        public UsuarioRol (EntityManager em){
        super(em);
    }
        
}
