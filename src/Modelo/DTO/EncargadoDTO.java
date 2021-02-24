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
public class EncargadoDTO {
    int id_encargado; 
    String  nombre; 

    public EncargadoDTO(int id_encargado, String nombre) {
        this.id_encargado = id_encargado;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "EncargadoDTO{" + "id_encargado=" + id_encargado + ", nombre=" + nombre + '}';
    }

    public int getId_encargado() {
        return id_encargado;
    }

    public void setId_encargado(int id_encargado) {
        this.id_encargado = id_encargado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
