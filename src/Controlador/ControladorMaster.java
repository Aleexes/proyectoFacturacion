package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioDAO;
import Vista.JIFMaster;

/**
 *
 * @author alexc
 */
public class ControladorMaster {
    
    JIFMaster vistaMaster = new JIFMaster();
    UsuarioDAO modeloMaster = new UsuarioDAO();
    Usuario usuario = new Usuario();
    int usuario_id;
    String usuario_user, usuario_pass;
    
    public ControladorMaster(JIFMaster vistaMaster, UsuarioDAO modeloMaster){
        //TODOS LOS ELEMENTOS PARA CARGAR LA VENTANA DE MASTER
        this.vistaMaster=vistaMaster;
        this.modeloMaster=modeloMaster;
    }
    
    public void inicializaMaster(int usuario_id, String usuario_user, String usuario_pass){
        this.usuario_id = usuario_id;
        this.usuario_user = usuario_user;
        this.usuario_pass = usuario_pass;
    }
    
}
