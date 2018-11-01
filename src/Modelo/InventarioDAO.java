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
public class InventarioDAO {

    Conexion con;

    public InventarioDAO() {
        con = new Conexion();
    }

    public boolean verSiExisteProducto(int idProducto) {

        try {
            Connection accesoDB = con.getConexion();

            if (accesoDB == null) {
                JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
            }

            try {

                PreparedStatement ps = accesoDB.prepareStatement("SELECT PRODUCTO_ID FROM INVENTARIO WHERE PRODUCTO_ID=?");
                ps.setInt(1, idProducto);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    return true;
                }

            } catch (MySQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                return false;

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
        return false;
    }

    public int obtenerCantidadDeInventario(int idProducto) {
        try {
            Connection accesoDB = con.getConexion();

            if (accesoDB == null) {
                JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
                return 0;
            }

            try {

                PreparedStatement ps = accesoDB.prepareStatement("SELECT CANTIDADDEPRODUCTO FROM INVENTARIO WHERE PRODUCTO_ID=?");
                ps.setInt(1, idProducto);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    return rs.getInt("CANTIDADDEPRODUCTO");
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

    public void insertarActualizarEsxistencias(int idProducto, int cantidad) {

        int cantidadProducto_obtenida;

        try {
            Connection accesoDB = con.getConexion();

            if (accesoDB == null) {
                JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
                return;
            }

            try {

                if (verSiExisteProducto(idProducto)) {
                    cantidadProducto_obtenida = obtenerCantidadDeInventario(idProducto);
                    cantidad = cantidad + cantidadProducto_obtenida;
                    PreparedStatement ps = accesoDB.prepareStatement("UPDATE INVENTARIO SET CANTIDADDEPRODUCTO = ? WHERE PRODUCTO_ID=?");
                    ps.setInt(1, cantidad);
                    ps.setInt(2, idProducto);
                    ps.executeUpdate();
                    return;

                } else {
                    PreparedStatement ps = accesoDB.prepareStatement("INSERT INTO INVENTARIO (PRODUCTO_ID, CANTIDADDEPRODUCTO) VALUES (?,?)");
                    ps.setInt(1, idProducto);
                    ps.setInt(2, cantidad);
                    ps.executeUpdate();
                    return;
                }

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

    public ArrayList<Object[]> mostrarINVENTARIO(){
        
         Connection accesoDB = con.getConexion();
        try {

            PreparedStatement ps = accesoDB.prepareStatement("SELECT I.PRODUCTO_ID, P.PRODUCTO_NOMBRE, M.NOMBRE_MARCA, U.CLASIFICACIONUNIDAD, PR.PRESENTACION, I.CANTIDADDEPRODUCTO FROM INVENTARIO I INNER JOIN PRODUCTO P ON I.PRODUCTO_ID = P.PRODUCTO_ID INNER JOIN MARCA M ON M.MARCA_ID = P.MARCA_ID INNER JOIN PRESENTACION PR ON PR.PRESENTACION_ID = P.PRESENTACION_ID INNER JOIN UNIDAD U ON U.UNIDAD_ID = P.UNIDAD_ID ORDER BY P.PRODUCTO_NOMBRE");
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
