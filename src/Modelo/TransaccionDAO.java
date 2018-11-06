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

    public int mostrarNumeroUltimaTransaccion() {

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

    public void transaccionVentaFactura(Transaccion t, Factura f, DefaultTableModel m) {

        //1) INSERTAR UN REGISTRO DE TRANSACCION
        //2) INSERTAR UN REGISTRO DE FACTURA
        //3) INSERTAR LO/S REGISTROS DE DETALLE DE VENTA
        //4) ACTUALIZAR INVENTARIOS
        try {
            Connection accesoDB = con.getConexion();
            accesoDB.setAutoCommit(false);

            if (accesoDB == null) {
                JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
            }

            try {

                //1)
                PreparedStatement ps = accesoDB.prepareStatement("INSERT INTO TRANSACCION (TRANSACCION_SERIE, TRANSACCION_MONTO, TRANSACCION_FECHA, TRANSACCION_CORRELATIVO, TRANSACCION_ESTADO, TRANSACCION_TIPODOCU) VALUES (?,?,?,?,?,?)");
                ps.setString(1, t.getTRANSACCION_SERIE());
                ps.setDouble(2, t.getTRANSACCION_MONTO());
                ps.setDate(3, t.getTRANSACCION_FECHA());
                ps.setInt(4, t.getTRANSACCION_CORRELATIVO());
                ps.setString(5, t.getTRANSACCION_ESTADO());
                ps.setString(6, t.getTRANSACCION_TIPODOCU());
                ps.executeUpdate();

                //2)
                PreparedStatement ps2 = accesoDB.prepareStatement("INSERT INTO FACTURA (FACTURA_NUM, NEGOCIO_NIT, CLIENTE_NIT, RESOLUCION_NUMERO, TRANSACCION_NUMERO) VALUES (?,?,?,?,?)");
                ps2.setInt(1, f.getFACTURA_NUM());
                ps2.setString(2, f.getNEGOCIO_NIT());
                ps2.setString(3, f.getCLIENTE_NIT());
                ps2.setString(4, f.getRESOLUCION_NUMERO());
                ps2.setInt(5, f.getTRANSACCION_NUMERO());
                ps2.executeUpdate();

                //3)
                int conteoFilas = m.getRowCount();
                int idFactura, pID, cantidad;
                double precioVenta;
                idFactura = 0;

                PreparedStatement ps3 = accesoDB.prepareStatement("SELECT FACTURA_NUMERO FROM FACTURA ORDER BY FACTURA_NUMERO DESC limit 1");
                ResultSet rs = ps3.executeQuery();

                if (rs.next()) {
                    idFactura = rs.getInt("FACTURA_NUMERO");
                }

                for (int i = 0; i < conteoFilas; i++) {

                    pID = Integer.parseInt(m.getValueAt(i, 0).toString());
                    cantidad = Integer.parseInt(m.getValueAt(i, 5).toString());
                    precioVenta = Double.parseDouble(m.getValueAt(i, 6).toString());

                    PreparedStatement ps4 = accesoDB.prepareStatement("INSERT INTO DETALLE (FACTURA_NUMERO,PRODUCTO_ID,DETALLE_CANTIDAD,DETALLE_PRECIOVENTA) VALUES (?,?,?,?)");
                    ps4.setInt(1, idFactura);
                    ps4.setInt(2, pID);
                    ps4.setInt(3, cantidad);
                    ps4.setDouble(4, precioVenta);
                    ps4.executeUpdate();
                }

                //4)
                int cantidad_enInventario = 0;
                for (int i = 0; i < conteoFilas; i++) {

                    pID = Integer.parseInt(m.getValueAt(i, 0).toString());
                    cantidad = Integer.parseInt(m.getValueAt(i, 5).toString());

                    PreparedStatement ps5 = accesoDB.prepareStatement("SELECT CANTIDADDEPRODUCTO FROM INVENTARIO WHERE PRODUCTO_ID=?");
                    ps5.setInt(1, pID);
                    ResultSet rs2 = ps5.executeQuery();

                    if (rs2.next()) {
                        cantidad_enInventario = rs2.getInt("CANTIDADDEPRODUCTO");
                    }

                    cantidad_enInventario = cantidad_enInventario - cantidad;
                    PreparedStatement ps6 = accesoDB.prepareStatement("UPDATE INVENTARIO SET CANTIDADDEPRODUCTO = ? WHERE PRODUCTO_ID=?");
                    ps6.setInt(1, cantidad_enInventario);
                    ps6.setInt(2, pID);
                    ps6.executeUpdate();
                }

            } catch (MySQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

            accesoDB.commit();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public ArrayList<Object[]> transaccionesAsociadasAFacturas(Date fechaDESDE, Date fechaHASTA){
        
        Connection accesoDB = con.getConexion();
        try {

            PreparedStatement ps = accesoDB.prepareStatement("SELECT F.FACTURA_NUMERO, T.TRANSACCION_FECHA, T.TRANSACCION_TIPODOCU, F.CLIENTE_NIT, F.FACTURA_NUM, R.RESOLUCION_NUMERO, T.TRANSACCION_MONTO FROM TRANSACCION T INNER JOIN FACTURA F ON F.TRANSACCION_NUMERO = T.TRANSACCION_NUMERO INNER JOIN RESOLUCION R ON F.RESOLUCION_NUMERO = R.RESOLUCION_NUMERO INNER JOIN CLIENTE C ON C.CLIENTE_NIT = F.CLIENTE_NIT WHERE T.TRANSACCION_FECHA>=? and T.TRANSACCION_FECHA<=?");
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
    
    public ArrayList<Object[]> transaccionesAsociadasANotasDebito(Date fechaDESDE, Date fechaHASTA){
        
        Connection accesoDB = con.getConexion();
        try {

            PreparedStatement ps = accesoDB.prepareStatement("SELECT N.NOTADEBITO_ID, T.TRANSACCION_FECHA, T.TRANSACCION_TIPODOCU, C.CLIENTE_NIT, N.NOTADEBITO_ID, R.RESOLUCION_NUMERO, T.TRANSACCION_MONTO FROM TRANSACCION T INNER JOIN NOTA_DEBITO N ON N.TRANSACCION_NUMERO = T.TRANSACCION_NUMERO INNER JOIN RESOLUCION R ON N.RESOLUCION_NUMERO = R.RESOLUCION_NUMERO INNER JOIN CLIENTE C ON C.CLIENTE_NIT = N.CLIENTE_NIT WHERE T.TRANSACCION_FECHA>=? and T.TRANSACCION_FECHA<=?");
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
    
    public ArrayList<Object[]> transaccionesAsociadasANotasCredito(Date fechaDESDE, Date fechaHASTA){
        
        Connection accesoDB = con.getConexion();
        try {

            PreparedStatement ps = accesoDB.prepareStatement("SELECT N.NOTACREDITO_ID, T.TRANSACCION_FECHA, T.TRANSACCION_TIPODOCU, C.CLIENTE_NIT, N.NOTACREDITO_ID, R.RESOLUCION_NUMERO, T.TRANSACCION_MONTO FROM TRANSACCION T INNER JOIN NOTA_CREDITO N ON N.TRANSACCION_NUMERO = T.TRANSACCION_NUMERO INNER JOIN RESOLUCION R ON N.RESOLUCION_NUMERO = R.RESOLUCION_NUMERO INNER JOIN CLIENTE C ON C.CLIENTE_NIT = N.CLIENTE_NIT WHERE T.TRANSACCION_FECHA>=? and T.TRANSACCION_FECHA<=?");
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
