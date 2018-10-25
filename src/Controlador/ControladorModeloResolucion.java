package Controlador;

import Modelo.Resolucion;
import Modelo.ResolucionDAO;
import Vista.JIFModeloResolucion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

/**
 *
 * @author alexc
 */
public class ControladorModeloResolucion{
     
    JIFModeloResolucion vistaMR = new JIFModeloResolucion();
    ResolucionDAO modeloResolucion = new ResolucionDAO();
    String RESOLUCION_NUMERO, RESOLUCION_SERIE, RESOLUCION_TIPODOC;
    int RESOLUCION_NUMEROINICIAL, RESOLUCION_NUMEROFINAL;
    java.sql.Date RESOLUCION_FECHAAUTORIZACION, RESOLUCION_FECHAINGRESO;
    Resolucion resolucionObtenida;

    public ControladorModeloResolucion(String RESOLUCION_NUMERO, String RESOLUCION_SERIE, String RESOLUCION_TIPODOC, int RESOLUCION_NUMEROINICIAL, int RESOLUCION_NUMEROFINAL, java.sql.Date RESOLUCION_FECHAAUTORIZACION, java.sql.Date RESOLUCION_FECHAINGRESO) {
        this.RESOLUCION_NUMERO = RESOLUCION_NUMERO;
        this.RESOLUCION_SERIE = RESOLUCION_SERIE;
        this.RESOLUCION_TIPODOC = RESOLUCION_TIPODOC;
        this.RESOLUCION_NUMEROINICIAL = RESOLUCION_NUMEROINICIAL;
        this.RESOLUCION_NUMEROFINAL = RESOLUCION_NUMEROFINAL;
        this.RESOLUCION_FECHAAUTORIZACION = RESOLUCION_FECHAAUTORIZACION;
        this.RESOLUCION_FECHAINGRESO = RESOLUCION_FECHAINGRESO;
    }

    public void crearModeloResolucion(ControladorModeloResolucion cMR){
        resolucionObtenida = new Resolucion(cMR.RESOLUCION_NUMERO,cMR.RESOLUCION_SERIE,cMR.RESOLUCION_TIPODOC,cMR.RESOLUCION_NUMEROINICIAL,cMR.RESOLUCION_NUMEROFINAL,cMR.RESOLUCION_FECHAAUTORIZACION,cMR.RESOLUCION_FECHAINGRESO);
        modeloResolucion.insertarModeloResolucion(resolucionObtenida);
    }
}
