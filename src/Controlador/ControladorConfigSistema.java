package Controlador;

import Modelo.Sistema;
import Modelo.SistemaDAO;
import Vista.JIFSistema;
import java.sql.Date;

/**
 *
 * @author alexc
 */
public class ControladorConfigSistema {
    
    JIFSistema vistaSis = new JIFSistema();
    SistemaDAO modeloConfigSis = new SistemaDAO();
    String RESOLUCION_SISTEMA;
    java.sql.Date SISTEMA_FECHAAUTORESOL;
    int NUMERO_MAQUINA;
    Sistema configSistemaObtenida;
    
    public ControladorConfigSistema(String RESOLUCION_SISTEMA, java.sql.Date SISTEMA_FECHAAUTORESOL, int NUMERO_MAQUINA) {
        this.RESOLUCION_SISTEMA = RESOLUCION_SISTEMA;
        this.SISTEMA_FECHAAUTORESOL = SISTEMA_FECHAAUTORESOL;
        this.NUMERO_MAQUINA = NUMERO_MAQUINA;
    }
    
    public void configurarSistema(ControladorConfigSistema cS) {
        configSistemaObtenida = new Sistema(cS.RESOLUCION_SISTEMA, cS.SISTEMA_FECHAAUTORESOL, cS.NUMERO_MAQUINA);
        modeloConfigSis.insertarConfiguracionSistema(configSistemaObtenida);
    }
    
}
