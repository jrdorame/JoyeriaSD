
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
@Table (name = "usuariorol")
public class UsuarioRolDTO implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int usuarioRolId;
    private int usuarioId;
    private int rolId;
    
    public UsuarioRolDTO(int usuario, int rol){
        this.usuarioId = usuario;
        this.rolId = rol;
        
    }
    public UsuarioRolDTO (){
        
    }

    public int getUsuarioRolId() {
        return usuarioRolId;
    }

    public void setUsuarioRolId(int usuarioRolId) {
        this.usuarioRolId = usuarioRolId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }
    
}
