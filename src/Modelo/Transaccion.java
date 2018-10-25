package Modelo;

import java.sql.Date;

/**
 *
 * @author alexc
 */
public class Transaccion {

    int TRANSACCION_NUMERO, NOTADEBITO_ID, NOTACREDITO_ID, FACTURA_NUMERO, TRANSACCION_CORRELATIVO;
    double TRANSACCION_MONTO;
    String TRANSACCION_SERIE, TRANSACCION_TIPODOCU, TRANSACCION_ESTADO;
    Date TRANSACCION_FECHA;

    public Transaccion(int TRANSACCION_NUMERO, int NOTADEBITO_ID, int NOTACREDITO_ID, int FACTURA_NUMERO, int TRANSACCION_CORRELATIVO, double TRANSACCION_MONTO, String TRANSACCION_SERIE, String TRANSACCION_TIPODOCU, String TRANSACCION_ESTADO, Date TRANSACCION_FECHA) {
        this.TRANSACCION_NUMERO = TRANSACCION_NUMERO;
        this.NOTADEBITO_ID = NOTADEBITO_ID;
        this.NOTACREDITO_ID = NOTACREDITO_ID;
        this.FACTURA_NUMERO = FACTURA_NUMERO;
        this.TRANSACCION_CORRELATIVO = TRANSACCION_CORRELATIVO;
        this.TRANSACCION_MONTO = TRANSACCION_MONTO;
        this.TRANSACCION_SERIE = TRANSACCION_SERIE;
        this.TRANSACCION_TIPODOCU = TRANSACCION_TIPODOCU;
        this.TRANSACCION_ESTADO = TRANSACCION_ESTADO;
        this.TRANSACCION_FECHA = TRANSACCION_FECHA;
    }

    public int getTRANSACCION_NUMERO() {
        return TRANSACCION_NUMERO;
    }

    public void setTRANSACCION_NUMERO(int TRANSACCION_NUMERO) {
        this.TRANSACCION_NUMERO = TRANSACCION_NUMERO;
    }

    public int getNOTADEBITO_ID() {
        return NOTADEBITO_ID;
    }

    public void setNOTADEBITO_ID(int NOTADEBITO_ID) {
        this.NOTADEBITO_ID = NOTADEBITO_ID;
    }

    public int getNOTACREDITO_ID() {
        return NOTACREDITO_ID;
    }

    public void setNOTACREDITO_ID(int NOTACREDITO_ID) {
        this.NOTACREDITO_ID = NOTACREDITO_ID;
    }

    public int getFACTURA_NUMERO() {
        return FACTURA_NUMERO;
    }

    public void setFACTURA_NUMERO(int FACTURA_NUMERO) {
        this.FACTURA_NUMERO = FACTURA_NUMERO;
    }

    public int getTRANSACCION_CORRELATIVO() {
        return TRANSACCION_CORRELATIVO;
    }

    public void setTRANSACCION_CORRELATIVO(int TRANSACCION_CORRELATIVO) {
        this.TRANSACCION_CORRELATIVO = TRANSACCION_CORRELATIVO;
    }

    public double getTRANSACCION_MONTO() {
        return TRANSACCION_MONTO;
    }

    public void setTRANSACCION_MONTO(double TRANSACCION_MONTO) {
        this.TRANSACCION_MONTO = TRANSACCION_MONTO;
    }

    public String getTRANSACCION_SERIE() {
        return TRANSACCION_SERIE;
    }

    public void setTRANSACCION_SERIE(String TRANSACCION_SERIE) {
        this.TRANSACCION_SERIE = TRANSACCION_SERIE;
    }

    public String getTRANSACCION_TIPODOCU() {
        return TRANSACCION_TIPODOCU;
    }

    public void setTRANSACCION_TIPODOCU(String TRANSACCION_TIPODOCU) {
        this.TRANSACCION_TIPODOCU = TRANSACCION_TIPODOCU;
    }

    public String getTRANSACCION_ESTADO() {
        return TRANSACCION_ESTADO;
    }

    public void setTRANSACCION_ESTADO(String TRANSACCION_ESTADO) {
        this.TRANSACCION_ESTADO = TRANSACCION_ESTADO;
    }

    public Date getTRANSACCION_FECHA() {
        return TRANSACCION_FECHA;
    }

    public void setTRANSACCION_FECHA(Date TRANSACCION_FECHA) {
        this.TRANSACCION_FECHA = TRANSACCION_FECHA;
    }

}
