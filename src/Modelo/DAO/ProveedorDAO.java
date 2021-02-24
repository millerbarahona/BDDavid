
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
import Modelo.DTO.ProveedorDTO;


public class ProveedorDAO {
    
     private static final String SQL_INSERT = "INSERT INTO proveedor"
            + "(id_proveedor, nombre )VALUES(?,?)";
    private static final String SQL_DELETE = "DELETE FROM plato WHERE id_proveedor= ?";
    private static final String SQL_UPDATE = "UPDATE proveedor SET  nombre = ?  WHERE id_proveedor = ?";
    private static final String SQL_READ = "SELECT *FROM proveedor WHERE id_proveedor = ?";
    private static final String SQL_READALL = "SELECT *FROM proveedor"; 
    
    
    
    private static final Conexion con = Conexion.getInstance ();
    
    public boolean create(ProveedorDTO c) {
        try {
            PreparedStatement ps;
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, c.getId_proveedor());
            ps.setString(2, c.getNombre());
            
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.CerrarConexion();
        }
        return false;
    }
    
     public List<ProveedorDTO> readAll() {
        List<ProveedorDTO> lst = null;
        PreparedStatement psnt;
        try {
            psnt = con.getCnn().prepareStatement(SQL_READALL);
            ResultSet rs = psnt.executeQuery();
            lst = new ArrayList<>();
            while (rs.next()) {
                ProveedorDTO obj = new ProveedorDTO(
   
                        rs.getInt("id_proveedor"),
                        rs.getString("nombre")
    
                );
                lst.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.CerrarConexion();
        }
        return lst;
    }
     public boolean delete(ProveedorDTO item) {

        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_DELETE);
            ps.setInt(1, item.getId_proveedor());
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
     
    public boolean update(ProveedorDTO item) {

        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
             ps.setInt(1, item.getId_proveedor());
            ps.setString(2, item.getNombre());         
           
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

   public ProveedorDTO read(ProveedorDTO filter) {
        ProveedorDTO objRes = null;
        PreparedStatement psnt;
        try {
            psnt = con.getCnn().prepareStatement(SQL_READ);
            psnt.setFloat(1, filter.getId_proveedor());
            ResultSet rs = psnt.executeQuery();
            while (rs.next()) {
                objRes = new ProveedorDTO(
                       rs.getInt("id_proveedor"),
                        rs.getString("nombre")
                        
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.CerrarConexion();
        }
        return objRes;
        
}
}