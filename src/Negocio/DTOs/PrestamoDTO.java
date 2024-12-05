
package Negocio.DTOs;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Dórame
 */
@Entity
@Table (name = "Prestamo")
public class PrestamoDTO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPrestamo;
    private int idVendedor;
    private int idUsuario;
    private String folio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaEntrega;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaLiquidacion;
    private float comision;
    private float totalGeneral;
    private char estado;
    
    public PrestamoDTO (){
        
    }
    public PrestamoDTO(int idVen, int idUser, String foli, Date fechaI, Date fechaL, float comi, float total, char e){
        this.idVendedor= idVen; this.idUsuario=idUser; this. folio = foli; this.fechaEntrega = fechaI;
        this.fechaLiquidacion = fechaL; this.comision = comi; this.totalGeneral = total; this.estado = e;
        
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Date getFechaLiquidacion() {
        return fechaLiquidacion;
    }

    public void setFechaLiquidacion(Date fechaLiquidacion) {
        this.fechaLiquidacion = fechaLiquidacion;
    }

    public float getComision() {
        return comision;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }

    public float getTotalGeneral() {
        return totalGeneral;
    }

    public void setTotalGeneral(float totalGeneral) {
        this.totalGeneral = totalGeneral;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
    
            
}
