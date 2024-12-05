
package Negocio.DTOs;

import java.io.Serializable;
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
@Table (name = "rol")
public class RolDTO  implements Serializable{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)  
   private int rolid ;
   private String nombrerol;
   
   public RolDTO(){
       
   }

    public int getIdRol() {
        return rolid;
    }

    public void setIdRol(int idRol) {
        this.rolid = idRol;
    }

    public String getRolNombre() {
        return nombrerol;
    }

    public void setRolNombre(String rolNombre) {
        this.nombrerol = rolNombre;
    }
   
}
