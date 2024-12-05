
package Interface;

import Negocio.DTOs.PrestamoDTO;
import Negocio.DTOs.VendedorDTO;
import Repositorio.IRepositorioB;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Dórame
 */
public interface IPrestamoRepositorio extends IRepositorioB <PrestamoDTO> {
    public List <Object[]> buscarPrestamosPendientes(EntityManager em, VendedorDTO v);
    public Date calcularFechaLiquidacion();
    public float calcularComision(float total, VendedorDTO v);
    public String generarFolio();
}
