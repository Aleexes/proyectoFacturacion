package Modelo;

import java.sql.Date;

/**
 *
 * @author alexc
 */
public class Resolucion {
    
    String RESOLUCION_NUMERO, RESOLUCION_SERIE, RESOLUCION_TIPODOC;
    int RESOLUCION_NUMEROINICIAL, RESOLUCION_NUMEROFINAL;
    Date RESOLUCION_FECHAAUTORIZACION, RESOLUCION_FECHAINGRESO;

    public Resolucion(String RESOLUCION_NUMERO, String RESOLUCION_SERIE, String RESOLUCION_TIPODOC, int RESOLUCION_NUMEROINICIAL, int RESOLUCION_NUMEROFINAL, Date RESOLUCION_FECHAAUTORIZACION, Date RESOLUCION_FECHAINGRESO) {
        this.RESOLUCION_NUMERO = RESOLUCION_NUMERO;
        this.RESOLUCION_SERIE = RESOLUCION_SERIE;
        this.RESOLUCION_TIPODOC = RESOLUCION_TIPODOC;
        this.RESOLUCION_NUMEROINICIAL = RESOLUCION_NUMEROINICIAL;
        this.RESOLUCION_NUMEROFINAL = RESOLUCION_NUMEROFINAL;
        this.RESOLUCION_FECHAAUTORIZACION = RESOLUCION_FECHAAUTORIZACION;
        this.RESOLUCION_FECHAINGRESO = RESOLUCION_FECHAINGRESO;
    }

    public String getRESOLUCION_NUMERO() {
        return RESOLUCION_NUMERO;
    }

    public void setRESOLUCION_NUMERO(String RESOLUCION_NUMERO) {
        this.RESOLUCION_NUMERO = RESOLUCION_NUMERO;
    }

    public String getRESOLUCION_SERIE() {
        return RESOLUCION_SERIE;
    }

    public void setRESOLUCION_SERIE(String RESOLUCION_SERIE) {
        this.RESOLUCION_SERIE = RESOLUCION_SERIE;
    }

    public String getRESOLUCION_TIPODOC() {
        return RESOLUCION_TIPODOC;
    }

    public void setRESOLUCION_TIPODOC(String RESOLUCION_TIPODOC) {
        this.RESOLUCION_TIPODOC = RESOLUCION_TIPODOC;
    }

    public int getRESOLUCION_NUMEROINICIAL() {
        return RESOLUCION_NUMEROINICIAL;
    }

    public void setRESOLUCION_NUMEROINICIAL(int RESOLUCION_NUMEROINICIAL) {
        this.RESOLUCION_NUMEROINICIAL = RESOLUCION_NUMEROINICIAL;
    }

    public int getRESOLUCION_NUMEROFINAL() {
        return RESOLUCION_NUMEROFINAL;
    }

    public void setRESOLUCION_NUMEROFINAL(int RESOLUCION_NUMEROFINAL) {
        this.RESOLUCION_NUMEROFINAL = RESOLUCION_NUMEROFINAL;
    }

    public Date getRESOLUCION_FECHAAUTORIZACION() {
        return RESOLUCION_FECHAAUTORIZACION;
    }

    public void setRESOLUCION_FECHAAUTORIZACION(Date RESOLUCION_FECHAAUTORIZACION) {
        this.RESOLUCION_FECHAAUTORIZACION = RESOLUCION_FECHAAUTORIZACION;
    }

    public Date getRESOLUCION_FECHAINGRESO() {
        return RESOLUCION_FECHAINGRESO;
    }

    public void setRESOLUCION_FECHAINGRESO(Date RESOLUCION_FECHAINGRESO) {
        this.RESOLUCION_FECHAINGRESO = RESOLUCION_FECHAINGRESO;
    }
  
}
