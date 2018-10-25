package Modelo;

import java.sql.Date;

public class Negocio {

    String negocio_nit;
    String negocio_nombre;
    String negocio_nombreSocial;
    String negocio_direccion;
    
    public Negocio(String negocio_nit, String negocio_nombre, String negocio_nombreSocial, String negocio_direccion) {
        this.negocio_nit = negocio_nit;
        this.negocio_nombre = negocio_nombre;
        this.negocio_nombreSocial = negocio_nombreSocial;
        this.negocio_direccion = negocio_direccion;
    }

    public String getNegocio_nit() {
        return negocio_nit;
    }

    public void setNegocio_nit(String negocio_nit) {
        this.negocio_nit = negocio_nit;
    }

    public String getNegocio_nombre() {
        return negocio_nombre;
    }

    public void setNegocio_nombre(String negocio_nombre) {
        this.negocio_nombre = negocio_nombre;
    }

    public String getNegocio_nombreSocial() {
        return negocio_nombreSocial;
    }

    public void setNegocio_nombreSocial(String negocio_nombreSocial) {
        this.negocio_nombreSocial = negocio_nombreSocial;
    }
    
    public String getNegocio_direccion() {
        return negocio_direccion;
    }

    public void setNegocio_direccion(String negocio_direccion) {
        this.negocio_direccion = negocio_direccion;
    }

}
