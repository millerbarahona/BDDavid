
package Modelo.DTO;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Objects;

public class loginDTO {
    
    private int id_administrador ;
    private String correo ;
    private String clave ;

    public loginDTO(int id_administrador, String correo, String clave) {
        this.id_administrador = id_administrador;
        this.correo = correo;
        this.clave = clave;
    }

    public loginDTO(String correo, String clave) {
        this.correo = correo;
        this.clave = clave;
    }

    public loginDTO() {
      
    }
    
   

    public int getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(int id_administrador) {
        this.id_administrador = id_administrador;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    @Override
    public String toString (){
        return "id_administrador ;" + id_administrador + "correo : " + correo + "clave :" + clave ;
    }
    
    @Override
    public boolean equals (Object obj)
    {
      if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final loginDTO other = (loginDTO) obj;
        if (this.id_administrador != other.id_administrador) {
            return false;
        }
         if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        
         if (this.clave != other.clave) {
            return false;
        }
       
        
        
     return true ;   
    }
    
    
}
