package Modelo;

import java.sql.Date;

/**
 *
 * @author alexc
 */
public class Transaccion {

    int TRANSACCION_CORRELATIVO;
    double TRANSACCION_MONTO;
    String TRANSACCION_SERIE, TRANSACCION_TIPODOCU, TRANSACCION_ESTADO;
    Date TRANSACCION_FECHA;

    public Transaccion(int TRANSACCION_CORRELATIVO, double TRANSACCION_MONTO, String TRANSACCION_SERIE, String TRANSACCION_TIPODOCU, String TRANSACCION_ESTADO, Date TRANSACCION_FECHA) {
        this.TRANSACCION_CORRELATIVO = TRANSACCION_CORRELATIVO;
        this.TRANSACCION_MONTO = TRANSACCION_MONTO;
        this.TRANSACCION_SERIE = TRANSACCION_SERIE;
        this.TRANSACCION_TIPODOCU = TRANSACCION_TIPODOCU;
        this.TRANSACCION_ESTADO = TRANSACCION_ESTADO;
        this.TRANSACCION_FECHA = TRANSACCION_FECHA;
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
