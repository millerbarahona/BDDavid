/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DTO;

import java.util.Date;

public class FacturaDTO {
  
    int id_factura; 
    int id_cliente; 
    int id_plato; 

    Date fecha; 

    public FacturaDTO() {
    }

    @Override
    public String toString() {
        return "FacturaDTO{" + "id_factura=" + id_factura + ", id_cliente=" + id_cliente + ", id_plato=" + id_plato  + ", fecha=" + fecha + '}';
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_plato() {
        return id_plato;
    }

    public void setId_plato(int id_plato) {
        this.id_plato = id_plato;
    }

 
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public FacturaDTO(int id_factura, int id_cliente, int id_plato, Date fecha) {
        this.id_factura = id_factura;
        this.id_cliente = id_cliente;
        this.id_plato = id_plato;
        
        this.fecha = fecha;
    }
    
    
    
    
}
