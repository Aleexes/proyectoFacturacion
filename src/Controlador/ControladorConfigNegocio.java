package Controlador;

import Modelo.Negocio;
import Modelo.NegocioDAO;
import Vista.JIFNegocio;

/**
 *
 * @author alexc
 */
public class ControladorConfigNegocio {

    JIFNegocio vistaNeg = new JIFNegocio();
    NegocioDAO modeloConfigNeg = new NegocioDAO();
    String negocio_nit;
    String negocio_nombre;
    String negocio_nombreSocial;
    String negocio_direccion;
    Negocio configNegocioObtenida;

    public ControladorConfigNegocio(String negocio_nit, String negocio_nombre, String negocio_nombreSocial, String negocio_direccion) {
        this.negocio_nit = negocio_nit;
        this.negocio_nombre = negocio_nombre;
        this.negocio_nombreSocial = negocio_nombreSocial;
        this.negocio_direccion = negocio_direccion;
    }

    public void configurarSistema(ControladorConfigNegocio cN) {
        configNegocioObtenida = new Negocio(cN.negocio_nit, cN.negocio_nombre, cN.negocio_nombreSocial, cN.negocio_direccion);
        modeloConfigNeg.insertarConfiguracionSistema(configNegocioObtenida);
    }

}
