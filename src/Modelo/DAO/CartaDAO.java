/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.DTO.CartaDTO;
import conexiones.Conexion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class CartaDAO {
    
   private static final String SQL_READ="SELECT * FROM carta WHERE id_carta= ? ";
   private static final String SQL_INSERT = "INSERT INTO carta"
           +"(id_carta, categoria, tipo_comida, vigencia) VALUES(?, ?, ?, ?)";
   private static final String SQL_UPDATE="UPDATE car SET categoria = ?,tipo_comida= ?, vigencia = ?,  WHERE id_carta = ? ";
   private static final String SQL_READALL= "SELECT * FROM carta";
   private static final String SQL_INNER = "SELECT * from carta a inner join plato b on a.id_carta = b.id_plato"; 
   
   
   
  private static final Conexion con= Conexion.getInstance();
  
   public boolean create(CartaDTO c){
       try {
           PreparedStatement ps;
           ps= con.getCnn().prepareStatement(SQL_INSERT);
           ps.setInt(1, c.getId_carta());
           ps.setString(2, c.getCartegoria());
           ps.setString(3, c.getTipo_comida());
           ps.setDate(4, (Date) c.getVigencia());
          
           
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
    public boolean update(CartaDTO item){
     PreparedStatement ps;
     try {
           ps=con.getCnn().prepareStatement(SQL_UPDATE);
           ps.setString(1, item.getCartegoria());
           ps.setString(2, item.getTipo_comida());
           ps.setDate(3, (Date) item.getVigencia());
           ps.setInt(4, item.getId_carta());
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
   
     public List<CartaDTO> readAll(){
       
     List<CartaDTO> lst= null;
     PreparedStatement psnt;
     try {
           psnt=con.getCnn().prepareStatement(SQL_READALL);
           ResultSet rs= psnt.executeQuery();
           lst= new ArrayList<>();
           while( rs.next()){
               CartaDTO obj; 
               obj = new CartaDTO(rs.getInt("id_carta"), 
                       rs.getString("categoria"),
                       rs.getString("tipo_comida"),
                       rs.getDate("vigencia"));
            
            lst.add(obj);
                
           }
       } catch (SQLException ex) {
           Logger.getLogger(CartaDAO.class.getName()).log(Level.SEVERE, null, ex);
       } finally{
           con.CerrarConexion();
       }
           
     return lst;
     
 }
 
   
      public CartaDTO readCorreo(CartaDTO filter){
      
      CartaDTO objRes=null;
     PreparedStatement psnt;
     

       try {
           psnt=con.getCnn().prepareStatement(SQL_READ);
           psnt.setDouble(1, filter.getId_carta());
           ResultSet rs= psnt.executeQuery();
           while (rs.next()){
                objRes= new CartaDTO(
                rs.getInt("id_carta"),
                rs.getString("categoria"),
                rs.getString("tipo_comida"),
                rs.getDate("vigencia")); 
 
          }
       } catch (SQLException ex) {
           Logger.getLogger(CartaDAO.class.getName()).log(Level.SEVERE, null, ex);
       }finally{
           con.CerrarConexion();
       }
       return objRes;
}
}
