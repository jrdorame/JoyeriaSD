
package Negocio.DTOs;

import java.io.Serializable;
import java.util.Date;
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
@Table(name ="Vendedor")
public class VendedorDTO implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idVendedor;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private String direccion;
    private String colonia;
    private String telefono;
    private String numeroSeguroSocial;
    private float limitePrestamo;
    private String empleo;
    private float comision;
    private Date fechaIngreso;
    private String estadoCivil;
    private String nombreConyuge;
    private String apellidosConyuge;
    
    public VendedorDTO (){
        
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNumeroSeguroSocial() {
        return numeroSeguroSocial;
    }

    public void setNumeroSeguroSocial(String numeroSeguroSocial) {
        this.numeroSeguroSocial = numeroSeguroSocial;
    }

    public float getLimitePrestamo() {
        return limitePrestamo;
    }

    public void setLimitePrestamo(float limitePrestamo) {
        this.limitePrestamo = limitePrestamo;
    }

    public String getEmpleo() {
        return empleo;
    }

    public void setEmpleo(String empleo) {
        this.empleo = empleo;
    }

    public float getComision() {
        return comision;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }

    public Date getDechaIngreso() {
        return fechaIngreso;
    }

    public void setDechaIngreso(Date dechaIngreso) {
        this.fechaIngreso = dechaIngreso;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNombreConyuge() {
        return nombreConyuge;
    }

    public void setNombreConyuge(String nombreConyuge) {
        this.nombreConyuge = nombreConyuge;
    }

    public String getApellidosConyuge() {
        return apellidosConyuge;
    }

    public void setApellidosConyuge(String apellidosConyuge) {
        this.apellidosConyuge = apellidosConyuge;
    }
    
    
}
