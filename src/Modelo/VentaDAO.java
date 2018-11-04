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
public class VentaDAO {

    Conexion con;

    public VentaDAO() {
        con = new Conexion();
    }

    public double mostrarPrecioVentaProducto(int idProducto) {

        Conexion con = new Conexion();
        Connection accesoDB = con.getConexion();
        double J;

        if (accesoDB == null) {
            JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
            return 0;
        }

        try {
            int i = 0;
            PreparedStatement ps = accesoDB.prepareStatement("SELECT VENTA_PRECIOVENTA FROM VENTA WHERE PRODUCTO_ID=?");
            ps.setInt(1, idProducto);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                J = rs.getDouble("VENTA_PRECIOVENTA");
                return J;
            }
            return 0;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }

    public void insertarNuevoPrecioVenta(int idProducto, double precioVenta) {

        try {
            Connection accesoDB = con.getConexion();

            if (accesoDB == null) {
                JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
            }

            try {

                PreparedStatement ps = accesoDB.prepareStatement("INSERT INTO VENTA (PRODUCTO_ID,VENTA_PRECIOVENTA) VALUES (?,?)");
                ps.setInt(1, idProducto);
                ps.setDouble(2, precioVenta);
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

    public ArrayList<Object[]> mostrarProductosYsusPrecios(){

        Connection accesoDB = con.getConexion();
        try {

            PreparedStatement ps = accesoDB.prepareStatement("SELECT V.PRODUCTO_ID, P.PRODUCTO_NOMBRE, M.NOMBRE_MARCA, PR.PRESENTACION, U.CLASIFICACIONUNIDAD, V.VENTA_PRECIOVENTA FROM VENTA V INNER JOIN PRODUCTO P ON V.PRODUCTO_ID = P.PRODUCTO_ID INNER JOIN MARCA M ON M.MARCA_ID = P.MARCA_ID INNER JOIN PRESENTACION PR ON PR.PRESENTACION_ID = P.PRESENTACION_ID INNER JOIN UNIDAD U ON U.UNIDAD_ID = P.UNIDAD_ID ORDER BY P.PRODUCTO_NOMBRE");
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

    public void actualizarPrecioDeUnProducto(int idProducto, double nuevoPrecio) {

        int cantidadProducto_obtenida;

        try {
            Connection accesoDB = con.getConexion();

            if (accesoDB == null) {
                JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
                return;
            }

            try {

                if (verSiExisteProducto(idProducto)) {
                    PreparedStatement ps = accesoDB.prepareStatement("UPDATE VENTA SET VENTA_PRECIOVENTA=? WHERE PRODUCTO_ID=?");
                    ps.setDouble(1, nuevoPrecio);
                    ps.setInt(2, idProducto);
                    ps.executeUpdate();
                    return;

                } else {
                    JOptionPane.showMessageDialog(null, "El id del producto ingresado no se encuentra en catalogo, por favor verificar información");
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

}
