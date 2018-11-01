package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author alexc
 */
public class FacturaDAO {
    
    Conexion con;

    public FacturaDAO() {
        con = new Conexion();
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
            PreparedStatement ps = accesoDB.prepareStatement("SELECT FACTURA_NUMERO FROM FACTURA ORDER BY FACTURA_NUMERO DESC limit 1");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                J = rs.getInt("FACTURA_NUMERO");
                return J;
            }
            return 0;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }
    
}
