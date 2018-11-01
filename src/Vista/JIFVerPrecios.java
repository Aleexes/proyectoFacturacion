package Vista;

import Modelo.VentaDAO;
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
public class JIFVerPrecios extends javax.swing.JInternalFrame {

    int backspace = 0;
    int backspace2 = 0;
    int punto = 0;
    static public boolean controlVentanaVerPrecios;
    
    public JIFVerPrecios() {
        initComponents();
        controlVentanaVerPrecios = true;
        formatearTablaInventario();
        cargarProductosYPreciosATabla();
    }
    
    private void formatearTablaInventario() {
        TableColumnModel columnasPrecios = this.tablaPrecios.getColumnModel();
        this.tablaPrecios.setShowGrid(true);
        this.tablaPrecios.setShowVerticalLines(true);
        this.tablaPrecios.setShowHorizontalLines(true);

        columnasPrecios.getColumn(0).setPreferredWidth(10);
        columnasPrecios.getColumn(1).setPreferredWidth(80);
        columnasPrecios.getColumn(2).setPreferredWidth(40);
        columnasPrecios.getColumn(3).setPreferredWidth(40);
        columnasPrecios.getColumn(4).setPreferredWidth(40);
        columnasPrecios.getColumn(5).setPreferredWidth(10);

        //CENTRAR EL HEADER DE LAS COLUMNAS
        DefaultTableCellRenderer headersPrecios = (DefaultTableCellRenderer) this.tablaPrecios.getTableHeader().getDefaultRenderer();
        headersPrecios.setHorizontalAlignment(0);
        //CENTRAR LAS CELDAS
        DefaultTableCellRenderer celdasPrecios = new DefaultTableCellRenderer();
        celdasPrecios.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < 6; i++) {
            this.tablaPrecios.getColumnModel().getColumn(i).setCellRenderer(celdasPrecios);
        }
    }
    
    private void cargarProductosYPreciosATabla() {
        DefaultTableModel dtmPrecios = (DefaultTableModel) this.tablaPrecios.getModel();
        dtmPrecios.setRowCount(0);

        ArrayList<Object[]> preciosObtenidos = new ArrayList<>();
        VentaDAO v = new VentaDAO();

        preciosObtenidos = v.mostrarProductosYsusPrecios();

        for (int i = 0; i < preciosObtenidos.size(); i++) {
            dtmPrecios.addRow(preciosObtenidos.get(i));
        }
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCambiar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtIDProducto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNuevoPrecio = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPrecios = new javax.swing.JTable();
        btnRefrescaPrecios = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Precios de productos");
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

        btnCambiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnCambiar.png"))); // NOI18N
        btnCambiar.setBorderPainted(false);
        btnCambiar.setContentAreaFilled(false);
        btnCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCambiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 140, 50));

        jLabel4.setFont(new java.awt.Font("Taurus", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("Id producto:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 140, -1));

        txtIDProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIDProductoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDProductoKeyTyped(evt);
            }
        });
        jPanel1.add(txtIDProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 100, -1));

        jLabel7.setFont(new java.awt.Font("Taurus", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 0));
        jLabel7.setText("Nuevo precio:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 120, -1));

        txtNuevoPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNuevoPrecioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNuevoPrecioKeyTyped(evt);
            }
        });
        jPanel1.add(txtNuevoPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 110, -1));

        tablaPrecios.setBackground(new java.awt.Color(255, 255, 153));
        tablaPrecios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Marca", "Unidad", "Presentacion", "Precio actual"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPrecios.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaPrecios);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 640, 390));

        btnRefrescaPrecios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/refresh.png"))); // NOI18N
        btnRefrescaPrecios.setBorderPainted(false);
        btnRefrescaPrecios.setContentAreaFilled(false);
        btnRefrescaPrecios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescaPreciosActionPerformed(evt);
            }
        });
        jPanel1.add(btnRefrescaPrecios, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 40, 40));

        jLabel13.setFont(new java.awt.Font("Taurus", 0, 48)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 0));
        jLabel13.setText("PRECIOS");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 210, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/JIFVerPrecios_fondo.png"))); // NOI18N
        jPanel1.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 570));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        controlVentanaVerPrecios = false;
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnRefrescaPreciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescaPreciosActionPerformed
        cargarProductosYPreciosATabla();
    }//GEN-LAST:event_btnRefrescaPreciosActionPerformed

    private void btnCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarActionPerformed
        VentaDAO v = new VentaDAO();
        v.actualizarPrecioDeUnProducto(Integer.parseInt(txtIDProducto.getText()), Double.parseDouble(txtNuevoPrecio.getText()));
        JOptionPane.showMessageDialog(null, "¡Precio actualizado!");
    }//GEN-LAST:event_btnCambiarActionPerformed

    private void txtIDProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDProductoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            backspace = 1;
            return;
        }
    }//GEN-LAST:event_txtIDProductoKeyPressed

    private void txtIDProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDProductoKeyTyped
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
    }//GEN-LAST:event_txtIDProductoKeyTyped

    private void txtNuevoPrecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNuevoPrecioKeyPressed
        if ((evt.getKeyCode() == KeyEvent.VK_PERIOD) || (evt.getKeyCode() == KeyEvent.VK_DECIMAL)) {
            punto = 1;
            return;
        }

        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            backspace2 = 1;
            return;
        }
    }//GEN-LAST:event_txtNuevoPrecioKeyPressed

    private void txtNuevoPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNuevoPrecioKeyTyped
        if (punto == 1) {
            punto = 0;
            return;
        }

        if (backspace2 == 1) {
            backspace2 = 0;
            return;
        }

        char validar = evt.getKeyChar();
        if (!Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
        }
    }//GEN-LAST:event_txtNuevoPrecioKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiar;
    private javax.swing.JButton btnRefrescaPrecios;
    public javax.swing.JLabel jLabel13;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JTable tablaPrecios;
    private javax.swing.JTextField txtIDProducto;
    private javax.swing.JTextField txtNuevoPrecio;
    // End of variables declaration//GEN-END:variables
}
