package Controlador;

import Modelo.Compra;
import Modelo.CompraDAO;
import Vista.JIFCompras;
import java.sql.Date;

/**
 *
 * @author alexc
 */
public class ControladorCompra {

    JIFCompras vistaCom = new JIFCompras();
    CompraDAO modeloCompra = new CompraDAO();
    int COMPRA_ID, COMPRA_NUMEROFACTURANOSDIERON;
    double COMPRA_MONTOTOTAL;
    java.sql.Date COMPRA_FECHAREALIZACION;
    Compra compraObtenida;

    public ControladorCompra(int COMPRA_NUMEROFACTURANOSDIERON, double COMPRA_MONTOTOTAL, java.sql.Date COMPRA_FECHAREALIZACION) {
        this.COMPRA_NUMEROFACTURANOSDIERON = COMPRA_NUMEROFACTURANOSDIERON;
        this.COMPRA_MONTOTOTAL = COMPRA_MONTOTOTAL;
        this.COMPRA_FECHAREALIZACION = COMPRA_FECHAREALIZACION;
    }

    public void crearCompra(ControladorCompra cCom) {
        compraObtenida = new Compra(cCom.COMPRA_NUMEROFACTURANOSDIERON, cCom.COMPRA_FECHAREALIZACION, cCom.COMPRA_MONTOTOTAL);
        modeloCompra.insertarCompra(compraObtenida);
    }

}
