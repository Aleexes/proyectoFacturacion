package Modelo;

import java.sql.Date;

/**
 *
 * @author alexc
 */
public class Compra {

    CompraDAO modeloCompra = new CompraDAO();
    int COMPRA_ID, COMPRA_NUMEROFACTURANOSDIERON;
    java.sql.Date COMPRA_FECHAREALIZACION;
    double COMPRA_MONTOTOTAL;

    public Compra(int COMPRA_NUMEROFACTURANOSDIERON, Date COMPRA_FECHAREALIZACION, double COMPRA_MONTOTOTAL) {
        this.COMPRA_NUMEROFACTURANOSDIERON = COMPRA_NUMEROFACTURANOSDIERON;
        this.COMPRA_FECHAREALIZACION = COMPRA_FECHAREALIZACION;
        this.COMPRA_MONTOTOTAL = COMPRA_MONTOTOTAL;
    }

    public CompraDAO getModeloCompra() {
        return modeloCompra;
    }

    public void setModeloCompra(CompraDAO modeloCompra) {
        this.modeloCompra = modeloCompra;
    }

    public int getCOMPRA_ID() {
        return COMPRA_ID;
    }

    public void setCOMPRA_ID(int COMPRA_ID) {
        this.COMPRA_ID = COMPRA_ID;
    }

    public int getCOMPRA_NUMEROFACTURANOSDIERON() {
        return COMPRA_NUMEROFACTURANOSDIERON;
    }

    public void setCOMPRA_NUMEROFACTURANOSDIERON(int COMPRA_NUMEROFACTURANOSDIERON) {
        this.COMPRA_NUMEROFACTURANOSDIERON = COMPRA_NUMEROFACTURANOSDIERON;
    }

    public double getCOMPRA_MONTOTOTAL() {
        return COMPRA_MONTOTOTAL;
    }

    public void setCOMPRA_MONTOTOTAL(double COMPRA_MONTOTOTAL) {
        this.COMPRA_MONTOTOTAL = COMPRA_MONTOTOTAL;
    }

    public Date getCOMPRA_FECHAREALIZACION() {
        return COMPRA_FECHAREALIZACION;
    }

    public void setCOMPRA_FECHAREALIZACION(Date COMPRA_FECHAREALIZACION) {
        this.COMPRA_FECHAREALIZACION = COMPRA_FECHAREALIZACION;
    }

}
