
package Modelo.DTO;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Objects;

public class ProveedorDTO {
    
    private int id_proveedor ;
    private String nombre ; 
   

    public ProveedorDTO(int id_proveedor, String nombre) {
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
       
    }

    public ProveedorDTO(String nombre) {
        this.nombre = nombre;
      
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

  
    
    @Override
    public String toString (){
        return " id proveedor :" + id_proveedor + "\nnombre : " + nombre  ;
    }
    
    @Override
    public boolean equals(Object obj ){
         if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
         final ProveedorDTO other = (ProveedorDTO) obj;
        if (this.id_proveedor != other.id_proveedor) {
            return false;
        }
         if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
       
        
        return true ;
        
    }
    
}
