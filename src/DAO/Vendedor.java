
package DAO;

import Interface.IVendedorRepositorio;
import Negocio.DTOs.VendedorDTO;
import Repositorio.RepositorioBase;
import javax.persistence.EntityManager;

/**
 *
 * @author Dórame
 */
public class Vendedor extends RepositorioBase <VendedorDTO> implements IVendedorRepositorio{
      public Vendedor (EntityManager em){
        super(em);
    }
    
}
