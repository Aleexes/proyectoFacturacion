package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author alexc
 */
public class TransaccionDAO {
    
    Conexion con;

    public TransaccionDAO() {
        con = new Conexion();
    }
    
    public ArrayList<Object[]> mostrarTransacciones(Date fechaDESDE, Date fechaHASTA) {

        Connection accesoDB = con.getConexion();
        try {

            PreparedStatement ps = accesoDB.prepareStatement("select TRANSACCION_NUMERO,TRANSACCION_TIPODOCU,TRANSACCION_CORRELATIVO,TRANSACCION_SERIE,TRANSACCION_MONTO,TRANSACCION_FECHA,TRANSACCION_ESTADO from transaccion where TRANSACCION_FECHA>=? and TRANSACCION_FECHA<=?");
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
    
    public int mostrarNumeroUltimaFacturaIngresada() {

        Conexion con = new Conexion();
        Connection accesoDB = con.getConexion();
        int J;

        if (accesoDB == null) {
            JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
            return 0;
        }

        try {
            int i = 0;
            PreparedStatement ps = accesoDB.prepareStatement("SELECT TRANSACCION_NUMERO FROM TRANSACCION ORDER BY TRANSACCION_NUMERO DESC limit 1");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                J = rs.getInt("TRANSACCION_NUMERO");
                return J;
            }
            return 0;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }
    
    
}
