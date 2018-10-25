/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import javax.swing.*;

import Modelo.Usuario;
import Modelo.UsuarioDAO;
import Vista.JIFAdmin;
import Vista.JIFEmpleado;
import Vista.JIFLogin;
import Vista.JIFMaster;
import Vista.JIFModeloResolucion;
import Vista.MDI;
import static Vista.MDI.jDesktopPane1;
import java.awt.event.*;

/**
 *
 * @author alexc
 */
public class ControladorLogin implements ActionListener {

    JIFLogin vistaLogin = new JIFLogin();
    UsuarioDAO modeloLogin = new UsuarioDAO();
    Usuario usuario = new Usuario();

    public ControladorLogin(JIFLogin vistaLogin, UsuarioDAO modeloLogin) {
        this.vistaLogin = vistaLogin;
        this.modeloLogin = modeloLogin;
        this.vistaLogin.btnIngresar.addActionListener(this);
    }

    public void InicializarLogin() {

    }

    public void actionPerformed(ActionEvent e) {

        String usuario_user = vistaLogin.txtUsuario.getText();
        String usuario_pass = String.valueOf(vistaLogin.txtPassword.getPassword());
        usuario = modeloLogin.verificarUsuario(usuario_user, usuario_pass);

        if (usuario == null) {
            JOptionPane.showMessageDialog(vistaLogin, "Usuario o contraseña incorrectos");

        } else if (usuario.getUsuario_rol().equals("admin")) {
            JIFAdmin vistaA = new JIFAdmin();
            ControladorAdmin controladorA = new ControladorAdmin(vistaA, modeloLogin);
            controladorA.inicializaAdmin(usuario.getUsuario_id(), usuario_user, usuario_pass);
            vistaA.setLocation(((jDesktopPane1.getSize()).width - (vistaA.getSize()).width) / 2, ((jDesktopPane1.getSize()).height - (vistaA.getSize()).height) / 2);
            MDI.jDesktopPane1.add(vistaA);
            vistaA.toFront();
            vistaLogin.setVisible(false);

            //CONTROL DE VENTANAS ACTIVAS
            MDI.controlVentanaLogin = false;

        } else if (usuario.getUsuario_rol().equals("master")) {
            JIFMaster vistaM = new JIFMaster();
            ControladorMaster controladorM = new ControladorMaster(vistaM, modeloLogin);
            controladorM.inicializaMaster(usuario.getUsuario_id(), usuario_user, usuario_pass);
            vistaM.setLocation(((jDesktopPane1.getSize()).width - (vistaM.getSize()).width) / 2, ((jDesktopPane1.getSize()).height - (vistaM.getSize()).height) / 2);
            MDI.jDesktopPane1.add(vistaM);
            vistaM.toFront();
            vistaLogin.setVisible(false);
            
            //CONTROL DE VENTANAS ACTIVAS
            MDI.controlVentanaLogin = false;

        } else if (usuario.getUsuario_rol().equals("empleado")) {
            JIFEmpleado vistaE = new JIFEmpleado();
            vistaE.setLocation(((jDesktopPane1.getSize()).width - (vistaE.getSize()).width) / 2, ((jDesktopPane1.getSize()).height - (vistaE.getSize()).height) / 2);
            MDI.jDesktopPane1.add(vistaE);
            vistaE.toFront();
            vistaLogin.setVisible(false);

            //CONTROL DE VENTANAS ACTIVAS
            MDI.controlVentanaLogin = false;
        }

    }

}
