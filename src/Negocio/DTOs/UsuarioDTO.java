
package Negocio.DTOs;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
@Table(name = "Usuario")
public class UsuarioDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int UsuarioID;
    private int EmpleadoID;
    private String usuario;
    private String Contrasena;
    
    public UsuarioDTO (int id, String u, String c){
        this.EmpleadoID = id; this.usuario = u; this.Contrasena = hashearContrasena(c);
        
    }

    public int getEmpleadoID(){
        return EmpleadoID;
    }
    public UsuarioDTO(){
        
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String nombre) {
        this.usuario = nombre;
    }

    public String getClave() {
        return Contrasena;
    }

    public void setClave(String clave) {
        this.Contrasena = clave;
    }
    
    public int getId() {
        return UsuarioID;
    }

    public void setId(int id) {
        this.UsuarioID = id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash += 19 *hash + Objects.hashCode(this.UsuarioID);
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
        final UsuarioDTO other = (UsuarioDTO) obj;
        if (!Objects.equals(this.UsuarioID, other.UsuarioID)) {
            return false;
        }
        return true;
    }
        // Método para hashear la contraseña
    private String hashearContrasena(String contrasena) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(contrasena.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Negocio.DTOs.Usuario id=" + getId()+ " ";
    }
    
}
