/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.DTO.EncargadoDTO;
import Modelo.DTO.FacturaDTO;
import conexiones.Conexion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FacturaDAO {
      private static final String SQL_READ="SELECT * FROM factura  WHERE id_factura= ? ";
   private static final String SQL_INSERT = "INSERT INTO factura"
           +"(id_factura, id_cliente, id_plato, fecha) VALUES(?,?,?,?)";
   private static final String SQL_UPDATE="UPDATE factura  SET id_plato=?, id_cliente=?, fecha = ?  WHERE id_factura = ? ";
  
  // private static final String SQL_INNER = "SELECT * from carta a inner join plato b on a.id_carta = b.id_plato"; 
   
   
   
  private static final Conexion con= Conexion.getInstance();
  
  public boolean create(FacturaDTO c){
       try {
           PreparedStatement ps;
           ps= con.getCnn().prepareStatement(SQL_INSERT);
           ps.setInt(1, c.getId_factura());
           ps.setInt(2, c.getId_cliente());
           ps.setInt(3, c.getId_plato()); 
           ps.setDate(4, (Date) c.getFecha()); 
           
        
          
           
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
    public boolean update(FacturaDTO item){
     PreparedStatement ps;
     try {
           ps=con.getCnn().prepareStatement(SQL_UPDATE);
           ps.setInt(1, item.getId_plato());
           ps.setInt(2, item.getId_cliente());
           ps.setDate(3, (Date) item.getFecha());
           ps.setInt(4, item.getId_factura());
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
   

      public FacturaDTO readFactura(FacturaDTO filter){
      
      FacturaDTO objRes=null;
     PreparedStatement psnt;
     

       try {
           psnt=con.getCnn().prepareStatement(SQL_READ);
           psnt.setInt(1, filter.getId_factura());
           ResultSet rs= psnt.executeQuery();
           while (rs.next()){
                objRes= new FacturaDTO(
                rs.getInt("id_factura"),
                rs.getInt("id_cliente"),
                rs.getInt("id_plato"),
                rs.getDate("fecha")); 
   
          }
       } catch (SQLException ex) {
           Logger.getLogger(CartaDAO.class.getName()).log(Level.SEVERE, null, ex);
       }finally{
           con.CerrarConexion();
       }
       return objRes;
}


}
