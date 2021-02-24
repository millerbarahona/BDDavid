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
import Modelo.DTO.PlatoDTO;

public class PlatoDAO {

    private static final String SQL_INSERT = "INSERT INTO plato"
            + "(id_plato ,nombre , descripcion , ruta_imagen, precio )VALUES(?,?,?,?,?)";
    private static final String SQL_INSERT1 = "INSERT INTO plato"
            + "(id_plato ,nombre , descripcion , precio )VALUES(?,?,?,?)";
    private static final String SQL_INSERT2 = "INSERT INTO necesitar"
            + "(id_plato, codigo_ingredientes) VALUES(?,?)";
    private static final String SQL_DELETE = "DELETE FROM plato WHERE id_plato= ?";
    private static final String SQL_UPDATE = "UPDATE plato SET  nombre = ? ,und_pro = ?, descripcion = ? , ruta_imagen = ? , precio = ?  WHERE id_plato = ?";
    private static final String SQL_READ = "SELECT *FROM plato WHERE id_plato = ?";
    private static final String SQL_READALL = "SELECT *FROM plato";

    private static final Conexion con = Conexion.getInstance();

    public boolean create(PlatoDTO c, List<Integer> ingredientes) {
        try {
            PreparedStatement ps ;
            PreparedStatement ps1;
            ps = con.getCnn().prepareStatement(SQL_INSERT1);
            ps.setInt(1, c.getId_plato());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getDescipcion());
            ps.setFloat(4, c.getPrecio());

            if (ps.executeUpdate() > 0) {
                
                ps1 = con.getCnn().prepareStatement(SQL_INSERT2);
                for (int i = 0; i < ingredientes.size(); i++) {
                    ps1.setInt(1, c.getId_plato());
                    ps1.setInt(2, ingredientes.get(i));
                    if (ps1.executeUpdate() > 0){
                        System.out.println("bien jeje");
                    }
                }
                 
                
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.CerrarConexion();
        }
        return false;
    }

    public List<PlatoDTO> readAll() {
        List<PlatoDTO> lst = null;
        PreparedStatement psnt;
        try {
            psnt = con.getCnn().prepareStatement(SQL_READALL);
            ResultSet rs = psnt.executeQuery();
            lst = new ArrayList<>();
            while (rs.next()) {
                PlatoDTO obj = new PlatoDTO(
                        rs.getInt("id_plato"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getBinaryStream("ruta_imagen"),
                        rs.getFloat("precio")
                );
                lst.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.CerrarConexion();
        }
        return lst;
    }

    public boolean delete(PlatoDTO item) {

        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_DELETE);
            ps.setInt(1, item.getId_plato());
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

    public boolean update(PlatoDTO item) {

        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setInt(1, item.getId_plato());
            ps.setString(2, item.getNombre());
            ps.setBinaryStream(3, item.getRuta_imagen());
            ps.setFloat(4, item.getPrecio());

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

    public PlatoDTO read(PlatoDTO filter) {
        PlatoDTO objRes = null;
        PreparedStatement psnt;
        try {
            psnt = con.getCnn().prepareStatement(SQL_READ);
            psnt.setFloat(1, filter.getId_plato());
            ResultSet rs = psnt.executeQuery();
            while (rs.next()) {
                objRes = new PlatoDTO(
                        rs.getInt("id_plato"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getBinaryStream("ruta_imagen"),
                        rs.getFloat("precio")
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
