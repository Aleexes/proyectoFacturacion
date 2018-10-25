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
public class SistemaDAO {
    
    Conexion con;

    public SistemaDAO() {
        con = new Conexion();
    }
    
    public void insertarConfiguracionSistema(Sistema s) {

        try {
            Connection accesoDB = con.getConexion();
            if (accesoDB == null) {
                JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
            }

            try {
                
                PreparedStatement ps = accesoDB.prepareStatement("INSERT INTO SISTEMA(RESOLUCION_SISTEMA,NUMERO_MAQUINA,SISTEMA_FECHAAUTORESOL) VALUES (?,?,?)");
                ps.setString(1, s.getRESOLUCION_SISTEMA());
                ps.setInt(2, s.getNUMERO_MAQUINA());
                ps.setDate(3, s.getSISTEMA_FECHAAUTORESOL());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos guardados!");

            } catch (MySQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, "ERROR: El numero de resolución ingresado coincide con otro");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR: El numero de resolución ingresado coincide con otro");
            }

        } catch (Exception e) {
        }
    }
    
    public ArrayList<String> mostrarInfoSistema(){
        
        ArrayList<String> array = new ArrayList<String>();

        try {
            Connection accesoDB = con.getConexion();
            if (accesoDB == null) {
                JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
                return null;
            }

            try {

                PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM SISTEMA");
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    array.add(rs.getString("RESOLUCION_SISTEMA"));
                    array.add(rs.getString("NUMERO_MAQUINA"));
                    array.add(rs.getString("SISTEMA_FECHAAUTORESOL"));
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
