
package Modelo.DAO;

import conexiones.Conexion;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelo.DTO.loginDTO;

public class loginDAO {
    
     private static final String SQL_INSERT = "INSERT INTO login"
            + "(id_administrador, correo , clave )VALUES(?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM login WHERE id_administrador= ?";
    private static final String SQL_UPDATE = "UPDATE login SET  correo = ? , clave = ?  WHERE id_administrador = ?";
    private static final String SQL_READ = "SELECT *FROM login WHERE id_administrador = ?";
    private static final String SQL_READALL = "SELECT *FROM login"; 
    private static final String SQL_LOGIN = "SELECT * FROM login where correo =? and clave=?"; 
    
    
    private static final Conexion con = Conexion.getInstance ();
    
    public boolean create(loginDTO c) {
        try {
            PreparedStatement ps;
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, c.getId_administrador());
            ps.setString(2, c.getCorreo());
            ps.setString (3, c.getClave());
            
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(loginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.CerrarConexion();
        }
        return false;
    }
    
     public List<loginDTO> readAll() {
        List<loginDTO> lst = null;
        PreparedStatement psnt;
        try {
            psnt = con.getCnn().prepareStatement(SQL_READALL);
            ResultSet rs = psnt.executeQuery();
            lst = new ArrayList<>();
            while (rs.next()) {
                loginDTO obj = new loginDTO(
   
                        rs.getInt("id_administrador"),
                        rs.getString("correo"),
                        rs.getString("clave")
    
                );
                lst.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(loginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.CerrarConexion();
        }
        return lst;
    }
     public boolean delete(loginDTO item) {

        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_DELETE);
            ps.setInt(1, item.getId_administrador());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            throw new Error(ex.getMessage());
        } finally {
            con.CerrarConexion();
        }
        return false;
    }
     
    public boolean update(loginDTO item) {

        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
             ps.setInt(1, item.getId_administrador());
            ps.setString(2, item.getCorreo());
            ps.setString(3, item.getClave());
            
        
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            throw new Error(ex.getMessage());
        } finally {
            con.CerrarConexion();
        }
        return false;
    }  

   public loginDTO read(loginDTO filter) {
        loginDTO objRes = null;
        PreparedStatement psnt;
        try {
            psnt = con.getCnn().prepareStatement(SQL_READ);
            psnt.setInt(1, filter.getId_administrador());
            ResultSet rs = psnt.executeQuery();
            while (rs.next()) {
                objRes = new loginDTO(
                       rs.getInt("id_administrador"),
                        rs.getString("correo"),
                        rs.getString("clave")
                        
                        
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(loginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.CerrarConexion();
        }
        return objRes;
        
}
    
   public loginDTO validarLogin(loginDTO filter) {
        loginDTO objRes = null;
        PreparedStatement psnt;
        try {
            psnt = con.getCnn().prepareStatement(SQL_LOGIN);
            psnt.setString(1, filter.getCorreo());
            psnt.setString(2, filter.getClave());
            ResultSet rs = psnt.executeQuery();
            while (rs.next()) {
                objRes = new loginDTO(
                       rs.getInt("id_administrador"),
                        rs.getString("correo"),
                        rs.getString("clave")
                        
                        
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(loginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.CerrarConexion();
        }
        return objRes;
        
}
}
