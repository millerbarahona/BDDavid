
package Modelo.DTO;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Objects;

public class RegionDTO implements Serializable {
     
    private int codigo ;
    private String nombre_region ;

    public RegionDTO(int codigo, String nombre_region) {
        this.codigo = codigo;
        this.nombre_region = nombre_region;
    }

    

    public RegionDTO(String nombre_region) {
        this.nombre_region = nombre_region;
    }
    
    public RegionDTO ()
    {
        
    }   

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre_region() {
        return nombre_region;
    }

    public void setNombre_region(String nombre_region) {
        this.nombre_region = nombre_region;
    }

   
    
    
    @Override
    public String toString (){
        return "codigo : " + codigo + "\nnombre region : " + nombre_region ;
        
    }
    
    public boolean equals (Object obj ){
       if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        } 
         final RegionDTO other = (RegionDTO) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
         if (!Objects.equals(this.nombre_region, other.nombre_region)) {
            return false;
        }
        
        return true ; 
        
    }
    
    
    
    
    
    
    
}
