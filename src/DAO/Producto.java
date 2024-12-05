
package DAO;

import Interface.IProductoRepositorio;
import Negocio.DTOs.ProductoDTO;
import Repositorio.RepositorioBase;
import javax.persistence.EntityManager;


/**
 *
 * @author Dórame
 */
public class Producto extends RepositorioBase <ProductoDTO> implements IProductoRepositorio{
    
    public Producto (EntityManager em){
        super(em);
    }
     
        
}
