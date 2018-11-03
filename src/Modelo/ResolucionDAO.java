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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alexc
 */
public class ResolucionDAO {

    Conexion con;

    public ResolucionDAO() {
        con = new Conexion();
    }

    public void insertarModeloResolucion(Resolucion r) {

        if (r.getRESOLUCION_NUMERO().equals("")) {
            JOptionPane.showMessageDialog(null, "Especificar un numero de resolución");
            return;
        }

        if (r.getRESOLUCION_FECHAAUTORIZACION().equals("")) {
            JOptionPane.showMessageDialog(null, "Especificar la fecha de autorización");
            return;
        } else if (r.getRESOLUCION_FECHAAUTORIZACION().compareTo(r.getRESOLUCION_FECHAINGRESO()) > 0) {
            JOptionPane.showMessageDialog(null, "La fecha de autorización no es válida");
            return;
        }

        if (r.getRESOLUCION_SERIE().equals("")) {
            JOptionPane.showMessageDialog(null, "Especificar un numero de serie");
            return;
        }

        if (r.getRESOLUCION_NUMEROFINAL() < r.getRESOLUCION_NUMEROINICIAL()) {
            JOptionPane.showMessageDialog(null, "El numero inicial no puede ser mayor al numero final");
            return;
        }

        try {
            Connection accesoDB = con.getConexion();

            if (accesoDB == null) {
                JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
            }


            /*ESTOS TRES IF'S SIGUIENTES, SON PARA VALIDAR QUE NO HAYA NINGUNA RESOLUCION ACTIVA,
            YA SEA PARA CUALQUIERA DE LOS 3 TIPOS DE DOCUMENTOS.*/
            if (r.getRESOLUCION_TIPODOC().equals("Factura")) {

                PreparedStatement ps1 = accesoDB.prepareStatement("SELECT RESOLUCION_ACTIVA FROM RESOLUCION WHERE RESOLUCION_ACTIVA=? AND RESOLUCION_TIPODOC=?");
                ps1.setString(1, "1");
                ps1.setString(2, "Factura");
                ResultSet rs1 = ps1.executeQuery();

                if (rs1.next()) {
                    JOptionPane.showMessageDialog(null, "ERROR: Ya existe una resolución activa para este documento");
                    return;
                }
            }

            if (r.getRESOLUCION_TIPODOC().equals("Nota de crédito")) {

                PreparedStatement ps1 = accesoDB.prepareStatement("SELECT RESOLUCION_ACTIVA FROM RESOLUCION WHERE RESOLUCION_ACTIVA=? AND RESOLUCION_TIPODOC=?");
                ps1.setString(1, "1");
                ps1.setString(2, "Nota de crédito");
                ResultSet rs1 = ps1.executeQuery();

                if (rs1.next()) {
                    JOptionPane.showMessageDialog(null, "ERROR: Ya existe una resolución activa para este documento");
                    return;
                }
            }

            if (r.getRESOLUCION_TIPODOC().equals("Nota de débito")) {

                PreparedStatement ps1 = accesoDB.prepareStatement("SELECT RESOLUCION_ACTIVA FROM RESOLUCION WHERE RESOLUCION_ACTIVA=? AND RESOLUCION_TIPODOC=?");
                ps1.setString(1, "1");
                ps1.setString(2, "Nota de débito");
                ResultSet rs1 = ps1.executeQuery();

                if (rs1.next()) {
                    JOptionPane.showMessageDialog(null, "ERROR: Ya existe una resolución activa para este documento");
                    return;
                }
            }

            try {

                PreparedStatement ps = accesoDB.prepareStatement("INSERT INTO RESOLUCION(RESOLUCION_NUMERO,RESOLUCION_NUMEROINICIAL,RESOLUCION_NUMEROFINAL,RESOLUCION_SERIE,RESOLUCION_TIPODOC,RESOLUCION_FECHAAUTORIZACION,RESOLUCION_FECHAINGRESO,RESOLUCION_ACTIVA) VALUES (?,?,?,?,?,?,?,?)");
                ps.setString(1, r.getRESOLUCION_NUMERO());
                ps.setInt(2, r.getRESOLUCION_NUMEROINICIAL());
                ps.setInt(3, r.getRESOLUCION_NUMEROFINAL());
                ps.setString(4, r.getRESOLUCION_SERIE());
                ps.setString(5, r.getRESOLUCION_TIPODOC());
                ps.setDate(6, r.getRESOLUCION_FECHAAUTORIZACION());
                ps.setDate(7, r.getRESOLUCION_FECHAINGRESO());
                ps.setInt(8, 1);
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

    public ArrayList<Object[]> mostrarResoluciones(Date fechaDESDE, Date fechaHASTA) {

        Connection accesoDB = con.getConexion();
        try {

            PreparedStatement ps = accesoDB.prepareStatement("select RESOLUCION_NUMERO,RESOLUCION_TIPODOC,RESOLUCION_NUMEROINICIAL,RESOLUCION_NUMEROFINAL,RESOLUCION_SERIE,RESOLUCION_FECHAAUTORIZACION,RESOLUCION_FECHAINGRESO,RESOLUCION_ACTIVA from resolucion where RESOLUCION_FECHAINGRESO>=? and RESOLUCION_FECHAINGRESO<=?");
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

    public ArrayList<String> mostrarResolucionActivaFACTURA() {

        ArrayList<String> array = new ArrayList<String>();

        try {
            Connection accesoDB = con.getConexion();
            if (accesoDB == null) {
                JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
                return null;
            }

            try {

                PreparedStatement ps = accesoDB.prepareStatement("select RESOLUCION_NUMERO,RESOLUCION_TIPODOC,RESOLUCION_NUMEROINICIAL,RESOLUCION_NUMEROFINAL,RESOLUCION_SERIE,RESOLUCION_FECHAAUTORIZACION,RESOLUCION_FECHAINGRESO,RESOLUCION_ACTIVA from resolucion where RESOLUCION_TIPODOC='Factura' AND RESOLUCION_ACTIVA=1");
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    array.add(rs.getString("RESOLUCION_NUMERO"));
                    array.add(rs.getString("RESOLUCION_TIPODOC"));
                    array.add(String.valueOf(rs.getInt("RESOLUCION_NUMEROINICIAL")));
                    array.add(String.valueOf(rs.getInt("RESOLUCION_NUMEROFINAL")));
                    array.add(rs.getString("RESOLUCION_SERIE"));
                    array.add(String.valueOf(rs.getDate("RESOLUCION_FECHAAUTORIZACION")));
                    array.add(String.valueOf(rs.getDate("RESOLUCION_FECHAINGRESO")));
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

    public void desactivarResolucion() {

        try {
            Connection accesoDB = con.getConexion();

            if (accesoDB == null) {
                JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
                return;
            }

            try {
                
                PreparedStatement ps = accesoDB.prepareStatement("UPDATE RESOLUCION SET RESOLUCION_ACTIVA=0 WHERE RESOLUCION_ACTIVA=1 AND RESOLUCION_TIPODOC='Factura'");
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

}
