
package Modelo.DAO;

import Modelo.DTO.CartaDTO;
import Modelo.DTO.ClienteDTO;
import conexiones.Conexion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClienteDAO {
   private static final String SQL_READ="SELECT * FROM cliente WHERE id_cliente= ? ";
   private static final String SQL_INSERT = "INSERT INTO cliente"
           +"(id_cliente, nombre) VALUES(?, ?)";
   private static final String SQL_UPDATE="UPDATE cliente SET nombre = ?,  WHERE id_cliente = ? ";
  
  // private static final String SQL_INNER = "SELECT * from carta a inner join plato b on a.id_carta = b.id_plato"; 
   
   
   
  private static final Conexion con= Conexion.getInstance();
  
   public boolean create(ClienteDTO c){
       try {
           PreparedStatement ps;
           ps= con.getCnn().prepareStatement(SQL_INSERT);
           ps.setInt(1, c.getId_cliente());
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
    public boolean update(ClienteDTO item){
     PreparedStatement ps;
     try {
           ps=con.getCnn().prepareStatement(SQL_UPDATE);
           ps.setString(1, item.getNombre());
          
           ps.setInt(4, item.getId_cliente());
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
   

      public ClienteDTO readCliente(ClienteDTO filter){
      
      ClienteDTO objRes=null;
     PreparedStatement psnt;
     

       try {
           psnt=con.getCnn().prepareStatement(SQL_READ);
           psnt.setInt(1, filter.getId_cliente());
           ResultSet rs= psnt.executeQuery();
           while (rs.next()){
                objRes= new ClienteDTO(
                rs.getInt("id_cliente"),
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

