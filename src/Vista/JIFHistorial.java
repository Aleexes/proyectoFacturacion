package Vista;

import Modelo.ResolucionDAO;
import Modelo.TransaccionDAO;
import java.awt.Color;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author alexc
 */
public class JIFHistorial extends javax.swing.JInternalFrame {

    static public boolean controlVentanaHistorial;

    public JIFHistorial() {
        initComponents();
        controlVentanaHistorial = true;
        formatearTablaResoluciones();
        formatearTablaTransacciones();
    }

    private void formatearTablaResoluciones() {
        TableColumnModel columnasResoluciones = this.tablaResoluciones.getColumnModel();
        this.tablaResoluciones.setShowGrid(true);
        this.tablaResoluciones.setShowVerticalLines(true);
        this.tablaResoluciones.setShowHorizontalLines(true);

        columnasResoluciones.getColumn(0).setPreferredWidth(150);
        columnasResoluciones.getColumn(1).setPreferredWidth(80);
        columnasResoluciones.getColumn(2).setPreferredWidth(40);
        columnasResoluciones.getColumn(3).setPreferredWidth(40);
        columnasResoluciones.getColumn(4).setPreferredWidth(40);
        columnasResoluciones.getColumn(5).setPreferredWidth(80);

        //CENTRAR EL HEADER DE LAS COLUMNAS
        DefaultTableCellRenderer headersResoluciones = (DefaultTableCellRenderer) this.tablaResoluciones.getTableHeader().getDefaultRenderer();
        headersResoluciones.setHorizontalAlignment(0);
        //CENTRAR LAS CELDAS
        DefaultTableCellRenderer celdasResoluciones = new DefaultTableCellRenderer();
        celdasResoluciones.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < 8; i++) {
            this.tablaResoluciones.getColumnModel().getColumn(i).setCellRenderer(celdasResoluciones);
        }
    }

    private void formatearTablaTransacciones() {
        TableColumnModel columnasTransacciones = this.tablaTransacciones.getColumnModel();
        this.tablaTransacciones.setShowGrid(true);
        this.tablaTransacciones.setShowVerticalLines(true);
        this.tablaTransacciones.setShowHorizontalLines(true);

        columnasTransacciones.getColumn(0).setPreferredWidth(80);
        columnasTransacciones.getColumn(1).setPreferredWidth(80);
        columnasTransacciones.getColumn(2).setPreferredWidth(60);
        columnasTransacciones.getColumn(3).setPreferredWidth(40);

        //CENTRAR EL HEADER DE LAS COLUMNAS
        DefaultTableCellRenderer headersTransacciones = (DefaultTableCellRenderer) this.tablaTransacciones.getTableHeader().getDefaultRenderer();
        headersTransacciones.setHorizontalAlignment(0);
        //CENTRAR LAS CELDAS
        DefaultTableCellRenderer celdasTransacciones = new DefaultTableCellRenderer();
        celdasTransacciones.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < 7; i++) {
            this.tablaTransacciones.getColumnModel().getColumn(i).setCellRenderer(celdasTransacciones);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnImprimirResoluciones = new javax.swing.JButton();
        btnImprimirTransacciones = new javax.swing.JButton();
        calendarioDesde = new com.toedter.calendar.JCalendar();
        calendarioHasta = new com.toedter.calendar.JCalendar();
        jLabel4 = new javax.swing.JLabel();
        btnCargarFechas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTransacciones = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaResoluciones = new javax.swing.JTable();
        lblFondo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Historial");
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

        jLabel1.setFont(new java.awt.Font("Taurus", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("TRANSACCIONES");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 390, -1));

        jLabel3.setFont(new java.awt.Font("Toonish", 1, 32)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("HASTA:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 270, 110, -1));

        jLabel5.setFont(new java.awt.Font("Toonish", 1, 32)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("DESDE:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 20, 110, -1));

        btnImprimirResoluciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnBitacora.png"))); // NOI18N
        btnImprimirResoluciones.setBorderPainted(false);
        btnImprimirResoluciones.setContentAreaFilled(false);
        btnImprimirResoluciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirResolucionesActionPerformed(evt);
            }
        });
        jPanel1.add(btnImprimirResoluciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 140, 30));

        btnImprimirTransacciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnBitacora.png"))); // NOI18N
        btnImprimirTransacciones.setBorderPainted(false);
        btnImprimirTransacciones.setContentAreaFilled(false);
        btnImprimirTransacciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirTransaccionesActionPerformed(evt);
            }
        });
        jPanel1.add(btnImprimirTransacciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 140, 30));

        calendarioDesde.setBackground(new java.awt.Color(255, 255, 0));
        calendarioDesde.setDecorationBackgroundColor(new java.awt.Color(255, 255, 51));
        calendarioDesde.setTodayButtonVisible(true);
        calendarioDesde.setWeekOfYearVisible(false);
        jPanel1.add(calendarioDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 50, 330, 190));

        calendarioHasta.setBackground(new java.awt.Color(255, 255, 0));
        calendarioHasta.setDecorationBackgroundColor(new java.awt.Color(255, 255, 51));
        calendarioHasta.setTodayButtonVisible(true);
        calendarioHasta.setWeekOfYearVisible(false);
        jPanel1.add(calendarioHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 300, 330, 190));

        jLabel4.setFont(new java.awt.Font("Taurus", 0, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("RESOLUCIONES");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 390, -1));

        btnCargarFechas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnFiltrar.png"))); // NOI18N
        btnCargarFechas.setBorderPainted(false);
        btnCargarFechas.setContentAreaFilled(false);
        btnCargarFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarFechasActionPerformed(evt);
            }
        });
        jPanel1.add(btnCargarFechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 500, 150, 50));

        tablaTransacciones.setBackground(new java.awt.Color(255, 255, 153));
        tablaTransacciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#Transaccion", "Documento", "Correlativo", "Serie", "Monto", "Fecha", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaTransacciones.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaTransacciones);
        if (tablaTransacciones.getColumnModel().getColumnCount() > 0) {
            tablaTransacciones.getColumnModel().getColumn(0).setResizable(false);
            tablaTransacciones.getColumnModel().getColumn(1).setResizable(false);
            tablaTransacciones.getColumnModel().getColumn(2).setResizable(false);
            tablaTransacciones.getColumnModel().getColumn(3).setResizable(false);
            tablaTransacciones.getColumnModel().getColumn(4).setResizable(false);
            tablaTransacciones.getColumnModel().getColumn(5).setResizable(false);
            tablaTransacciones.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 720, 170));

        tablaResoluciones.setBackground(new java.awt.Color(255, 255, 153));
        tablaResoluciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#Resolucion", "Documento", "#Inicial", "#Final", "Serie", "Autorizacion", "Ingreso", "Activa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaResoluciones.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaResoluciones);
        if (tablaResoluciones.getColumnModel().getColumnCount() > 0) {
            tablaResoluciones.getColumnModel().getColumn(0).setResizable(false);
            tablaResoluciones.getColumnModel().getColumn(1).setResizable(false);
            tablaResoluciones.getColumnModel().getColumn(2).setResizable(false);
            tablaResoluciones.getColumnModel().getColumn(3).setResizable(false);
            tablaResoluciones.getColumnModel().getColumn(4).setResizable(false);
            tablaResoluciones.getColumnModel().getColumn(5).setResizable(false);
            tablaResoluciones.getColumnModel().getColumn(6).setResizable(false);
            tablaResoluciones.getColumnModel().getColumn(7).setResizable(false);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 720, 170));

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
        controlVentanaHistorial = false;
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnCargarFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarFechasActionPerformed

        DefaultTableModel dtmResoluciones = (DefaultTableModel) this.tablaResoluciones.getModel();
        dtmResoluciones.setRowCount(0);
        DefaultTableModel dtmTransacciones = (DefaultTableModel) this.tablaTransacciones.getModel();
        dtmTransacciones.setRowCount(0);

        ArrayList<Object[]> resolucionesObtenidas = new ArrayList<>();
        ArrayList<Object[]> transaccionesObtenidas = new ArrayList<>();
        ResolucionDAO r = new ResolucionDAO();
        TransaccionDAO t = new TransaccionDAO();

        java.util.Date fechaDesde = calendarioDesde.getDate();
        java.sql.Date sqlFechaDesde = new java.sql.Date(fechaDesde.getTime());
        java.util.Date fechaHasta = calendarioHasta.getDate();
        java.sql.Date sqlFechaHasta = new java.sql.Date(fechaHasta.getTime());

        resolucionesObtenidas = r.mostrarResoluciones(sqlFechaDesde, sqlFechaHasta);
        transaccionesObtenidas = t.mostrarTransacciones(sqlFechaDesde, sqlFechaHasta);

        for (int i = 0; i < resolucionesObtenidas.size(); i++) {
            dtmResoluciones.addRow(resolucionesObtenidas.get(i));
        }

        for (int j = 0; j < transaccionesObtenidas.size(); j++) {
            dtmTransacciones.addRow(transaccionesObtenidas.get(j));
        }


    }//GEN-LAST:event_btnCargarFechasActionPerformed

    private void btnImprimirResolucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirResolucionesActionPerformed
        if(this.tablaResoluciones.getRowCount() == 0){
            JOptionPane.showMessageDialog(null, "No hay nada que imprimir");
            return;
        }
        MessageFormat headerFormat = new MessageFormat("Bitacora de resoluciones");
        MessageFormat footerFormat = new MessageFormat("Superintendencia de Administración Tributaria SAT, Guatemala");
        try {
            tablaResoluciones.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnImprimirResolucionesActionPerformed

    private void btnImprimirTransaccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirTransaccionesActionPerformed
        if(this.tablaTransacciones.getRowCount() == 0){
            JOptionPane.showMessageDialog(null, "No hay nada que imprimir");
            return;
        }
        MessageFormat headerFormat = new MessageFormat("Bitacora de transacciones");
        MessageFormat footerFormat = new MessageFormat("Superintendencia de Administración Tributaria SAT, Guatemala");
        try {
            tablaTransacciones.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnImprimirTransaccionesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargarFechas;
    private javax.swing.JButton btnImprimirResoluciones;
    private javax.swing.JButton btnImprimirTransacciones;
    private com.toedter.calendar.JCalendar calendarioDesde;
    private com.toedter.calendar.JCalendar calendarioHasta;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JTable tablaResoluciones;
    private javax.swing.JTable tablaTransacciones;
    // End of variables declaration//GEN-END:variables
}
