package Modelo;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    Conexion conexion;

    public UsuarioDAO() {
        conexion = new Conexion();
    }

    public Usuario verificarUsuario(String usuario_user, String usuario_pass) {
        Usuario usuario = null;
        Connection accesoDB = conexion.getConexion();
        try {
            PreparedStatement ps = accesoDB.prepareStatement("select * from usuario where usuario_username=? and usuario_pass=?");
            ps.setString(1, usuario_user);
            ps.setString(2, usuario_pass);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setUsuario_id(rs.getInt(1));
                usuario.setNegocio_nit(rs.getString(2));
                usuario.setUsuario_rol(rs.getString(3));
                usuario.setUsuario_user(rs.getString(4));
                usuario.setUsuario_pass(rs.getString(5));
                return usuario;
            }
        } catch (Exception e) {
        }
        return usuario;
    }

    public void insertarUsuario(Usuario u) {

        ArrayList<String> array = new ArrayList<String>();
        NegocioDAO infNegocio = new NegocioDAO();
        array = infNegocio.mostrarInfoNegocio();
        
        if(array.isEmpty()){
            JOptionPane.showMessageDialog(null, "ERROR: Debe registrar el negocio antes de ingresar usuarios");
        }

        Usuario usuario = null;
        Connection accesoDB = conexion.getConexion();
        try {
            PreparedStatement ps = accesoDB.prepareStatement("INSERT INTO USUARIO (NEGOCIO_NIT, USUARIO_ROL, USUARIO_USERNAME, USUARIO_PASS) VALUES(?,?,?,?)");
            ps.setString(1, array.get(0));
            ps.setString(2, u.getUsuario_rol());
            ps.setString(3, u.getUsuario_user());
            ps.setString(4, u.getUsuario_pass());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos guardados!");

        } catch (MySQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return;
        }
    }

}
