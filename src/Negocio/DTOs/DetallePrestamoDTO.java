
package Negocio.DTOs;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GenerationType;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author Dórame
 */
@Entity
@Table(name="detalleprestamo")
public class DetallePrestamoDTO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int detallePrestamoid;
   private int idPrestamo;
   private int idProducto;
   private int cantidad;
   private float subtotal;
   
   public DetallePrestamoDTO(){
       
   }

   public DetallePrestamoDTO(int idpres, int idprod, int cant, float sub){
       this.idPrestamo = idpres; this.idProducto = idprod;
       this.cantidad = cant; this.subtotal = sub;
       
   }
   
    public int getDetallePrestamo() {
        return detallePrestamoid;
    }

    public void setDetallePrestamo(int detallePrestamo) {
        this.detallePrestamoid = detallePrestamo;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }
   
}
