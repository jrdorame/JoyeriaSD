
package Negocio.DTOs;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Dórame
 */
@Entity
@Table(name="detalleventa")
public class DetalleVentaDTO implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int DetalleVentaId;
    private int ventaId;
    private int  IdProducto;
    private int cantidad;
    private float subtotal;
    
    public DetalleVentaDTO( int venId, int prodId, int cant, float sub){
        this.ventaId = venId; this.IdProducto=prodId; 
        this.cantidad = cant; this.subtotal = sub;
        
    }
    
    public DetalleVentaDTO(){
        
    }

    public int getDetalleVentaId() {
        return DetalleVentaId;
    }

    public void setDetalleVentaId(int DetalleVentaId) {
        this.DetalleVentaId = DetalleVentaId;
    }

    public int getVentaId() {
        return ventaId;
    }

    public void setVentaId(int ventaId) {
        this.ventaId = ventaId;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
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
    
    
 @Override
    public int hashCode() {
        int hash = 3;
        hash += 19 *hash + Objects.hashCode(this.DetalleVentaId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DetalleVentaDTO other = (DetalleVentaDTO) obj;
        if (!Objects.equals(this.DetalleVentaId, other.DetalleVentaId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Negocio.DTOs.DetalleVenta =" + getDetalleVentaId()+ " ";
    }
    
}

