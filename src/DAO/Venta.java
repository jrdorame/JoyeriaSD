
package DAO;

import Interface.IVentaRepositorio;
import Negocio.DTOs.VentasDTO;
import Repositorio.RepositorioBase;
import javax.persistence.EntityManager;

/**
 *
 * @author Dórame
 */
public class Venta extends RepositorioBase <VentasDTO> implements IVentaRepositorio{
    
    public Venta (EntityManager em){
        super(em);
    }
    
}
