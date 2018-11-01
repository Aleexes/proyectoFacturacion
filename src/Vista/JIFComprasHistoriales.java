package Vista;

import Modelo.CompraDAO;
import Modelo.DetalleCompraDAO;
import Modelo.MarcaDAO;
import Modelo.PresentacionDAO;
import Modelo.ProductoDAO;
import Modelo.UnidadDAO;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author alexc
 */
public class JIFComprasHistoriales extends javax.swing.JInternalFrame {

    int backspace = 0;
    static public boolean controlVentanaComprasHistoriales;

    public JIFComprasHistoriales() {
        initComponents();
        controlVentanaComprasHistoriales = true;
        formatearTablaCompras();
        formatearTablaDetalleCompra();

    }

    private void formatearTablaCompras() {
        TableColumnModel columnasCompras = this.tablaCompras.getColumnModel();
        this.tablaCompras.setShowGrid(true);
        this.tablaCompras.setShowVerticalLines(true);
        this.tablaCompras.setShowHorizontalLines(true);

        columnasCompras.getColumn(0).setPreferredWidth(40);
        columnasCompras.getColumn(1).setPreferredWidth(80);
        columnasCompras.getColumn(2).setPreferredWidth(40);
        columnasCompras.getColumn(3).setPreferredWidth(40);

        //CENTRAR EL HEADER DE LAS COLUMNAS
        DefaultTableCellRenderer headersCompras = (DefaultTableCellRenderer) this.tablaCompras.getTableHeader().getDefaultRenderer();
        headersCompras.setHorizontalAlignment(0);
        //CENTRAR LAS CELDAS
        DefaultTableCellRenderer celdasCompras = new DefaultTableCellRenderer();
        celdasCompras.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < 4; i++) {
            this.tablaCompras.getColumnModel().getColumn(i).setCellRenderer(celdasCompras);
        }
    }

    private void formatearTablaDetalleCompra() {
        TableColumnModel columnasDetalle = this.tablaDetalleCompra.getColumnModel();
        this.tablaDetalleCompra.setShowGrid(true);
        this.tablaDetalleCompra.setShowVerticalLines(true);
        this.tablaDetalleCompra.setShowHorizontalLines(true);

        columnasDetalle.getColumn(0).setPreferredWidth(40);
        columnasDetalle.getColumn(1).setPreferredWidth(80);
        columnasDetalle.getColumn(2).setPreferredWidth(80);
        columnasDetalle.getColumn(3).setPreferredWidth(80);
        columnasDetalle.getColumn(4).setPreferredWidth(80);
        columnasDetalle.getColumn(5).setPreferredWidth(80);
        columnasDetalle.getColumn(6).setPreferredWidth(80);

        //CENTRAR EL HEADER DE LAS COLUMNAS
        DefaultTableCellRenderer headersDetalle = (DefaultTableCellRenderer) this.tablaDetalleCompra.getTableHeader().getDefaultRenderer();
        headersDetalle.setHorizontalAlignment(0);
        //CENTRAR LAS CELDAS
        DefaultTableCellRenderer celdasDetalle = new DefaultTableCellRenderer();
        celdasDetalle.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < 7; i++) {
            this.tablaDetalleCompra.getColumnModel().getColumn(i).setCellRenderer(celdasDetalle);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCargarDetalleCompra = new javax.swing.JButton();
        txtIDcompra = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCompras = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaDetalleCompra = new javax.swing.JTable();
        calendarioDesde = new com.toedter.calendar.JCalendar();
        calendarioHasta = new com.toedter.calendar.JCalendar();
        btnCargarFechas = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Historial de compras");
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

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCargarDetalleCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnFiltrar.png"))); // NOI18N
        btnCargarDetalleCompra.setBorderPainted(false);
        btnCargarDetalleCompra.setContentAreaFilled(false);
        btnCargarDetalleCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarDetalleCompraActionPerformed(evt);
            }
        });
        jPanel1.add(btnCargarDetalleCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 440, 150, 50));

        txtIDcompra.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        txtIDcompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIDcompraKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDcompraKeyTyped(evt);
            }
        });
        jPanel1.add(txtIDcompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 180, 60));

        jLabel6.setFont(new java.awt.Font("Toonish", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 0));
        jLabel6.setText("ID COMPRA REGISTRADA:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 420, 60));

        jLabel5.setFont(new java.awt.Font("Toonish", 1, 32)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("DESDE:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 110, -1));

        tablaCompras.setBackground(new java.awt.Color(255, 255, 153));
        tablaCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID COMPRA", "#FACTURA", "FECHA", "MONTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCompras.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaCompras);
        if (tablaCompras.getColumnModel().getColumnCount() > 0) {
            tablaCompras.getColumnModel().getColumn(0).setResizable(false);
            tablaCompras.getColumnModel().getColumn(0).setHeaderValue("ID Compra");
            tablaCompras.getColumnModel().getColumn(1).setResizable(false);
            tablaCompras.getColumnModel().getColumn(2).setResizable(false);
            tablaCompras.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 30, 380, 260));

        tablaDetalleCompra.setBackground(new java.awt.Color(255, 255, 153));
        tablaDetalleCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Marca", "Presentacion", "Unidad", "Precio compra", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaDetalleCompra.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tablaDetalleCompra);
        if (tablaDetalleCompra.getColumnModel().getColumnCount() > 0) {
            tablaDetalleCompra.getColumnModel().getColumn(0).setResizable(false);
            tablaDetalleCompra.getColumnModel().getColumn(1).setResizable(false);
            tablaDetalleCompra.getColumnModel().getColumn(2).setResizable(false);
            tablaDetalleCompra.getColumnModel().getColumn(3).setResizable(false);
            tablaDetalleCompra.getColumnModel().getColumn(4).setResizable(false);
            tablaDetalleCompra.getColumnModel().getColumn(5).setResizable(false);
            tablaDetalleCompra.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 640, 230));

        calendarioDesde.setBackground(new java.awt.Color(255, 255, 0));
        calendarioDesde.setDecorationBackgroundColor(new java.awt.Color(255, 255, 51));
        calendarioDesde.setTodayButtonVisible(true);
        calendarioDesde.setWeekOfYearVisible(false);
        jPanel1.add(calendarioDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 330, 190));

        calendarioHasta.setBackground(new java.awt.Color(255, 255, 0));
        calendarioHasta.setDecorationBackgroundColor(new java.awt.Color(255, 255, 51));
        calendarioHasta.setTodayButtonVisible(true);
        calendarioHasta.setWeekOfYearVisible(false);
        jPanel1.add(calendarioHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 330, 190));

        btnCargarFechas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnFiltrar.png"))); // NOI18N
        btnCargarFechas.setBorderPainted(false);
        btnCargarFechas.setContentAreaFilled(false);
        btnCargarFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarFechasActionPerformed(evt);
            }
        });
        jPanel1.add(btnCargarFechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 150, 50));

        jLabel3.setFont(new java.awt.Font("Toonish", 1, 32)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("HASTA:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 110, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/JFIHistorial_fondoHistorial.png"))); // NOI18N
        jPanel1.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 570));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        controlVentanaComprasHistoriales = false;
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnCargarFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarFechasActionPerformed

        DefaultTableModel dtmCompras = (DefaultTableModel) this.tablaCompras.getModel();
        dtmCompras.setRowCount(0);
        ArrayList<Object[]> comprasObtenidas = new ArrayList<>();
        CompraDAO c = new CompraDAO();

        java.util.Date fechaDesde = calendarioDesde.getDate();
        java.sql.Date sqlFechaDesde = new java.sql.Date(fechaDesde.getTime());
        java.util.Date fechaHasta = calendarioHasta.getDate();
        java.sql.Date sqlFechaHasta = new java.sql.Date(fechaHasta.getTime());

        comprasObtenidas = c.mostrarCompras(sqlFechaDesde, sqlFechaHasta);

        for (int i = 0; i < comprasObtenidas.size(); i++) {
            dtmCompras.addRow(comprasObtenidas.get(i));
        }

    }//GEN-LAST:event_btnCargarFechasActionPerformed

    private void btnCargarDetalleCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarDetalleCompraActionPerformed
        if ((!txtIDcompra.getText().equals(""))) {

            int idCompra = Integer.parseInt(txtIDcompra.getText());

            DefaultTableModel dtmCompraDetalle = (DefaultTableModel) this.tablaDetalleCompra.getModel();
            dtmCompraDetalle.setRowCount(0);
            ArrayList<Object[]> detalleObtenido = new ArrayList<>();
            DetalleCompraDAO dc = new DetalleCompraDAO();

            detalleObtenido = dc.mostrarDetalleDeUnaCompra(idCompra);

            for (int i = 0; i < detalleObtenido.size(); i++) {
                dtmCompraDetalle.addRow(detalleObtenido.get(i));
            }

        } else {
            JOptionPane.showMessageDialog(null, "No se ha proporcionado un ID de compra");
        }
    }//GEN-LAST:event_btnCargarDetalleCompraActionPerformed

    private void txtIDcompraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDcompraKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            backspace = 1;
            return;
        }
    }//GEN-LAST:event_txtIDcompraKeyPressed

    private void txtIDcompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDcompraKeyTyped
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
    }//GEN-LAST:event_txtIDcompraKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargarDetalleCompra;
    private javax.swing.JButton btnCargarFechas;
    private com.toedter.calendar.JCalendar calendarioDesde;
    private com.toedter.calendar.JCalendar calendarioHasta;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JTable tablaCompras;
    private javax.swing.JTable tablaDetalleCompra;
    private javax.swing.JTextField txtIDcompra;
    // End of variables declaration//GEN-END:variables
}
