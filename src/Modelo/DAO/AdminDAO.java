/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.DAO.CartaDAO;
import Modelo.DTO.AdminDTO;
import Modelo.DTO.CartaDTO;
import Modelo.DTO.ClienteDTO;
import conexiones.Conexion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class AdminDAO {
   private static final String SQL_READ="SELECT * FROM administrador WHERE id_administrador= ? ";
   private static final String SQL_INSERT = "INSERT INTO administrador"
           +"(id_administrador, nombre_administrador) VALUES(?, ?)";
   private static final String SQL_UPDATE="UPDATE administrador SET nombre_administrador = ?,  WHERE id_administrador= ? ";
  
  // private static final String SQL_INNER = "SELECT * from carta a inner join plato b on a.id_carta = b.id_plato"; 
   
   
   
  private static final Conexion con= Conexion.getInstance();
  
   public boolean create(AdminDTO c){
       try {
           PreparedStatement ps;
           ps= con.getCnn().prepareStatement(SQL_INSERT);
           ps.setInt(1, c.getId_administrador());
           ps.setString(2, c.getNombre_administrador());
        
          
           
            if(ps.executeUpdate() >0){
                return true;
                
            }
       } catch (SQLException ex) {
           Logger.getLogger(CartaDAO.class.getName()).log(Level.SEVERE, null, ex);
       } finally {
           con.CerrarConexion();
       }
       return false;
    }
    public boolean update(AdminDTO item){
     PreparedStatement ps;
     try {
           ps=con.getCnn().prepareStatement(SQL_UPDATE);
           ps.setString(1, item.getNombre_administrador());
          
           ps.setInt(2, item.getId_administrador());
           if(ps.executeUpdate()>0){
               return true;
           }
       } catch (SQLException ex) {
           System.out.println("ERROR AL ACTUALIZAR"+ ex.getMessage());
       }finally{
         con.CerrarConexion();
     }
     return false;
     
 }
   

      public AdminDTO readCliente(AdminDTO filter){
      
      AdminDTO objRes=null;
     PreparedStatement psnt;
     

       try {
           psnt=con.getCnn().prepareStatement(SQL_READ);
           psnt.setInt(1, filter.getId_administrador());
           ResultSet rs= psnt.executeQuery();
           while (rs.next()){
                objRes= new AdminDTO(
                rs.getInt("id_administrador"),
                rs.getString("nombre_administrador")); 
                
 
          }
       } catch (SQLException ex) {
           Logger.getLogger(CartaDAO.class.getName()).log(Level.SEVERE, null, ex);
       }finally{
           con.CerrarConexion();
       }
       return objRes;
}
}
