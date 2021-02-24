
package Modelo.DTO;


public class AdminDTO {
    int id_administrador; 
    String nombre_administrador; 

    public AdminDTO(int id_administrador, String nombre_administrador) {
        this.id_administrador = id_administrador;
        this.nombre_administrador = nombre_administrador;
    }

    @Override
    public String toString() {
        return "AdminDTO{" + "id_administrador=" + id_administrador + ", nombre_administrador=" + nombre_administrador + '}';
    }

    public AdminDTO() {
    }

    public int getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(int id_administrador) {
        this.id_administrador = id_administrador;
    }

    public String getNombre_administrador() {
        return nombre_administrador;
    }

    public void setNombre_administrador(String nombre_administrador) {
        this.nombre_administrador = nombre_administrador;
    }
    
    
}
