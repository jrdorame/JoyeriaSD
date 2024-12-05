
package DAO;

import Interface.IPrestamoRepositorio;
import Negocio.DTOs.PrestamoDTO;
import Negocio.DTOs.VendedorDTO;
import Repositorio.RepositorioBase;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Dórame
 */
public class Prestamo extends RepositorioBase <PrestamoDTO> implements IPrestamoRepositorio{
      public Prestamo (EntityManager em){
        super(em);
    }
    /**
     * 
     * @param em
     * @param v
     * @return 
     */
      @Override
      public List <Object[]> buscarPrestamosPendientes(EntityManager em, VendedorDTO v){
          String jsql = "SELECT IF(COUNT(*) > 0, (SELECT folio FROM prestamo WHERE idVendedor = ?), NULL);";
          Query query = em.createNativeQuery(jsql);
          query.setParameter(1, v.getIdVendedor());
          List <Object[]> result = query.getResultList();
           return result;
          
      }
      /**
       * 
       * @return 
       */
      @Override
      public Date calcularFechaLiquidacion(){
          
       LocalDate fechaActual = LocalDate.now();
       LocalDate nuevaFecha = fechaActual.plusDays(15);
       Date date = Date.from(nuevaFecha.atStartOfDay(ZoneId.systemDefault()).toInstant());

        return date;
      } 
       /**
        * 
        * @param total
        * @param v
        * @return 
        */ 
      @Override
        public float calcularComision(float total, VendedorDTO v){
            float comision = 0;
            if(total >= 301 && total <= 999){
            comision = (35.0f /100)* total;
          } 
            if(total >=1000 && total <= 1999){
            comision = (40.0f /100)* total;
            }
            if(total >= 2000 && total <= 2999){
               comision =(45.0f /100)* total;
            }
            if(total >= 3000){
               comision =(50.0f /100)* total;
            }
            
            return comision;
        }
       /**
      * Genera un folio de venta segun la fecha y un numero aleatorio de 4 cirfas
      * @return 
      */
      @Override
    public String generarFolio(){
        LocalDate fecha = LocalDate.now();
        int year = fecha.getYear();
        int month = fecha.getMonthValue();
        int dia = fecha.getDayOfMonth();
        
        Random r = new Random();
        int numero = 1000 + r.nextInt(9000);
        String folio = year +""+ month+"" + dia +""+ numero;
        return folio;
    }
        
}
