package Controlador;

import Modelo.Cliente;
import Modelo.ClienteDAO;
import Vista.JIFClientes;

/**
 *
 * @author alexc
 */
public class ControladorCliente {

    JIFClientes vistaC = new JIFClientes();
    ClienteDAO modeloCliente = new ClienteDAO();
    String CLIENTE_NOMBRE, CLIENTE_DOMICILIO, NEGOCIO_NIT, CLIENTE_NIT;
    Cliente clienteObtenido;

    public ControladorCliente(String CLIENTE_NOMBRE, String CLIENTE_DOMICILIO, String NEGOCIO_NIT, String CLIENTE_NIT) {
        this.CLIENTE_NOMBRE = CLIENTE_NOMBRE;
        this.CLIENTE_DOMICILIO = CLIENTE_DOMICILIO;
        this.NEGOCIO_NIT = NEGOCIO_NIT;
        this.CLIENTE_NIT = CLIENTE_NIT;
    }
    
    public void crearCliente(ControladorCliente cCli){
        clienteObtenido = new Cliente(cCli.CLIENTE_NIT, cCli.NEGOCIO_NIT, cCli.CLIENTE_NOMBRE, cCli.CLIENTE_DOMICILIO);
        modeloCliente.insertarCliente(clienteObtenido);
    }

}
