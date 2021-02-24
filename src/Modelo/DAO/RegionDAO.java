
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
import Modelo.DTO.RegionDTO;


public class RegionDAO {
    
    
     private static final String SQL_INSERT = "INSERT INTO region"
            + "(codigo , nombre_region )VALUES(?,?)";
    private static final String SQL_DELETE = "DELETE FROM region WHERE codigo= ?";
    private static final String SQL_UPDATE = "UPDATE region SET nombre_region = ?  WHERE codigo = ?";
    private static final String SQL_READ = "SELECT *FROM region WHERE codigo = ?";
    private static final String SQL_READALL = "SELECT *FROM region"; 
    
    private static final Conexion con = Conexion.getInstance ();
    
    public boolean create(RegionDTO c) {
        try {
            PreparedStatement ps;
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, c.getCodigo());
            ps.setString(2, c.getNombre_region());         
            
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.CerrarConexion();
        }
        return false;
    }
    
     public List<RegionDTO> readAll() {
        List<RegionDTO> lst = null;
        PreparedStatement psnt;
        try {
            psnt = con.getCnn().prepareStatement(SQL_READALL);
            ResultSet rs = psnt.executeQuery();
            lst = new ArrayList<>();
            while (rs.next()) {
                RegionDTO obj = new RegionDTO(
                      
                        rs.getInt("codigo"),
                        rs.getString("nombre_region")
        
                );
                lst.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.CerrarConexion();
        }
        return lst;
    }
     public boolean delete(RegionDTO item) {

        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_DELETE);
            ps.setInt(1, item.getCodigo());
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
     
    public boolean update(RegionDTO item) {

        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
          
            ps.setInt(1, item.getCodigo());
            ps.setString(2, item.getNombre_region());         
           
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

   public RegionDTO read(RegionDTO filter) {
        RegionDTO objRes = null;
        PreparedStatement psnt;
        try {
            psnt = con.getCnn().prepareStatement(SQL_READ);
            psnt.setFloat(1, filter.getCodigo());
            ResultSet rs = psnt.executeQuery();
            while (rs.next()) {
                objRes = new RegionDTO(
                      
                        rs.getInt("codigo"),
                        rs.getString("nombre_region")
                        
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.CerrarConexion();
        }
        return objRes;
    }  
    
    
    
}
