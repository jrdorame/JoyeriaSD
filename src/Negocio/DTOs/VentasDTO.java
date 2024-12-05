
package Negocio.DTOs;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Dórame
 */
@Entity
@Table (name = "Venta")
public class VentasDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ventaid;
    private int usuarioid;
    private String folio;
    @Temporal (TemporalType.DATE)
    private Date fecha_venta;
    private float descuento;
    private String nombre_cliente;
    float total;

    public VentasDTO( int idU, Date fech,String folio, float desc, String nomCliente, float tot){
      
        this.usuarioid= idU;  this.fecha_venta = fech; this.descuento= desc;  this.nombre_cliente = nomCliente;
        this.total = tot;
        
    }

    public int getIduser() {
        return usuarioid;
    }

    public void setIduser(int iduser) {
        this.usuarioid = iduser;
    }
    
    public VentasDTO(){
        
    }
    
    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public Date getFecha() {
        return fecha_venta;
    }

    public void setFecha(Date fecha) {
        this.fecha_venta = fecha;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public String getNombreCliente() {
        return nombre_cliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombre_cliente = nombreCliente;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getId() {
        return ventaid;
    }

    public void setId(int id) {
        this.ventaid = id;
    }

   @Override
    public int hashCode() {
        int hash = 3;
        hash += 19 *hash + Objects.hashCode(this.ventaid);
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
        final VentasDTO other = (VentasDTO) obj;
        if (!Objects.equals(this.ventaid, other.ventaid)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Negocio.DTOs.Venta Folio =" + getFolio()+ " ";
    }
    
}
