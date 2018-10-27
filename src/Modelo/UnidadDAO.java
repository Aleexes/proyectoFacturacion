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
public class UnidadDAO {

    public void mostrarNombreUnidades(TextAutoCompleter t) {

        t.removeAllItems();
        Conexion con = new Conexion();
        Connection accesoDB = con.getConexion();

        if (accesoDB == null) {
            JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
            return;
        }

        try {
            int i = 0;
            PreparedStatement ps = accesoDB.prepareStatement("SELECT CLASIFICACIONUNIDAD FROM UNIDAD");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();

            while (rs.next()) {
                t.addItem(rs.getString(1) + " ");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public int mostrarIDdeUnaUnidad(String nombreUnidad) {
        Conexion con = new Conexion();
        Connection accesoDB = con.getConexion();
        int J;

        if (accesoDB == null) {
            JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
            return 0;
        }

        try {
            int i = 0;
            PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM UNIDAD WHERE CLASIFICACIONUNIDAD=?");
            ps.setString(1, nombreUnidad);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                J = rs.getInt("UNIDAD_ID");
                return J;
            }
            return 0;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }

    public void insertarUnidad(String nombreUnidad) {
        
        Conexion con = new Conexion();
        
        try {
            Connection accesoDB = con.getConexion();

            if (accesoDB == null) {
                JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
            }

            try {

                PreparedStatement ps = accesoDB.prepareStatement("INSERT INTO UNIDAD (CLASIFICACIONUNIDAD) VALUES (?)");
                ps.setString(1, nombreUnidad);
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
