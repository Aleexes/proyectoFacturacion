package Modelo;


public class Cliente {
    
    String cliente_nit;
    String negocio_nit; //FK para tabla negocio
    String cliente_nombre;
    String cliente_domicilio;

    public Cliente(String cliente_nit, String negocio_nit, String cliente_nombre, String cliente_domicilio) {
        this.cliente_nit = cliente_nit;
        this.negocio_nit = negocio_nit;
        this.cliente_nombre = cliente_nombre;
        this.cliente_domicilio = cliente_domicilio;
    }

    public String getCliente_nit() {
        return cliente_nit;
    }

    public void setCliente_nit(String cliente_nit) {
        this.cliente_nit = cliente_nit;
    }

    public String getNegocio_nit() {
        return negocio_nit;
    }

    public void setNegocio_nit(String negocio_nit) {
        this.negocio_nit = negocio_nit;
    }

    public String getCliente_nombre() {
        return cliente_nombre;
    }

    public void setCliente_nombre(String cliente_nombre) {
        this.cliente_nombre = cliente_nombre;
    }

    public String getCliente_domicilio() {
        return cliente_domicilio;
    }

    public void setCliente_domicilio(String cliente_domicilio) {
        this.cliente_domicilio = cliente_domicilio;
    }
    
    
}
