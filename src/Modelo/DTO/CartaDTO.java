
package Modelo.DTO;
import java.util.Date;


public class CartaDTO {
    int id_carta ; 
    String cartegoria; 
    String tipo_comida; 
    Date vigencia; 
    int id_plato; 

    public CartaDTO(int id_carta) {
        this.id_carta = id_carta;
    }
    

    public CartaDTO() {
    }

    public CartaDTO(int id_carta, String cartegoria, String tipo_comida, Date vigencia, int id_plato) {
        this.id_carta = id_carta;
        this.cartegoria = cartegoria;
        this.tipo_comida = tipo_comida;
        this.vigencia = vigencia;
        this.id_plato = id_plato;
    }

    public CartaDTO(int id_carta, String cartegoria, String tipo_comida, Date vigencia) {
        this.id_carta = id_carta;
        this.cartegoria = cartegoria;
        this.tipo_comida = tipo_comida;
        this.vigencia = vigencia;
    }

    
    public int getId_carta() {
        return id_carta;
    }

    @Override
    public String toString() {
        return "CartaDTO{" + "id_carta=" + id_carta + ", cartegoria=" + cartegoria + ", tipo_comida=" + tipo_comida + ", vigencia=" + vigencia + ", id_plato=" + id_plato + '}';
    }

    public void setId_carta(int id_carta) {
        this.id_carta = id_carta;
    }

    public String getCartegoria() {
        return cartegoria;
    }

    public void setCartegoria(String cartegoria) {
        this.cartegoria = cartegoria;
    }

    public String getTipo_comida() {
        return tipo_comida;
    }

    public void setTipo_comida(String tipo_comida) {
        this.tipo_comida = tipo_comida;
    }

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }

    public int  getId_plato() {
        return id_plato;
    }

    public void setId_plato(int id_plato) {
        this.id_plato = id_plato;
    }

   
    
}
