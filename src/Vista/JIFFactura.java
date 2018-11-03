package Vista;

import Controlador.ControladorCliente;
import Modelo.ClienteDAO;
import Modelo.Factura;
import Modelo.FacturaDAO;
import Modelo.InventarioDAO;
import Modelo.MarcaDAO;
import Modelo.NegocioDAO;
import Modelo.PresentacionDAO;
import Modelo.ProductoDAO;
import Modelo.ResolucionDAO;
import Modelo.SistemaDAO;
import Modelo.Transaccion;
import Modelo.TransaccionDAO;
import Modelo.UnidadDAO;
import Modelo.VentaDAO;
import com.mxrck.autocompleter.AutoCompleterCallback;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author alexc
 */
public class JIFFactura extends javax.swing.JInternalFrame {

    DefaultTableModel modelitoTablaCargandose;
    DefaultTableModel modeloTablaListaFACTURA;
    static public boolean controlVentanaFacturacion;
    private TextAutoCompleter acNIT;
    int backspace = 0;
    public static ArrayList<String> infoCliente = new ArrayList<String>();
    public static ArrayList<String> infoNegocio = new ArrayList<String>();
    public static ArrayList<String> infoSistema = new ArrayList<String>();
    public static ArrayList<String> infoResolucion = new ArrayList<String>();
    public static ArrayList<String> infoProducto = new ArrayList<String>();

    public JIFFactura() {
        initComponents();
        modelitoTablaCargandose = (DefaultTableModel) tablaProductosFacturados.getModel();
        modeloTablaListaFACTURA = (DefaultTableModel) tablaListaFactura.getModel();

        //PURAS CONFIGURACIONES VISUALES
        controlVentanaFacturacion = true;
        formatearTabla();
        formatearTablaFacturados();
        lblDenominacionSocial.setHorizontalAlignment(SwingConstants.CENTER);
        lblNombreComercialEmisor.setHorizontalAlignment(SwingConstants.CENTER);
        lblDireccionEmisor.setHorizontalAlignment(SwingConstants.CENTER);
        lblNumeroSerie.setHorizontalAlignment(SwingConstants.CENTER);
        lblNumAL.setHorizontalAlignment(SwingConstants.CENTER);
        lblNumDEL.setHorizontalAlignment(SwingConstants.CENTER);
        lblNumeroDeFactura.setHorizontalAlignment(SwingConstants.CENTER);
        lblNumeroMaquina.setHorizontalAlignment(SwingConstants.CENTER);
        lblNumTransaccion.setHorizontalAlignment(SwingConstants.CENTER);
        lblTotalCompra.setHorizontalAlignment(SwingConstants.CENTER);
        lblGraciasPorPreferirnos.setHorizontalAlignment(SwingConstants.CENTER);
        lblSujetoAPagos.setHorizontalAlignment(SwingConstants.CENTER);
        lblNumResoFactura.setHorizontalAlignment(SwingConstants.CENTER);
        panelFacturacion.setVisible(false);
        btnOKImprimir.setVisible(false);
        lblIDnoEncontrado.setVisible(false);
        lblCantidadSobrepasa.setVisible(false);
        bloquearComponentesParaCargarProductos();

        //CONFIGURACIONES INICIALES DEL BUSCADOR
        configurarBuscadorNit();

    }

