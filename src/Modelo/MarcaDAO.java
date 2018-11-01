package Modelo;

import com.mxrck.autocompleter.TextAutoCompleter;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author alexc
 */
public class MarcaDAO {

    public void mostrarNombreMarcas(TextAutoCompleter t) {
        
        t.removeAllItems();
        Conexion con = new Conexion();
        Connection accesoDB = con.getConexion();

        if (accesoDB == null) {
            JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
            return;
        }

        try {
            int i = 0;
            PreparedStatement ps = accesoDB.prepareStatement("SELECT NOMBRE_MARCA FROM MARCA");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();

            while (rs.next()) {
                t.addItem(rs.getString(1) + " ");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public int mostrarIDdeUnaMarca(String nombreMarca) {
        
        Conexion con = new Conexion();
        Connection accesoDB = con.getConexion();
        int J;

        if (accesoDB == null) {
            JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
            return 0;
        }

        try {
            int i = 0;
            PreparedStatement ps = accesoDB.prepareStatement("SELECT MARCA_ID FROM MARCA WHERE NOMBRE_MARCA=?");
            ps.setString(1, nombreMarca);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                J = rs.getInt("MARCA_ID");
                return J;
            }
            return 0;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }

    public void insertarMarca(String nombreMarca) {
        
        Conexion con = new Conexion();
        
        try {
            Connection accesoDB = con.getConexion();

            if (accesoDB == null) {
                JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
            }

            try {

                PreparedStatement ps = accesoDB.prepareStatement("INSERT INTO MARCA (NOMBRE_MARCA) VALUES (?)");
                ps.setString(1, nombreMarca);
                ps.executeUpdate();

            } catch (MySQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public String mostrarNombreDeUnaMarca(int idMarca) {
        
        Conexion con = new Conexion();
        Connection accesoDB = con.getConexion();
        String nombreMarca = "";

        if (accesoDB == null) {
            JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
            return null;
        }

        try {
            int i = 0;
            PreparedStatement ps = accesoDB.prepareStatement("SELECT NOMBRE_MARCA FROM MARCA WHERE MARCA_ID=?");
            ps.setInt(1, idMarca);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                nombreMarca = rs.getString("NOMBRE_MARCA");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return nombreMarca;
    }
    
    
}
