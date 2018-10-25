package Modelo;


public class Usuario {

    int usuario_id;
    String negocio_nit; //FK para tabla negocio
    String usuario_rol; //master,admin,empleado
    String usuario_user;
    String usuario_pass;

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getNegocio_nit() {
        return negocio_nit;
    }

    public void setNegocio_nit(String negocio_nit) {
        this.negocio_nit = negocio_nit;
    }
    
    public String getUsuario_rol() {
        return usuario_rol;
    }

    public void setUsuario_rol(String usuario_rol) {
        this.usuario_rol = usuario_rol;
    }

    public String getUsuario_user() {
        return usuario_user;
    }

    public void setUsuario_user(String usuario_user) {
        this.usuario_user = usuario_user;
    }

    public String getUsuario_pass() {
        return usuario_pass;
    }

    public void setUsuario_pass(String usuario_pass) {
        this.usuario_pass = usuario_pass;
    }
    
    
}
