package Modelo;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author alexc
 */
public class NegocioDAO {

    Conexion con;

    public NegocioDAO() {
        con = new Conexion();
    }

    public void insertarConfiguracionSistema(Negocio n) {

        try {
            Connection accesoDB = con.getConexion();
            if (accesoDB == null) {
                JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
            }

            try {

                PreparedStatement ps = accesoDB.prepareStatement("INSERT INTO NEGOCIO (NEGOCIO_NIT, NEGOCIO_NOMBRE, NEGOCIO_NOMBRESOCIAL, NEGOCIO_DIRECCION) VALUES (?,?,?,?)");
                ps.setString(1, n.getNegocio_nit());
                ps.setString(2, n.getNegocio_nombre());
                ps.setString(3, n.getNegocio_nombreSocial());
                ps.setString(4, n.getNegocio_direccion());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos guardados!");

            } catch (MySQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, "ERROR: El NIT ingresado coincide con otro");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR: El NIT ingresado coincide con otro");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public ArrayList<String> mostrarInfoNegocio() {

        ArrayList<String> array = new ArrayList<String>();

        try {
            Connection accesoDB = con.getConexion();
            if (accesoDB == null) {
                JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
                return null;
            }

            try {

                PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM NEGOCIO");
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    array.add(rs.getString("NEGOCIO_NIT"));
                    array.add(rs.getString("NEGOCIO_NOMBRE"));
                    array.add(rs.getString("NEGOCIO_NOMBRESOCIAL"));
                    array.add(rs.getString("NEGOCIO_DIRECCION"));
                }

            } catch (MySQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, "No hay datos de algun negocio en la base de datos");
                return null;

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "No hay datos de algun negocio en la base de datos");
                return null;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }

        return array;
    }

}
