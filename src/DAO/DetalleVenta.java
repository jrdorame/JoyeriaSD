
package DAO;

import Interface.IDetalleVRepositorio;
import Negocio.DTOs.DetalleVentaDTO;
import Repositorio.RepositorioBase;
import javax.persistence.EntityManager;

/**
 *
 * @author Dórame
 */
public class DetalleVenta extends RepositorioBase <DetalleVentaDTO> implements IDetalleVRepositorio{
    
     public DetalleVenta (EntityManager em){
        super(em);
    }
    
}
