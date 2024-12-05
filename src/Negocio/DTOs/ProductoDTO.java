
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
@Table(name="Producto")
public class ProductoDTO implements Serializable {

   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idProducto;
    private String nombre;
    private String codigo;
    private String descripcion;
    private String imagen;
    private float precio;
    private int stock; 
    private char estadop;
    private int idCategoria;
        
    public ProductoDTO (int id, String nom,String cod, String desc, String img, float pre, int stk, char est,int idC){
        this.idProducto = id; this.nombre = nom; this.codigo = cod; this.descripcion = desc; this.imagen = img;
        this.precio = pre; this.stock = stk; this.estadop=est;  this.idCategoria=idC;
        
    }

    public char getEstado() {
        return estadop;
    }

    public void setEstado(char estado) {
        this.estadop = estado;
    }
    
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public ProductoDTO(){
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getIdC() {
        return idCategoria;
    }

    public void setIdC(int idC) {
        this.idCategoria = idC;
    }

    public int getId() {
        return idProducto;
    }

    public void setId(int id) {
        this.idProducto = id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash += 19 *hash + Objects.hashCode(this.idProducto);
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
        final ProductoDTO other = (ProductoDTO) obj;
        if (!Objects.equals(this.idProducto, other.idProducto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Negocio.DTOs.Producto =" + getNombre()+ " ";
    }
    
}
