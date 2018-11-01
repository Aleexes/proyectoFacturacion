package Modelo;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author alexc
 */
public class CompraDAO {

    Conexion con;

    public CompraDAO() {
        con = new Conexion();
    }

    public void insertarCompra(Compra c) {

        try {
            Connection accesoDB = con.getConexion();

            if (accesoDB == null) {
                JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
            }

            try {

                PreparedStatement ps = accesoDB.prepareStatement("INSERT INTO COMPRA (COMPRA_NUMEROFACTURANOSDIERON,COMPRA_MONTOTOTAL,COMPRA_FECHAREALIZACION,COMPRA_ISREGISTRADA) VALUES (?,?,?,?)");
                ps.setInt(1, c.getCOMPRA_NUMEROFACTURANOSDIERON());
                ps.setDouble(2, c.COMPRA_MONTOTOTAL);
                ps.setDate(3, c.getCOMPRA_FECHAREALIZACION());
                ps.setInt(4, 0);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos guardados!");

            } catch (MySQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return;
        }
    }

    public String verSiHayComprasPendientesdeRegistrar() {

        try {

            Connection accesoDB = con.getConexion();

            if (accesoDB == null) {
                JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
                return null;
            }

            try {

                PreparedStatement ps = accesoDB.prepareStatement("SELECT COMPRA_NUMEROFACTURANOSDIERON FROM COMPRA WHERE COMPRA_ISREGISTRADA=0");
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    return rs.getString("COMPRA_NUMEROFACTURANOSDIERON");
                }

            } catch (MySQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                return null;

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return null;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
        return null;
    }

    public int obtenerIDcompraActiva() {

        try {

            Connection accesoDB = con.getConexion();

            if (accesoDB == null) {
                JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
                return 0;
            }

            try {

                PreparedStatement ps = accesoDB.prepareStatement("SELECT COMPRA_ID FROM COMPRA WHERE COMPRA_ISREGISTRADA=0");
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    return rs.getInt("COMPRA_ID");
                }

            } catch (MySQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                return 0;

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return 0;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
        return 0;
    }

    public double obtenerMontoCompra(int id_compra) {

        try {

            Connection accesoDB = con.getConexion();

            if (accesoDB == null) {
                JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
                return 0;
            }

            try {

                PreparedStatement ps = accesoDB.prepareStatement("SELECT COMPRA_MONTOTOTAL FROM COMPRA WHERE COMPRA_ID=?");
                ps.setInt(1, id_compra);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    return rs.getDouble("COMPRA_MONTOTOTAL");
                }

            } catch (MySQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                return 0;

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return 0;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
        return 0;
    }

    public void colocarCompraComoRegistrada(int id_compra) {

        try {
            Connection accesoDB = con.getConexion();

            if (accesoDB == null) {
                JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
                return;
            }

            try {
                PreparedStatement ps = accesoDB.prepareStatement("UPDATE COMPRA SET COMPRA_ISREGISTRADA=1 WHERE COMPRA_ID=?");
                ps.setInt(1, id_compra);
                ps.executeUpdate();
                return;

            } catch (MySQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                return;

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return;
        }

    }

    public ArrayList<Object[]> mostrarCompras(Date fechaDESDE, Date fechaHASTA) {

        Connection accesoDB = con.getConexion();
        try {

            PreparedStatement ps = accesoDB.prepareStatement("SELECT COMPRA_ID,COMPRA_NUMEROFACTURANOSDIERON,COMPRA_FECHAREALIZACION,COMPRA_MONTOTOTAL FROM COMPRA WHERE COMPRA_FECHAREALIZACION>=? and COMPRA_FECHAREALIZACION<=?");
            ps.setDate(1, fechaDESDE);
            ps.setDate(2, fechaHASTA);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();
            ArrayList<Object[]> data = new ArrayList<>();

            while (rs.next()) {
                Object[] rows = new Object[rsm.getColumnCount()];
                for (int i = 0; i < rows.length; i++) {
                    rows[i] = rs.getObject(i + 1);
                }
                data.add(rows);
            }
            return data;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
}
