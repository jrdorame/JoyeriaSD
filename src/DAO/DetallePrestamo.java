
package DAO;

import Negocio.DTOs.DetallePrestamoDTO;
import Repositorio.RepositorioBase;
import javax.persistence.EntityManager;
import Interface.IDetallePrestamoRepositorio;

/**
 *
 * @author Dórame
 */
public class DetallePrestamo extends RepositorioBase<DetallePrestamoDTO> implements IDetallePrestamoRepositorio {
      public DetallePrestamo (EntityManager em){
        super(em);
    }
}
