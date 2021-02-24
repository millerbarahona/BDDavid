/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DAO.CartaDAO;
import Modelo.DAO.ClienteDAO;
import Modelo.DTO.CartaDTO;
import Modelo.DTO.ClienteDTO;

/**
 *
 * @author user
 */
public class pruebas {
    public static void main(String[] args) {
        
        ClienteDAO ob = new ClienteDAO(); 
        ClienteDTO dto = new ClienteDTO(); 
        
        
        dto.setId_cliente(45060);
        System.out.println(ob.readCliente(dto).toString());
    }
}
