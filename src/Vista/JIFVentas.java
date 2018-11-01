package Vista;

import static Vista.MDI.jDesktopPane1;

/**
 *
 * @author alexc
 */
public class JIFVentas extends javax.swing.JInternalFrame {

    static public boolean controlVentanaVentas;
    
    public JIFVentas() {
        initComponents();
        controlVentanaVentas = true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnVerPrecios = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Ventas");
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

        jLabel4.setFont(new java.awt.Font("Taurus", 0, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("VENTAS");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 180, -1));

        btnVerPrecios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnVerPrecios.png"))); // NOI18N
        btnVerPrecios.setBorderPainted(false);
        btnVerPrecios.setContentAreaFilled(false);
        btnVerPrecios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPreciosActionPerformed(evt);
            }
        });
        jPanel1.add(btnVerPrecios, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 130, 120));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/JFIVentas_fondo.png"))); // NOI18N
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
        controlVentanaVentas = false;
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnVerPreciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPreciosActionPerformed
        if (JIFVerPrecios.controlVentanaVerPrecios) { //SI YA ESTA ACTIVA UNA VENTANA, NO ABRIR OTRA
            return;
        }

        JIFVerPrecios vistaP = new JIFVerPrecios();
        vistaP.setLocation(((jDesktopPane1.getSize()).width - (vistaP.getSize()).width) / 2, ((jDesktopPane1.getSize()).height - (vistaP.getSize()).height) / 2);
        jDesktopPane1.add(vistaP);
        vistaP.toFront();
    }//GEN-LAST:event_btnVerPreciosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVerPrecios;
    public javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFondo;
    // End of variables declaration//GEN-END:variables
}
