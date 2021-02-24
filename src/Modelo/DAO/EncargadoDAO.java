
package Modelo.DAO;

import Modelo.DTO.CartaDTO;
import Modelo.DTO.ClienteDTO;
import Modelo.DTO.EncargadoDTO;
import conexiones.Conexion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EncargadoDAO {
     private static final String SQL_READ="SELECT * FROM encargado  WHERE id_encargado= ? ";
   private static final String SQL_INSERT = "INSERT INTO encargado"
           +"(id_cliente, nombre) VALUES(?, ?)";
   private static final String SQL_UPDATE="UPDATE encargado SET nombre= ?,  WHERE id_cliente = ? ";
  
  // private static final String SQL_INNER = "SELECT * from carta a inner join plato b on a.id_carta = b.id_plato"; 
   
   
   
  private static final Conexion con= Conexion.getInstance();
  
   public boolean create(EncargadoDTO c){
       try {
           PreparedStatement ps;
           ps= con.getCnn().prepareStatement(SQL_INSERT);
           ps.setInt(1, c.getId_encargado());
           ps.setString(2, c.getNombre());
        
          
           
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
    public boolean update(EncargadoDTO item){
     PreparedStatement ps;
     try {
           ps=con.getCnn().prepareStatement(SQL_UPDATE);
           ps.setString(1, item.getNombre());
           
           ps.setInt(4, item.getId_encargado());
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
   

      public EncargadoDTO readCliente(EncargadoDTO filter){
      
      EncargadoDTO objRes=null;
     PreparedStatement psnt;
     

       try {
           psnt=con.getCnn().prepareStatement(SQL_READ);
           psnt.setInt(1, filter.getId_encargado());
           ResultSet rs= psnt.executeQuery();
           while (rs.next()){
                objRes= new EncargadoDTO(
                rs.getInt("id_encargado"),
                rs.getString("nombre")); 
                
 
          }
       } catch (SQLException ex) {
           Logger.getLogger(CartaDAO.class.getName()).log(Level.SEVERE, null, ex);
       }finally{
           con.CerrarConexion();
       }
       return objRes;
}



}
