package Modelo;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
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
public class DetalleCompraDAO {

    Conexion con;

    public DetalleCompraDAO() {
        con = new Conexion();
    }

    public void insertarDetalleCompra(int idProducto, int idCompra, double precioCompra, int cantidad_comprada) {

        try {
            Connection accesoDB = con.getConexion();

            if (accesoDB == null) {
                JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
            }

            try {

                PreparedStatement ps = accesoDB.prepareStatement("INSERT INTO DETALLE_COMPRA (PRODUCTO_ID,COMPRA_ID,PRECIOCOMPRA,CANTIDAD_COMPRADA) VALUES (?,?,?,?)");
                ps.setInt(1, idProducto);
                ps.setInt(2, idCompra);
                ps.setDouble(3, precioCompra);
                ps.setInt(4, cantidad_comprada);
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

    public ArrayList<Object[]> mostrarDetalleDeUnaCompra(int idCompra){
        
        Connection accesoDB = con.getConexion();
        try {

            PreparedStatement ps = accesoDB.prepareStatement("SELECT D.PRODUCTO_ID, P.PRODUCTO_NOMBRE, M.NOMBRE_MARCA, PR.PRESENTACION, U.CLASIFICACIONUNIDAD, D.PRECIOCOMPRA, D.CANTIDAD_COMPRADA FROM DETALLE_COMPRA D INNER JOIN PRODUCTO P ON D.PRODUCTO_ID = P.PRODUCTO_ID INNER JOIN MARCA M ON M.MARCA_ID = P.MARCA_ID INNER JOIN PRESENTACION PR ON PR.PRESENTACION_ID = P.PRESENTACION_ID  INNER JOIN UNIDAD U ON U.UNIDAD_ID = P.UNIDAD_ID WHERE COMPRA_ID = ?");
            ps.setInt(1, idCompra);
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




