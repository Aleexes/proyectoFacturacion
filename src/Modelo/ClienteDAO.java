/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.mxrck.autocompleter.TextAutoCompleter;
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
public class ClienteDAO {

    Conexion con;

    public ClienteDAO() {
        con = new Conexion();
    }

    public void insertarCliente(Cliente c) {

        try {
            Connection accesoDB = con.getConexion();

            if (accesoDB == null) {
                JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
            }

            try {

                PreparedStatement ps = accesoDB.prepareStatement("INSERT INTO CLIENTE(CLIENTE_NIT,NEGOCIO_NIT,CLIENTE_NOMBRE,CLIENTE_DOMICILIO) VALUES (?,?,?,?)");
                ps.setString(1, c.getCliente_nit());
                ps.setString(2, c.getNegocio_nit());
                ps.setString(3, c.getCliente_nombre());
                ps.setString(4, c.getCliente_domicilio());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cliente registrado!");

            } catch (MySQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public ArrayList<Object[]> mostrarClientes() {

        Connection accesoDB = con.getConexion();

        if (accesoDB == null) {
            JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
        }

        try {

            PreparedStatement ps = accesoDB.prepareStatement("SELECT CLIENTE_NIT,CLIENTE_NOMBRE,CLIENTE_DOMICILIO FROM CLIENTE ");
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

    public void mostrarNitsDeClientes(TextAutoCompleter t) {

        t.removeAllItems();
        Conexion con = new Conexion();
        Connection accesoDB = con.getConexion();

        if (accesoDB == null) {
            JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
            return;
        }

        try {
            int i = 0;
            PreparedStatement ps = accesoDB.prepareStatement("SELECT CLIENTE_NIT FROM CLIENTE ORDER BY CLIENTE_NIT");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();

            while (rs.next()) {
                t.addItem(rs.getString(1) + " ");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public ArrayList<String> mostrarInfoCliente(String nit) {

        ArrayList<String> array = new ArrayList<String>();

        try {
            Connection accesoDB = con.getConexion();
            if (accesoDB == null) {
                JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
                return null;
            }

            try {

                PreparedStatement ps = accesoDB.prepareStatement("SELECT CLIENTE_NOMBRE, CLIENTE_DOMICILIO FROM CLIENTE WHERE CLIENTE_NIT=?");
                ps.setString(1, nit);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    array.add(rs.getString("CLIENTE_NOMBRE"));
                    array.add(rs.getString("CLIENTE_DOMICILIO"));
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

    public boolean verSiExisteCliente(String nitCliente) {

        try {
            Connection accesoDB = con.getConexion();

            if (accesoDB == null) {
                JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
            }

            try {

                PreparedStatement ps = accesoDB.prepareStatement("SELECT CLIENTE_NIT FROM CLIENTE WHERE CLIENTE_NIT=?");
                ps.setString(1, nitCliente);
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
    
    
    
}
