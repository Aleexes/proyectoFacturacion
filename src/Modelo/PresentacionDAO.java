/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.mxrck.autocompleter.TextAutoCompleter;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author alexc
 */
public class PresentacionDAO {

    public void mostrarNombrePresentaciones(TextAutoCompleter t) {

        t.removeAllItems();
        Conexion con = new Conexion();
        Connection accesoDB = con.getConexion();

        if (accesoDB == null) {
            JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
            return;
        }

        try {
            int i = 0;
            PreparedStatement ps = accesoDB.prepareStatement("SELECT PRESENTACION FROM PRESENTACION");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();

            while (rs.next()) {
                t.addItem(rs.getString(1) + " ");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public int mostrarIDdeUnaPresentacion(String nombrePresentacion) {
        Conexion con = new Conexion();
        Connection accesoDB = con.getConexion();
        int J;

        if (accesoDB == null) {
            JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
            return 0;
        }

        try {
            int i = 0;
            PreparedStatement ps = accesoDB.prepareStatement("SELECT PRESENTACION_ID FROM PRESENTACION WHERE PRESENTACION=?");
            ps.setString(1, nombrePresentacion);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                J = rs.getInt("PRESENTACION_ID");
                return J;
            }
            return 0;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }

    public void insertarPresentacion(String nombrePresentacion) {

        Conexion con = new Conexion();

        try {
            Connection accesoDB = con.getConexion();

            if (accesoDB == null) {
                JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
            }

            try {

                PreparedStatement ps = accesoDB.prepareStatement("INSERT INTO PRESENTACION (PRESENTACION) VALUES (?)");
                ps.setString(1, nombrePresentacion);
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

    public String mostrarNombreDeUnaPresentacion(int idPresentacion) {

        Conexion con = new Conexion();
        Connection accesoDB = con.getConexion();
        String nombrePresentacion = "";

        if (accesoDB == null) {
            JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar con la base de datos");
            return null;
        }

        try {
            int i = 0;
            PreparedStatement ps = accesoDB.prepareStatement("SELECT PRESENTACION FROM PRESENTACION WHERE PRESENTACION_ID=?");
            ps.setInt(1, idPresentacion);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                nombrePresentacion = rs.getString("PRESENTACION");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return nombrePresentacion;
    }

}
