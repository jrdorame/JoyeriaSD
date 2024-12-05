
package Negocio.DTOs;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "Empleado")
public class EmpleadoDTO  implements Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int empleadoid;
  
  private String nombres;
  private String apellidos;
  private String direccion;
  private String telefono;
  @Temporal (TemporalType.DATE)
  private Date  fechanacimiento;
  @Temporal (TemporalType.DATE)
  private Date  fechaIngreso;
  
  public EmpleadoDTO (){
      
  }
  public EmpleadoDTO (String n, String a, String d, String t, Date nacim, Date ingreso){
      this.nombres = n; this.apellidos = a; this.direccion = d;
      this.telefono = t; this.fechanacimiento = nacim;
      this.fechaIngreso = ingreso;
  }

    public int getIdEmpledo() {
        return empleadoid;
    }

    public void setIdEmpledo(int idEmpledo) {
        this.empleadoid = idEmpledo;
    }

    public String getNombre() {
        return nombres;
    }

    public void setNombre(String nombre) {
        this.nombres = nombre;
    }

    public String getApellido() {
        return apellidos;
    }

    public void setApellido(String apellido) {
        this.apellidos = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTeelefono() {
        return telefono;
    }

    public void setTeelefono(String teelefono) {
        this.telefono = teelefono;
    }

    public Date getFechaacimiento() {
        return fechanacimiento;
    }

    public void setFechaacimiento(Date fechaacimiento) {
        this.fechanacimiento = fechaacimiento;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
  
  
}
