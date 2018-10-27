package Vista;

import Modelo.InventarioDAO;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author alexc
 */
public class JIFVerInventario extends javax.swing.JInternalFrame {

    static public boolean controlVentanaVerInventario;

    public JIFVerInventario() {
        initComponents();
        controlVentanaVerInventario = true;
        formatearTablaInventario();
        cargarInventarioATabla();
    }

    private void formatearTablaInventario() {
        TableColumnModel columnasResoluciones = this.tablaInventario.getColumnModel();
        this.tablaInventario.setShowGrid(true);
        this.tablaInventario.setShowVerticalLines(true);
        this.tablaInventario.setShowHorizontalLines(true);

        columnasResoluciones.getColumn(0).setPreferredWidth(10);
        columnasResoluciones.getColumn(1).setPreferredWidth(80);
        columnasResoluciones.getColumn(2).setPreferredWidth(40);
        columnasResoluciones.getColumn(3).setPreferredWidth(40);
        columnasResoluciones.getColumn(4).setPreferredWidth(40);
        columnasResoluciones.getColumn(5).setPreferredWidth(10);

        //CENTRAR EL HEADER DE LAS COLUMNAS
        DefaultTableCellRenderer headersInventario = (DefaultTableCellRenderer) this.tablaInventario.getTableHeader().getDefaultRenderer();
        headersInventario.setHorizontalAlignment(0);
        //CENTRAR LAS CELDAS
        DefaultTableCellRenderer celdasInventario = new DefaultTableCellRenderer();
        celdasInventario.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < 6; i++) {
            this.tablaInventario.getColumnModel().getColumn(i).setCellRenderer(celdasInventario);
        }
    }

    private void cargarInventarioATabla() {

        DefaultTableModel dtmInventario = (DefaultTableModel) this.tablaInventario.getModel();
        dtmInventario.setRowCount(0);

        ArrayList<Object[]> existenciasObtenidas = new ArrayList<>();
        InventarioDAO in = new InventarioDAO();

        existenciasObtenidas = in.mostrarINVENTARIO();

        for (int i = 0; i < existenciasObtenidas.size(); i++) {
            dtmInventario.addRow(existenciasObtenidas.get(i));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnRefrescaInventario = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaInventario = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Existencias");
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

        btnRefrescaInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/refresh.png"))); // NOI18N
        btnRefrescaInventario.setBorderPainted(false);
        btnRefrescaInventario.setContentAreaFilled(false);
        btnRefrescaInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescaInventarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnRefrescaInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 40, 40));

        tablaInventario.setBackground(new java.awt.Color(255, 255, 153));
        tablaInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Marca", "Unidad", "Presentacion", "Existencias"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaInventario.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaInventario);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 670, 430));

        jLabel13.setFont(new java.awt.Font("Taurus", 0, 48)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 0));
        jLabel13.setText("INVENTARIO");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 250, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/JIFVerInventario_fondo.png"))); // NOI18N
        jPanel1.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 570));

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
        controlVentanaVerInventario = false;
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnRefrescaInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescaInventarioActionPerformed
        DefaultTableModel dtmInventario = (DefaultTableModel) this.tablaInventario.getModel();
        dtmInventario.setRowCount(0);

        ArrayList<Object[]> existenciasObtenidas = new ArrayList<>();
        InventarioDAO in = new InventarioDAO();

        existenciasObtenidas = in.mostrarINVENTARIO();

        for (int i = 0; i < existenciasObtenidas.size(); i++) {
            dtmInventario.addRow(existenciasObtenidas.get(i));
        }
    }//GEN-LAST:event_btnRefrescaInventarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefrescaInventario;
    public javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JTable tablaInventario;
    // End of variables declaration//GEN-END:variables
}
