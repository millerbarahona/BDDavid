/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DTO;

/**
 *
 * @author user
 */
public class ClienteDTO {
    int id_cliente; 
    String nombre; 

    public ClienteDTO(int id_cliente, String nombre) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "ClienteDTO{" + "id_cliente=" + id_cliente + ", nombre=" + nombre + '}';
    }

    public ClienteDTO() {
        
    }

    
    
    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public ClienteDTO(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
   
}
