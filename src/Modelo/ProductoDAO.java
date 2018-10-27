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
public class ProductoDAO {
    
    Conexion con;

    public ProductoDAO() {
        con = new Conexion();
    }
    
    public void mostrarNombreProductos(TextAutoCompleter t) {

        t.removeAllItems();
        Conexion con = new Conexion();
        Connection accesoDB = con.getConexion();

        if (accesoDB == null) {
            JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
            return;
        }

        try {
            int i = 0;
            PreparedStatement ps = accesoDB.prepareStatement("SELECT PRODUCTO_NOMBRE FROM PRODUCTO GROUP BY PRODUCTO_NOMBRE");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();

            while (rs.next()) {
                t.addItem(rs.getString(1) + " ");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public int mostrarIDdeUnProducto(int uniID, int preID, int marID, String nomPro) {

        Conexion con = new Conexion();
        Connection accesoDB = con.getConexion();
        int J;

        if (accesoDB == null) {
            JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
            return 0;
        }

        try {
            int i = 0;
            PreparedStatement ps = accesoDB.prepareStatement("SELECT PRODUCTO_ID FROM PRODUCTO WHERE UNIDAD_ID=? AND PRESENTACION_ID=? AND MARCA_ID=? AND PRODUCTO_NOMBRE=?");
            ps.setInt(1, uniID);
            ps.setInt(2, preID);
            ps.setInt(3, marID);
            ps.setString(4, nomPro);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                J = rs.getInt("PRODUCTO_ID");
                return J;
            }
            return 0;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }
    
    public void insertarProducto(int uniID, int preID, int marID, String nomPro) {
        
        try {
            Connection accesoDB = con.getConexion();

            if (accesoDB == null) {
                JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
            }

            try {

                PreparedStatement ps = accesoDB.prepareStatement("INSERT INTO PRODUCTO (UNIDAD_ID,PRESENTACION_ID,MARCA_ID,PRODUCTO_NOMBRE) VALUES (?,?,?,?)");
                ps.setInt(1, uniID);
                ps.setInt(2, preID);
                ps.setInt(3, marID);
                ps.setString(4, nomPro);
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
    
    
}
