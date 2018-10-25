package Modelo;

import java.sql.Date;

/**
 *
 * @author alexc
 */
public class Sistema {
     
   String RESOLUCION_SISTEMA;
   Date SISTEMA_FECHAAUTORESOL;
   int NUMERO_MAQUINA;

    public Sistema(String RESOLUCION_SISTEMA, Date SISTEMA_FECHAAUTORESOL, int NUMERO_MAQUINA) {
        this.RESOLUCION_SISTEMA = RESOLUCION_SISTEMA;
        this.SISTEMA_FECHAAUTORESOL = SISTEMA_FECHAAUTORESOL;
        this.NUMERO_MAQUINA = NUMERO_MAQUINA;
    }
   
    public String getRESOLUCION_SISTEMA() {
        return RESOLUCION_SISTEMA;
    }

    public void setRESOLUCION_SISTEMA(String RESOLUCION_SISTEMA) {
        this.RESOLUCION_SISTEMA = RESOLUCION_SISTEMA;
    }

    public Date getSISTEMA_FECHAAUTORESOL() {
        return SISTEMA_FECHAAUTORESOL;
    }

    public void setSISTEMA_FECHAAUTORESOL(Date SISTEMA_FECHAAUTORESOL) {
        this.SISTEMA_FECHAAUTORESOL = SISTEMA_FECHAAUTORESOL;
    }

    public int getNUMERO_MAQUINA() {
        return NUMERO_MAQUINA;
    }

    public void setNUMERO_MAQUINA(int NUMERO_MAQUINA) {
        this.NUMERO_MAQUINA = NUMERO_MAQUINA;
    }
   
   
    
}
