/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioDAO;
import Vista.JIFAdmin;
import java.awt.event.*;

/**
 *
 * @author alexc
 */
public class ControladorAdmin{
    
    JIFAdmin vistaAdmin = new JIFAdmin();
    UsuarioDAO modeloAdmin = new UsuarioDAO();
    Usuario usuario = new Usuario();
    int usuario_id;
    String usuario_user, usuario_pass;
    
    public ControladorAdmin(JIFAdmin vistaAdmin, UsuarioDAO modeloAdmin){
        //TODOS LOS ELEMENTOS PARA CARGAR LA VENTANA DE ADMIN
        this.vistaAdmin=vistaAdmin;
        this.modeloAdmin=modeloAdmin;
    }

    public ControladorAdmin(int usuario_id, String usuario_user, String usuario_pass) {
        this.usuario_id = usuario_id;
        this.usuario_user = usuario_user;
        this.usuario_pass = usuario_pass;
    }

    public void inicializaAdmin(int usuario_id, String usuario_user, String usuario_pass){
        this.usuario_id = usuario_id;
        this.usuario_user = usuario_user;
        this.usuario_pass = usuario_pass;
    }
}
