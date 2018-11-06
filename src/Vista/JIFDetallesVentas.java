package Vista;

import Modelo.TransaccionDAO;
import Modelo.VentaDAO;
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
public class JIFDetallesVentas extends javax.swing.JInternalFrame {

    static public boolean controlVentanaDetallesVenta;

    public JIFDetallesVentas() {
        initComponents();
        controlVentanaDetallesVenta = true;
        formatearTablaDocumentosEmitidos();
        formatearTablaDetalleVenta();
        lblSeleccionVenta.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnVerDetalle = new javax.swing.JButton();
        lblSeleccionVenta = new javax.swing.JLabel();
        cbTipoDocumento = new javax.swing.JComboBox<>();
        txtMontoTotalFacturas = new javax.swing.JLabel();
        lblQ = new javax.swing.JLabel();
        lblMontototalFacturas = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        tablaDetalleVenta = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDocumentosEmitidos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        calendarioDesde = new com.toedter.calendar.JCalendar();
        jLabel5 = new javax.swing.JLabel();
        calendarioHasta = new com.toedter.calendar.JCalendar();
        jLabel3 = new javax.swing.JLabel();
        btnCargarFechas = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Detalle de venta");
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

        btnVerDetalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnVerDetalle.png"))); // NOI18N
        btnVerDetalle.setBorderPainted(false);
        btnVerDetalle.setContentAreaFilled(false);
        btnVerDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDetalleActionPerformed(evt);
            }
        });
        jPanel1.add(btnVerDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 560, 140, 50));

        lblSeleccionVenta.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        lblSeleccionVenta.setForeground(new java.awt.Color(255, 0, 0));
        lblSeleccionVenta.setText("Seleccionar una venta para ver su detalle*");
        jPanel1.add(lblSeleccionVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 580, 360, -1));

        cbTipoDocumento.setBackground(new java.awt.Color(255, 255, 51));
        cbTipoDocumento.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cbTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Factura", "Nota de crédito", "Nota de débito" }));
        jPanel1.add(cbTipoDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 250, 30));

        txtMontoTotalFacturas.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        txtMontoTotalFacturas.setForeground(new java.awt.Color(153, 255, 51));
        txtMontoTotalFacturas.setText("0.00");
        jPanel1.add(txtMontoTotalFacturas, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 590, 320, -1));

        lblQ.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        lblQ.setForeground(new java.awt.Color(153, 255, 51));
        lblQ.setText("Q.");
        jPanel1.add(lblQ, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 40, -1));

        lblMontototalFacturas.setFont(new java.awt.Font("Taurus", 0, 24)); // NOI18N
        lblMontototalFacturas.setForeground(new java.awt.Color(153, 255, 51));
        lblMontototalFacturas.setText("Monto total:");
        jPanel1.add(lblMontototalFacturas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 140, -1));

        tablaDetalleVenta.setBackground(new java.awt.Color(255, 204, 51));
        tablaDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "MARCA", "UNIDAD", "PRES.", "CANT.", "PRECIO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaDetalleVenta.getTableHeader().setReorderingAllowed(false);
        jScrollPane.setViewportView(tablaDetalleVenta);
        if (tablaDetalleVenta.getColumnModel().getColumnCount() > 0) {
            tablaDetalleVenta.getColumnModel().getColumn(0).setResizable(false);
            tablaDetalleVenta.getColumnModel().getColumn(1).setResizable(false);
            tablaDetalleVenta.getColumnModel().getColumn(2).setResizable(false);
            tablaDetalleVenta.getColumnModel().getColumn(3).setResizable(false);
            tablaDetalleVenta.getColumnModel().getColumn(4).setResizable(false);
            tablaDetalleVenta.getColumnModel().getColumn(5).setResizable(false);
            tablaDetalleVenta.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanel1.add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 110, 450, 440));

        tablaDocumentosEmitidos.setBackground(new java.awt.Color(255, 255, 153));
        tablaDocumentosEmitidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha", "Documento", "NIT Cliente", "Numero", "Resolucion", "Monto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaDocumentosEmitidos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaDocumentosEmitidos);
        if (tablaDocumentosEmitidos.getColumnModel().getColumnCount() > 0) {
            tablaDocumentosEmitidos.getColumnModel().getColumn(0).setResizable(false);
            tablaDocumentosEmitidos.getColumnModel().getColumn(1).setResizable(false);
            tablaDocumentosEmitidos.getColumnModel().getColumn(2).setResizable(false);
            tablaDocumentosEmitidos.getColumnModel().getColumn(3).setResizable(false);
            tablaDocumentosEmitidos.getColumnModel().getColumn(4).setResizable(false);
            tablaDocumentosEmitidos.getColumnModel().getColumn(5).setResizable(false);
            tablaDocumentosEmitidos.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 680, 170));

        jLabel4.setFont(new java.awt.Font("Taurus", 0, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("DETALLES DE VENTA");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 440, -1));

        calendarioDesde.setBackground(new java.awt.Color(255, 255, 0));
        calendarioDesde.setDecorationBackgroundColor(new java.awt.Color(255, 255, 51));
        calendarioDesde.setTodayButtonVisible(true);
        calendarioDesde.setWeekOfYearVisible(false);
        jPanel1.add(calendarioDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 330, 190));

        jLabel5.setFont(new java.awt.Font("Toonish", 1, 32)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("DESDE:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 110, -1));

        calendarioHasta.setBackground(new java.awt.Color(255, 255, 0));
        calendarioHasta.setDecorationBackgroundColor(new java.awt.Color(255, 255, 51));
        calendarioHasta.setTodayButtonVisible(true);
        calendarioHasta.setWeekOfYearVisible(false);
        jPanel1.add(calendarioHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 330, 190));

        jLabel3.setFont(new java.awt.Font("Toonish", 1, 32)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("HASTA:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 110, -1));

        btnCargarFechas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnFiltrar.png"))); // NOI18N
        btnCargarFechas.setBorderPainted(false);
        btnCargarFechas.setContentAreaFilled(false);
        btnCargarFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarFechasActionPerformed(evt);
            }
        });
        jPanel1.add(btnCargarFechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 150, 50));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/JIFDetalleVenta_fondo.png"))); // NOI18N
        jPanel1.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 650));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formatearTablaDocumentosEmitidos() {
        TableColumnModel columnasDocumentosEmitidos = this.tablaDocumentosEmitidos.getColumnModel();
        this.tablaDocumentosEmitidos.setShowGrid(true);
        this.tablaDocumentosEmitidos.setShowVerticalLines(true);
        this.tablaDocumentosEmitidos.setShowHorizontalLines(true);

        columnasDocumentosEmitidos.getColumn(0).setPreferredWidth(10);
        columnasDocumentosEmitidos.getColumn(1).setPreferredWidth(80);
        columnasDocumentosEmitidos.getColumn(2).setPreferredWidth(80);
        columnasDocumentosEmitidos.getColumn(3).setPreferredWidth(60);
        columnasDocumentosEmitidos.getColumn(4).setPreferredWidth(40);
        columnasDocumentosEmitidos.getColumn(5).setPreferredWidth(40);

        //CENTRAR EL HEADER DE LAS COLUMNAS
        DefaultTableCellRenderer headersDocumentosEmitidos = (DefaultTableCellRenderer) this.tablaDocumentosEmitidos.getTableHeader().getDefaultRenderer();
        headersDocumentosEmitidos.setHorizontalAlignment(0);
        //CENTRAR LAS CELDAS
        DefaultTableCellRenderer celdasDocumentosEmitidos = new DefaultTableCellRenderer();
        celdasDocumentosEmitidos.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < 5; i++) {
            this.tablaDocumentosEmitidos.getColumnModel().getColumn(i).setCellRenderer(celdasDocumentosEmitidos);
        }
    }

    private void formatearTablaDetalleVenta() {
        TableColumnModel columnasDetalleVenta = this.tablaDetalleVenta.getColumnModel();
        this.tablaDocumentosEmitidos.setShowGrid(true);
        this.tablaDocumentosEmitidos.setShowVerticalLines(true);
        this.tablaDocumentosEmitidos.setShowHorizontalLines(true);

        columnasDetalleVenta.getColumn(0).setPreferredWidth(5);
        columnasDetalleVenta.getColumn(1).setPreferredWidth(20);
        columnasDetalleVenta.getColumn(2).setPreferredWidth(20);
        columnasDetalleVenta.getColumn(3).setPreferredWidth(10);
        columnasDetalleVenta.getColumn(4).setPreferredWidth(10);
        columnasDetalleVenta.getColumn(5).setPreferredWidth(10);
        columnasDetalleVenta.getColumn(6).setPreferredWidth(10);

        //CENTRAR EL HEADER DE LAS COLUMNAS
        DefaultTableCellRenderer headersDetalleVenta = (DefaultTableCellRenderer) this.tablaDetalleVenta.getTableHeader().getDefaultRenderer();
        headersDetalleVenta.setHorizontalAlignment(0);
        //CENTRAR LAS CELDAS
        DefaultTableCellRenderer celdasDetalleVenta = new DefaultTableCellRenderer();
        celdasDetalleVenta.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < 7; i++) {
            this.tablaDetalleVenta.getColumnModel().getColumn(i).setCellRenderer(celdasDetalleVenta);
        }
    }


    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        controlVentanaDetallesVenta = false;
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnCargarFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarFechasActionPerformed

        double totalMonto = 0;
        DefaultTableModel dtmTransacciones = (DefaultTableModel) this.tablaDocumentosEmitidos.getModel();
        dtmTransacciones.setRowCount(0);

        ArrayList<Object[]> documentosObtenidos = new ArrayList<>();
        TransaccionDAO t = new TransaccionDAO();

        java.util.Date fechaDesde = calendarioDesde.getDate();
        java.sql.Date sqlFechaDesde = new java.sql.Date(fechaDesde.getTime());
        java.util.Date fechaHasta = calendarioHasta.getDate();
        java.sql.Date sqlFechaHasta = new java.sql.Date(fechaHasta.getTime());

        if (cbTipoDocumento.getSelectedIndex() == 0) {
            documentosObtenidos = t.transaccionesAsociadasAFacturas(sqlFechaDesde, sqlFechaHasta);
        } else if (cbTipoDocumento.getSelectedIndex() == 1) {
            documentosObtenidos = t.transaccionesAsociadasANotasCredito(sqlFechaDesde, sqlFechaHasta);
        } else if (cbTipoDocumento.getSelectedIndex() == 2) {
            documentosObtenidos = t.transaccionesAsociadasANotasDebito(sqlFechaDesde, sqlFechaHasta);
        }

        for (int i = 0; i < documentosObtenidos.size(); i++) {
            dtmTransacciones.addRow(documentosObtenidos.get(i));
        }

        for (int i = 0; i < tablaDocumentosEmitidos.getRowCount(); i++) {
            totalMonto = totalMonto + Double.parseDouble(tablaDocumentosEmitidos.getValueAt(i, 6).toString());
        }

        txtMontoTotalFacturas.setText(String.valueOf(totalMonto));

    }//GEN-LAST:event_btnCargarFechasActionPerformed

    private void btnVerDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDetalleActionPerformed
        DefaultTableModel dtmDetalleVenta = (DefaultTableModel) this.tablaDetalleVenta.getModel();
        dtmDetalleVenta.setRowCount(0);
        ArrayList<Object[]> detalleObtenido = new ArrayList<>();

        int idDocumento = 0;
        String tipoDocumento = "";
        int filaSeleccionada = 0;
        VentaDAO v = new VentaDAO();

        try {
            filaSeleccionada = tablaDocumentosEmitidos.getSelectedRow();
            tipoDocumento = tablaDocumentosEmitidos.getModel().getValueAt(filaSeleccionada, 2).toString();
            idDocumento = Integer.parseInt((tablaDocumentosEmitidos.getModel().getValueAt(filaSeleccionada, 0).toString()));

            if (tipoDocumento.equals("Factura")) {
                detalleObtenido = v.mostrarDetalleVenta(idDocumento);
                for (int i = 0; i < detalleObtenido.size(); i++) {
                    dtmDetalleVenta.addRow(detalleObtenido.get(i));
                }
            }

            if (tipoDocumento.equals("Nota de crédito")) {

            }

            if (tipoDocumento.equals("Nota de débito")) {

            }

            lblSeleccionVenta.setVisible(false);

        } catch (Exception e) {
            lblSeleccionVenta.setVisible(true);
        }
    }//GEN-LAST:event_btnVerDetalleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargarFechas;
    private javax.swing.JButton btnVerDetalle;
    private com.toedter.calendar.JCalendar calendarioDesde;
    private com.toedter.calendar.JCalendar calendarioHasta;
    private javax.swing.JComboBox<String> cbTipoDocumento;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFondo;
    public javax.swing.JLabel lblMontototalFacturas;
    public javax.swing.JLabel lblQ;
    private javax.swing.JLabel lblSeleccionVenta;
    private javax.swing.JTable tablaDetalleVenta;
    private javax.swing.JTable tablaDocumentosEmitidos;
    public javax.swing.JLabel txtMontoTotalFacturas;
    // End of variables declaration//GEN-END:variables
}
