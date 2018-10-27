package Modelo;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

}
