package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioDAO;
import Vista.JIFAgregarAdmin;

/**
 *
 * @author alexc
 */
public class ControladorUsuario {
    
    int usuario_id;
    String negocio_nit; //FK para tabla negocio
    String usuario_rol; //master,admin,empleado
    String usuario_user, usuario_pass;
    
    JIFAgregarAdmin vistaMAA = new JIFAgregarAdmin();
    UsuarioDAO modeloUsuario = new UsuarioDAO();
    Usuario usuarioObtenido;

    public ControladorUsuario(String usuario_rol, String usuario_user, String usuario_pass) {
        this.usuario_rol = usuario_rol;
        this.usuario_user = usuario_user;
        this.usuario_pass = usuario_pass;
    }

    public void crearUsuario(ControladorUsuario cU){
        usuarioObtenido = new Usuario();
        usuarioObtenido.setUsuario_user(cU.usuario_user);
        usuarioObtenido.setUsuario_pass(cU.usuario_pass);
        usuarioObtenido.setUsuario_rol(cU.usuario_rol);
        modeloUsuario.insertarUsuario(usuarioObtenido);
    }
    
}