    private void formatearTabla() {

        TableColumnModel columnasTablaFacturados = this.tablaProductosFacturados.getColumnModel();
        this.tablaProductosFacturados.setShowGrid(true);
        this.tablaProductosFacturados.setShowVerticalLines(true);
        this.tablaProductosFacturados.setShowHorizontalLines(true);

        columnasTablaFacturados.getColumn(0).setPreferredWidth(10);
        columnasTablaFacturados.getColumn(1).setPreferredWidth(20);
        columnasTablaFacturados.getColumn(2).setPreferredWidth(20);
        columnasTablaFacturados.getColumn(3).setPreferredWidth(20);
        columnasTablaFacturados.getColumn(4).setPreferredWidth(50);
        columnasTablaFacturados.getColumn(5).setPreferredWidth(20);
        columnasTablaFacturados.getColumn(6).setPreferredWidth(20);

        //CENTRAR EL HEADER DE LAS COLUMNAS
        DefaultTableCellRenderer headersTablaFacturados = (DefaultTableCellRenderer) this.tablaProductosFacturados.getTableHeader().getDefaultRenderer();
        headersTablaFacturados.setHorizontalAlignment(0);
        //CENTRAR LAS CELDAS
        DefaultTableCellRenderer celdasTablaFacturados = new DefaultTableCellRenderer();
        celdasTablaFacturados.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < 7; i++) {
            this.tablaProductosFacturados.getColumnModel().getColumn(i).setCellRenderer(celdasTablaFacturados);
        }
    }

    private void formatearTablaFacturados() {

        TableColumnModel columnasTablaDeFactura = this.tablaListaFactura.getColumnModel();
        this.tablaListaFactura.setShowGrid(true);
        this.tablaListaFactura.setShowVerticalLines(true);
        this.tablaListaFactura.setShowHorizontalLines(true);
        this.tablaListaFactura.setOpaque(true);
        ((DefaultTableCellRenderer) this.tablaListaFactura.getDefaultRenderer(Object.class)).setOpaque(false);
        columnasTablaDeFactura.getColumn(0).setPreferredWidth(200);
        columnasTablaDeFactura.getColumn(1).setPreferredWidth(50);
        columnasTablaDeFactura.getColumn(2).setPreferredWidth(50);
        columnasTablaDeFactura.getColumn(3).setPreferredWidth(60);

        //CENTRAR EL HEADER DE LAS COLUMNAS
        DefaultTableCellRenderer headersTablaDeFactura = (DefaultTableCellRenderer) this.tablaListaFactura.getTableHeader().getDefaultRenderer();
        headersTablaDeFactura.setHorizontalAlignment(0);
        //CENTRAR LAS CELDAS
        DefaultTableCellRenderer celdasTablaDeFactura = new DefaultTableCellRenderer();
        celdasTablaDeFactura.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < 4; i++) {
            this.tablaListaFactura.getColumnModel().getColumn(i).setCellRenderer(celdasTablaDeFactura);
        }

    }

    private void configurarBuscadorNit() {

        /*CONFIGURACIONES PARA LA LISTA/BUSCADOR* NOMBRE DE PREODUCTOS*/
        acNIT = new TextAutoCompleter(txtNit, new AutoCompleterCallback() {
            @Override
            public void callback(Object selectedItem) {
                infoCliente = null;
                ClienteDAO c = new ClienteDAO();
                infoCliente = c.mostrarInfoCliente(String.valueOf(selectedItem));
                txtNombreCliente.setText(infoCliente.get(0));
                txtDomicilio.setText(infoCliente.get(1));
            }
        });

        ClienteDAO cli = new ClienteDAO();
        cli.mostrarNitsDeClientes(acNIT);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDatos = new javax.swing.JPanel();
        lblCantidadSobrepasa = new javax.swing.JLabel();
        lblIDnoEncontrado = new javax.swing.JLabel();
        lblQ = new javax.swing.JLabel();
        lblMontoTOTAL = new javax.swing.JLabel();
        btnRemoverFila = new javax.swing.JButton();
        btnOKImprimir = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();
        btnAgregarProducto = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        tablaProductosFacturados = new javax.swing.JTable();
        btnGuardarCliente = new javax.swing.JButton();
        lblNit = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblDomicilio = new javax.swing.JLabel();
        txtNit = new javax.swing.JTextField();
        txtNombreCliente = new javax.swing.JTextField();
        txtDomicilio = new javax.swing.JTextField();
        lblCantidadProducto = new javax.swing.JLabel();
        txtCantidadProducto = new javax.swing.JTextField();
        lblIDproducto = new javax.swing.JLabel();
        txtIDproducto = new javax.swing.JTextField();
        panelFacturacion = new javax.swing.JPanel();
        lblNombreComercialEmisor = new javax.swing.JLabel();
        lblDenominacionSocial = new javax.swing.JLabel();
        lblDireccionEmisor = new javax.swing.JLabel();
        txtNitFacturacion = new javax.swing.JLabel();
        lblNitEMISOR = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblNumResoFactura = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblFechaResoFactura = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblNumeroSerie = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblNumDEL = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblNumAL = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblNumResoSistema = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblFechaResoSistema = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblNumSerieFactura = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblNumeroDeFactura = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblFechaEmisionFactura = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblNumeroMaquina = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblNumTransaccion = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblNombreCliente = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblNitCliente = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblDireccionCliente = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblSujetoAPagos = new javax.swing.JLabel();
        lblGraciasPorPreferirnos = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblTotalCompra = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaListaFactura = new javax.swing.JTable();
        lblFondo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Facturacion");
        setVisible(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        panelDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCantidadSobrepasa.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblCantidadSobrepasa.setForeground(new java.awt.Color(255, 51, 0));
        lblCantidadSobrepasa.setText("Cantidad sobrepasa existencias en inventario*");
        panelDatos.add(lblCantidadSobrepasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 320, -1));

        lblIDnoEncontrado.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblIDnoEncontrado.setForeground(new java.awt.Color(255, 51, 0));
        lblIDnoEncontrado.setText("ID de producto no registrado*");
        panelDatos.add(lblIDnoEncontrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 220, -1));

        lblQ.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblQ.setForeground(new java.awt.Color(255, 153, 0));
        lblQ.setText("Q.");
        panelDatos.add(lblQ, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 40, 40));

        lblMontoTOTAL.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblMontoTOTAL.setForeground(new java.awt.Color(255, 153, 0));
        lblMontoTOTAL.setText("0.00");
        panelDatos.add(lblMontoTOTAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 540, 220, 40));

        btnRemoverFila.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnQuitar.png"))); // NOI18N
        btnRemoverFila.setBorderPainted(false);
        btnRemoverFila.setContentAreaFilled(false);
        btnRemoverFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverFilaActionPerformed(evt);
            }
        });
        panelDatos.add(btnRemoverFila, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 380, 50, 30));

        btnOKImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnOK.png"))); // NOI18N
        btnOKImprimir.setBorderPainted(false);
        btnOKImprimir.setContentAreaFilled(false);
        btnOKImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKImprimirActionPerformed(evt);
            }
        });
        panelDatos.add(btnOKImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 540, 80, 50));

        btnOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnOK.png"))); // NOI18N
        btnOK.setBorderPainted(false);
        btnOK.setContentAreaFilled(false);
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });
        panelDatos.add(btnOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 540, 80, 50));

        btnAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnAgregarProducto.png"))); // NOI18N
        btnAgregarProducto.setBorderPainted(false);
        btnAgregarProducto.setContentAreaFilled(false);
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });
        panelDatos.add(btnAgregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 200, 50));

        tablaProductosFacturados.setBackground(new java.awt.Color(255, 204, 51));
        tablaProductosFacturados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "MARCA", "UNIDAD", "PRESENT.", "CANTIDAD", "PRECIO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProductosFacturados.getTableHeader().setReorderingAllowed(false);
        jScrollPane.setViewportView(tablaProductosFacturados);
        if (tablaProductosFacturados.getColumnModel().getColumnCount() > 0) {
            tablaProductosFacturados.getColumnModel().getColumn(0).setResizable(false);
            tablaProductosFacturados.getColumnModel().getColumn(1).setResizable(false);
            tablaProductosFacturados.getColumnModel().getColumn(2).setResizable(false);
            tablaProductosFacturados.getColumnModel().getColumn(3).setResizable(false);
            tablaProductosFacturados.getColumnModel().getColumn(4).setResizable(false);
            tablaProductosFacturados.getColumnModel().getColumn(5).setResizable(false);
            tablaProductosFacturados.getColumnModel().getColumn(6).setResizable(false);
        }

        panelDatos.add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 530, 160));

        btnGuardarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ButtonSaveCajero.png"))); // NOI18N
        btnGuardarCliente.setBorderPainted(false);
        btnGuardarCliente.setContentAreaFilled(false);
        btnGuardarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarClienteActionPerformed(evt);
            }
        });
        panelDatos.add(btnGuardarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 140, 50));

        lblNit.setFont(new java.awt.Font("Taurus", 0, 48)); // NOI18N
        lblNit.setForeground(new java.awt.Color(255, 153, 0));
        lblNit.setText("NIT:");
        panelDatos.add(lblNit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 50));

        lblNombre.setFont(new java.awt.Font("Taurus", 0, 36)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 153, 0));
        lblNombre.setText("NOMBRE:");
        panelDatos.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, 50));

        lblDomicilio.setFont(new java.awt.Font("Taurus", 0, 30)); // NOI18N
        lblDomicilio.setForeground(new java.awt.Color(255, 153, 0));
        lblDomicilio.setText("DOMICILIO:");
        panelDatos.add(lblDomicilio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 210, 50));

        txtNit.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        panelDatos.add(txtNit, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 360, 40));

        txtNombreCliente.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreClienteActionPerformed(evt);
            }
        });
        panelDatos.add(txtNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 360, 40));

        txtDomicilio.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        panelDatos.add(txtDomicilio, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 360, 40));

        lblCantidadProducto.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblCantidadProducto.setForeground(new java.awt.Color(255, 153, 0));
        lblCantidadProducto.setText("CANTIDAD:");
        panelDatos.add(lblCantidadProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 311, -1, -1));

        txtCantidadProducto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtCantidadProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadProductoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadProductoKeyTyped(evt);
            }
        });
        panelDatos.add(txtCantidadProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 190, 30));

        lblIDproducto.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblIDproducto.setForeground(new java.awt.Color(255, 153, 0));
        lblIDproducto.setText("ID:");
        panelDatos.add(lblIDproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 30, 30));

        txtIDproducto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        panelDatos.add(txtIDproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 280, 30));

        panelFacturacion.setBackground(new java.awt.Color(255, 255, 255));
        panelFacturacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombreComercialEmisor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNombreComercialEmisor.setText("?????");
        panelFacturacion.add(lblNombreComercialEmisor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, -1));

        lblDenominacionSocial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblDenominacionSocial.setText("??????");
        panelFacturacion.add(lblDenominacionSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 380, -1));

        lblDireccionEmisor.setText("??????");
        panelFacturacion.add(lblDireccionEmisor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 380, -1));

        txtNitFacturacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNitFacturacion.setText("NIT:");
        panelFacturacion.add(txtNitFacturacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 40, -1));

        lblNitEMISOR.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNitEMISOR.setText("??????????");
        panelFacturacion.add(lblNitEMISOR, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 80, -1));

        jLabel1.setText("Resolución");
        panelFacturacion.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        lblNumResoFactura.setText("????????????????");
        panelFacturacion.add(lblNumResoFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 80, -1));

        jLabel3.setText("del");
        panelFacturacion.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, -1, -1));

        lblFechaResoFactura.setText("???????????");
        panelFacturacion.add(lblFechaResoFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("serie");
        panelFacturacion.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));

        lblNumeroSerie.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNumeroSerie.setText("????");
        panelFacturacion.add(lblNumeroSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 30, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("de");
        panelFacturacion.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, -1, -1));

        lblNumDEL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNumDEL.setText("???");
        panelFacturacion.add(lblNumDEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 20, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("al");
        panelFacturacion.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, -1, -1));

        lblNumAL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNumAL.setText("??????");
        panelFacturacion.add(lblNumAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, -1, -1));

        jLabel7.setText("Res.");
        panelFacturacion.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        lblNumResoSistema.setText("??????????????????");
        panelFacturacion.add(lblNumResoSistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 110, -1));

        jLabel8.setText("de");
        panelFacturacion.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, -1, -1));

        lblFechaResoSistema.setText("??????????");
        panelFacturacion.add(lblFechaResoSistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("FACTURA SERIE");
        panelFacturacion.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        lblNumSerieFactura.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNumSerieFactura.setText("?");
        panelFacturacion.add(lblNumSerieFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("No.");
        panelFacturacion.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, -1, -1));

        lblNumeroDeFactura.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNumeroDeFactura.setText("??????????????");
        panelFacturacion.add(lblNumeroDeFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 110, -1));

        jLabel9.setText("FECHA DE EMISION:");
        panelFacturacion.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        lblFechaEmisionFactura.setText("???????????");
        panelFacturacion.add(lblFechaEmisionFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, -1, -1));

        jLabel12.setText("COMPUTADORA No.");
        panelFacturacion.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        lblNumeroMaquina.setText("?????");
        panelFacturacion.add(lblNumeroMaquina, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 40, -1));

        jLabel11.setText("TRANSACCION:");
        panelFacturacion.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        lblNumTransaccion.setText("?????????????");
        panelFacturacion.add(lblNumTransaccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 80, -1));

        jLabel14.setText("Nombre:");
        panelFacturacion.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        lblNombreCliente.setText("????????????????????????????????????");
        panelFacturacion.add(lblNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 230, -1));

        jLabel13.setText("Nit:");
        panelFacturacion.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        lblNitCliente.setText("????????????");
        panelFacturacion.add(lblNitCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 70, -1));

        jLabel15.setText("Dirección:");
        panelFacturacion.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        lblDireccionCliente.setText("????????????????????????????????????");
        panelFacturacion.add(lblDireccionCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 230, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Resolución Sistema");
        panelFacturacion.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, -1, -1));

        lblSujetoAPagos.setText("Sujeto a Pago trimestrales");
        panelFacturacion.add(lblSujetoAPagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 400, -1));

        lblGraciasPorPreferirnos.setText("GRACIAS POR PREFERIRNOS");
        panelFacturacion.add(lblGraciasPorPreferirnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 400, -1));

        jLabel16.setText("TOTAL");
        panelFacturacion.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, -1, -1));

        jLabel18.setText("Q.");
        panelFacturacion.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 460, -1, -1));

        lblTotalCompra.setText("0.00");
        panelFacturacion.add(lblTotalCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 460, 50, -1));

        tablaListaFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Cant", "Precio", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaListaFactura);
        if (tablaListaFactura.getColumnModel().getColumnCount() > 0) {
            tablaListaFactura.getColumnModel().getColumn(0).setResizable(false);
            tablaListaFactura.getColumnModel().getColumn(1).setResizable(false);
            tablaListaFactura.getColumnModel().getColumn(2).setResizable(false);
            tablaListaFactura.getColumnModel().getColumn(3).setResizable(false);
        }

        panelFacturacion.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 360, 120));

        panelDatos.add(panelFacturacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 400, 530));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/JIFFacturacion.png"))); // NOI18N
        panelDatos.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, 1141, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        controlVentanaFacturacion = false;
    }//GEN-LAST:event_formInternalFrameClosing

    private void txtNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreClienteActionPerformed

    private void btnGuardarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarClienteActionPerformed

        //0)VER QUE LOS CAMPOS NO ESTEN VACIOS
        //1)REGISTRAR CLIENTE SI NO SE ENCUENTRA REGISTRADO
        //2)CARGAR TODO EL ENCABEZADO AL PANEL
        if ((!txtNit.getText().equals("")) && (!txtNombreCliente.getText().equals("")) && (!txtDomicilio.getText().equals(""))) {

            ClienteDAO c = new ClienteDAO();
            if (!c.verSiExisteCliente(txtNit.getText())) {
                NegocioDAO negInfo = new NegocioDAO();
                infoNegocio = negInfo.mostrarInfoNegocio();
                ControladorCliente cCli = new ControladorCliente(txtNombreCliente.getText(), txtDomicilio.getText(), infoNegocio.get(0), txtNit.getText());
                cCli.crearCliente(cCli);
            }

            cargarEncabezado();
            desbloquearComponentesParaCargarProductos();

        } else {
            JOptionPane.showMessageDialog(null, "Se detectaron parametros vacíos, porfavor revisar");
        }


    }//GEN-LAST:event_btnGuardarClienteActionPerformed

    private void btnRemoverFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverFilaActionPerformed
        double resta = 0;
        String precio = "";
        String cantidad = "";
        int filaSeleccionada = 0;

        try {
            filaSeleccionada = tablaProductosFacturados.getSelectedRow();
            precio = (tablaProductosFacturados.getModel().getValueAt(filaSeleccionada, 5).toString());
            cantidad = (tablaProductosFacturados.getModel().getValueAt(filaSeleccionada, 6).toString());
            resta = (Double.parseDouble(lblMontoTOTAL.getText())) - (Double.parseDouble(precio) * Double.parseDouble(cantidad));
            lblMontoTOTAL.setText(String.valueOf(resta));
            modelitoTablaCargandose.removeRow(filaSeleccionada);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay filas seleccionadas");
        }

    }//GEN-LAST:event_btnRemoverFilaActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        if ((!txtIDproducto.getText().equals("")) && (!txtCantidadProducto.getText().equals(""))) {

            String nombreMarca, nombrePresentacion, nombreUnidad;
            double sumemos, precioVenta;

            MarcaDAO mr = new MarcaDAO();
            PresentacionDAO pr = new PresentacionDAO();
            UnidadDAO u = new UnidadDAO();
            VentaDAO v = new VentaDAO();

            ProductoDAO pd = new ProductoDAO();
            infoProducto = pd.mostrarInfoProducto(Integer.parseInt(txtIDproducto.getText()));
            if (infoProducto.isEmpty()) {
                lblIDnoEncontrado.setVisible(true);
                return;
            } else {
                lblIDnoEncontrado.setVisible(false);
            }
            
            InventarioDAO in = new InventarioDAO();
            if(Integer.parseInt(txtCantidadProducto.getText()) > in.obtenerCantidadDeInventario(Integer.parseInt(txtIDproducto.getText()))){
                lblCantidadSobrepasa.setVisible(true);
                return;
            }else{
                lblCantidadSobrepasa.setVisible(false);
            }
            

            nombreMarca = mr.mostrarNombreDeUnaMarca(Integer.parseInt(infoProducto.get(3)));
            nombrePresentacion = pr.mostrarNombreDeUnaPresentacion(Integer.parseInt(infoProducto.get(2)));
            nombreUnidad = u.mostrarNombreDeUnaUnidad(Integer.parseInt(infoProducto.get(1)));
            precioVenta = v.mostrarPrecioVentaProducto(Integer.parseInt(txtIDproducto.getText()));

            modelitoTablaCargandose.addRow(new Object[]{txtIDproducto.getText(), infoProducto.get(4), nombreMarca, nombreUnidad, nombrePresentacion, txtCantidadProducto.getText(), String.valueOf(precioVenta),});
            sumemos = Double.parseDouble(txtCantidadProducto.getText()) * precioVenta;
            sumemos = sumemos + Double.parseDouble(lblMontoTOTAL.getText());
            lblMontoTOTAL.setText(String.valueOf(sumemos));

        } else {
            JOptionPane.showMessageDialog(null, "Los parametros para agregar el producto estan vacíos");
        }
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void txtCantidadProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadProductoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            backspace = 1;
            return;
        }
    }//GEN-LAST:event_txtCantidadProductoKeyPressed

    private void txtCantidadProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadProductoKeyTyped
        if (backspace == 1) {
            backspace = 0;
            return;
        }
        char validar = evt.getKeyChar();
        if (!Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
        }
    }//GEN-LAST:event_txtCantidadProductoKeyTyped

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed

        int a = modeloTablaListaFACTURA.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            modeloTablaListaFACTURA.removeRow(i);
        }

        int j = modelitoTablaCargandose.getRowCount();
        for (int i = 0; i < j; i++) {
            modeloTablaListaFACTURA.addRow(new Object[]{modelitoTablaCargandose.getValueAt(i, 3).toString() + " " + modelitoTablaCargandose.getValueAt(i, 4).toString() + " " + modelitoTablaCargandose.getValueAt(i, 1).toString() + " " + modelitoTablaCargandose.getValueAt(i, 2).toString(),
                modelitoTablaCargandose.getValueAt(i, 5),
                modelitoTablaCargandose.getValueAt(i, 6),
                Double.parseDouble(modelitoTablaCargandose.getValueAt(i, 5).toString()) * Double.parseDouble(modelitoTablaCargandose.getValueAt(i, 6).toString()),});
        }

        lblTotalCompra.setText(lblMontoTOTAL.getText());

    }//GEN-LAST:event_btnOKActionPerformed

    public void imprimirFactura() {

        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setJobName(" Print Component ");

        pj.setPrintable(new Printable() {
            public int print(Graphics pg, PageFormat pf, int pageNum) {
                if (pageNum > 0) {
                    return Printable.NO_SUCH_PAGE;
                }

                Graphics2D g2 = (Graphics2D) pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                panelFacturacion.paint(g2);
                return Printable.PAGE_EXISTS;
            }
        });
        if (pj.printDialog() == false) {
            return;
        }

        try {
            pj.print();
        } catch (PrinterException ex) {
            // handle exception
        }
    }


    private void btnOKImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKImprimirActionPerformed

        if(modeloTablaListaFACTURA.getRowCount() == 0){
            JOptionPane.showMessageDialog(null, "No hay productos agregados");
            return;
        }
        
        
        
        TransaccionDAO trans = new TransaccionDAO();
        Transaccion t = new Transaccion(Integer.parseInt(lblNumeroDeFactura.getText()), Double.parseDouble(lblTotalCompra.getText()), lblNumSerieFactura.getText(), "Factura", "Emitido", Date.valueOf(lblFechaEmisionFactura.getText()));
        Factura f = new Factura(Integer.parseInt(lblNumeroDeFactura.getText()), Integer.parseInt(lblNumTransaccion.getText()), lblNitEMISOR.getText(), lblNitCliente.getText(), lblNumResoFactura.getText());

        trans.transaccionVentaFactura(t, f, modelitoTablaCargandose);

        imprimirFactura();
        bloquearFacturacion();

        if ((Integer.parseInt(lblNumeroDeFactura.getText()) + 1) > Integer.parseInt(lblNumAL.getText())) {
            JOptionPane.showMessageDialog(null, "Se ha llegado al limite de facturas posibles para la resolucion " + lblNumResoFactura.getText() + "\n El sistema de facturación queda detenido");
            txtDomicilio.setEnabled(false);
            txtNombreCliente.setEnabled(false);
            txtNit.setEnabled(false);
            btnGuardarCliente.setEnabled(false);
            lblDomicilio.setEnabled(false);
            lblNombre.setEnabled(false);
            lblNit.setEnabled(false);
            ResolucionDAO r = new ResolucionDAO();
            r.desactivarResolucion();
            return;
        }


    }//GEN-LAST:event_btnOKImprimirActionPerformed

    private void cargarEncabezado() {

        NegocioDAO negInfo = new NegocioDAO();
        infoNegocio = negInfo.mostrarInfoNegocio();
        SistemaDAO sisInfo = new SistemaDAO();
        infoSistema = sisInfo.mostrarInfoSistema();
        ResolucionDAO resInfo = new ResolucionDAO();
        infoResolucion = resInfo.mostrarResolucionActivaFACTURA();
        FacturaDAO facInfo = new FacturaDAO();
        int numFactura = facInfo.mostrarNumeroUltimaFacturaIngresadaParaEsaReslucion() + 1;

        TransaccionDAO transInfo = new TransaccionDAO();
        int numTransaccion = transInfo.mostrarNumeroUltimaTransaccion() + 1;

        //INFORMACION GENERAL DEL NEGOCIO Y DEL SISTEMA
        lblNombreComercialEmisor.setText(infoNegocio.get(1));
        lblDenominacionSocial.setText(infoNegocio.get(2));
        lblDireccionEmisor.setText(infoNegocio.get(3));
        lblNitEMISOR.setText(infoNegocio.get(0));
        lblNumResoSistema.setText(infoSistema.get(0));
        lblNumeroMaquina.setText(infoSistema.get(1));
        lblFechaResoSistema.setText(infoSistema.get(2));
        java.util.Date fechaActual = new java.util.Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        formateador.format(fechaActual);
        java.sql.Date sqlFechaActual = new java.sql.Date(fechaActual.getTime());
        lblFechaEmisionFactura.setText(String.valueOf(sqlFechaActual));

        //INFORMACION DEL CLIENTE
        lblNombreCliente.setText(txtNombreCliente.getText());
        lblDireccionCliente.setText(txtDomicilio.getText());
        lblNitCliente.setText(txtNit.getText());

        //INFORMACION DE LA RESOLUCION
        lblNumResoFactura.setText(infoResolucion.get(0));
        lblFechaResoFactura.setText(infoResolucion.get(5));
        lblNumeroSerie.setText(infoResolucion.get(4));
        lblNumDEL.setText(infoResolucion.get(2));
        lblNumAL.setText(infoResolucion.get(3));
        lblNumSerieFactura.setText(infoResolucion.get(4));

        //OBTENER EL NUMERO DE FACTURA QUE TOCA
        if (String.valueOf(facInfo.mostrarNumeroUltimaFacturaIngresadaParaEsaReslucion()).equals("0")) {
            numFactura = Integer.parseInt(lblNumDEL.getText());
        }
        lblNumeroDeFactura.setText(String.valueOf(numFactura));

        //OBTENER EL NUMERO DE TRANSACCION QUE TOCA
        lblNumTransaccion.setText(String.valueOf(numTransaccion));

        panelFacturacion.setVisible(true);
        btnOKImprimir.setVisible(true);
    }

    private void bloquearFacturacion() {

        int a = modeloTablaListaFACTURA.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            modeloTablaListaFACTURA.removeRow(i);
        }

        int b = modelitoTablaCargandose.getRowCount() - 1;
        for (int i = b; i >= 0; i--) {
            modelitoTablaCargandose.removeRow(i);
        }

        bloquearComponentesParaCargarProductos();
        panelFacturacion.setVisible(false);
        btnOKImprimir.setVisible(false);
        lblMontoTOTAL.setText("0.00");
        txtCantidadProducto.setText("");
        txtIDproducto.setText("");
    }

    private void bloquearComponentesParaCargarProductos() {
        txtIDproducto.setEnabled(false);
        txtCantidadProducto.setEnabled(false);
        lblIDproducto.setEnabled(false);
        lblCantidadProducto.setEnabled(false);
        btnAgregarProducto.setEnabled(false);
        lblQ.setEnabled(false);
        lblMontoTOTAL.setEnabled(false);
        btnRemoverFila.setEnabled(false);
        btnOK.setEnabled(false);
        tablaProductosFacturados.setEnabled(false);
    }

    private void desbloquearComponentesParaCargarProductos() {
        txtIDproducto.setEnabled(true);
        txtCantidadProducto.setEnabled(true);
        lblIDproducto.setEnabled(true);
        lblCantidadProducto.setEnabled(true);
        btnAgregarProducto.setEnabled(true);
        lblQ.setEnabled(true);
        lblMontoTOTAL.setEnabled(true);
        btnRemoverFila.setEnabled(true);
        btnOK.setEnabled(true);
        tablaProductosFacturados.setEnabled(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnGuardarCliente;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnOKImprimir;
    private javax.swing.JButton btnRemoverFila;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblCantidadProducto;
    private javax.swing.JLabel lblCantidadSobrepasa;
    private javax.swing.JLabel lblDenominacionSocial;
    private javax.swing.JLabel lblDireccionCliente;
    private javax.swing.JLabel lblDireccionEmisor;
    public javax.swing.JLabel lblDomicilio;
    private javax.swing.JLabel lblFechaEmisionFactura;
    private javax.swing.JLabel lblFechaResoFactura;
    private javax.swing.JLabel lblFechaResoSistema;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblGraciasPorPreferirnos;
    private javax.swing.JLabel lblIDnoEncontrado;
    public javax.swing.JLabel lblIDproducto;
    private javax.swing.JLabel lblMontoTOTAL;
    public javax.swing.JLabel lblNit;
    private javax.swing.JLabel lblNitCliente;
    private javax.swing.JLabel lblNitEMISOR;
    public javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreCliente;
    private javax.swing.JLabel lblNombreComercialEmisor;
    private javax.swing.JLabel lblNumAL;
    private javax.swing.JLabel lblNumDEL;
    private javax.swing.JLabel lblNumResoFactura;
    private javax.swing.JLabel lblNumResoSistema;
    private javax.swing.JLabel lblNumSerieFactura;
    private javax.swing.JLabel lblNumTransaccion;
    private javax.swing.JLabel lblNumeroDeFactura;
    private javax.swing.JLabel lblNumeroMaquina;
    private javax.swing.JLabel lblNumeroSerie;
    private javax.swing.JLabel lblQ;
    private javax.swing.JLabel lblSujetoAPagos;
    private javax.swing.JLabel lblTotalCompra;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelFacturacion;
    private javax.swing.JTable tablaListaFactura;
    private javax.swing.JTable tablaProductosFacturados;
    private javax.swing.JTextField txtCantidadProducto;
    private javax.swing.JTextField txtDomicilio;
    private javax.swing.JTextField txtIDproducto;
    private javax.swing.JTextField txtNit;
    private javax.swing.JLabel txtNitFacturacion;
    private javax.swing.JTextField txtNombreCliente;
    // End of variables declaration//GEN-END:variables
}
