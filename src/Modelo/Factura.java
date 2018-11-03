package Modelo;

/**
 *
 * @author alexc
 */
public class Factura {

    int FACTURA_NUM, TRANSACCION_NUMERO;
    String NEGOCIO_NIT, CLIENTE_NIT, RESOLUCION_NUMERO;

    public Factura(int FACTURA_NUM, int TRANSACCION_NUMERO, String NEGOCIO_NIT, String CLIENTE_NIT, String RESOLUCION_NUMERO) {
        this.FACTURA_NUM = FACTURA_NUM;
        this.TRANSACCION_NUMERO = TRANSACCION_NUMERO;
        this.NEGOCIO_NIT = NEGOCIO_NIT;
        this.CLIENTE_NIT = CLIENTE_NIT;
        this.RESOLUCION_NUMERO = RESOLUCION_NUMERO;
    }

    public int getFACTURA_NUM() {
        return FACTURA_NUM;
    }

    public void setFACTURA_NUM(int FACTURA_NUM) {
        this.FACTURA_NUM = FACTURA_NUM;
    }

    public int getTRANSACCION_NUMERO() {
        return TRANSACCION_NUMERO;
    }

    public void setTRANSACCION_NUMERO(int TRANSACCION_NUMERO) {
        this.TRANSACCION_NUMERO = TRANSACCION_NUMERO;
    }

    public String getNEGOCIO_NIT() {
        return NEGOCIO_NIT;
    }

    public void setNEGOCIO_NIT(String NEGOCIO_NIT) {
        this.NEGOCIO_NIT = NEGOCIO_NIT;
    }

    public String getCLIENTE_NIT() {
        return CLIENTE_NIT;
    }

    public void setCLIENTE_NIT(String CLIENTE_NIT) {
        this.CLIENTE_NIT = CLIENTE_NIT;
    }

    public String getRESOLUCION_NUMERO() {
        return RESOLUCION_NUMERO;
    }

    public void setRESOLUCION_NUMERO(String RESOLUCION_NUMERO) {
        this.RESOLUCION_NUMERO = RESOLUCION_NUMERO;
    }

}
