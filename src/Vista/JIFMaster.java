package Vista;

import static Vista.MDI.jDesktopPane1;

/**
 *
 * @author alexc
 */
public class JIFMaster extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIFMaster
     */
    public JIFMaster() {
        initComponents();
        controlVentanaMaster = true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnAgregarAdmin = new javax.swing.JButton();
        btnConfigNegocio = new javax.swing.JButton();
        btnConfigSistema = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Master");
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

        jLabel1.setFont(new java.awt.Font("Taurus", 2, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(152, 255, 89));
        jLabel1.setText("SISTEMA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 210, -1));

        btnAgregarAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/JIFMaster_addAdmin.png"))); // NOI18N
        btnAgregarAdmin.setBorderPainted(false);
        btnAgregarAdmin.setContentAreaFilled(false);
        btnAgregarAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAdminActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 120, 140));

        btnConfigNegocio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/JIFMaster_negocio.png"))); // NOI18N
        btnConfigNegocio.setBorderPainted(false);
        btnConfigNegocio.setContentAreaFilled(false);
        btnConfigNegocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigNegocioActionPerformed(evt);
            }
        });
        jPanel1.add(btnConfigNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 120, 140));

        btnConfigSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/JIFMaster_SISTEMA.png"))); // NOI18N
        btnConfigSistema.setBorderPainted(false);
        btnConfigSistema.setContentAreaFilled(false);
        btnConfigSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigSistemaActionPerformed(evt);
            }
        });
        jPanel1.add(btnConfigSistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 120, 140));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/JIFMaster_fondoPanel.png"))); // NOI18N
        jPanel1.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public static boolean controlVentanaMaster = false;


    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        controlVentanaMaster = false;
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        jDesktopPane1.revalidate();
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnConfigSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigSistemaActionPerformed
        if (JIFSistema.controlVentanaSistema) { //SI YA ESTA ACTIVA UNA VENTANA DE CONFIGURACION DEL SISTEMA, NO ABRIR OTRA
            return;
        }

        JIFSistema vistaSis = new JIFSistema();
        vistaSis.setLocation(((jDesktopPane1.getSize()).width - (vistaSis.getSize()).width) / 2, ((jDesktopPane1.getSize()).height - (vistaSis.getSize()).height) / 2);
        jDesktopPane1.add(vistaSis);
        vistaSis.toFront();
    }//GEN-LAST:event_btnConfigSistemaActionPerformed

    private void btnConfigNegocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigNegocioActionPerformed
        if (JIFNegocio.controlVentanaNegocio) { //SI YA ESTA ACTIVA UNA VENTANA DE CONFIGURACION DEL NEGOCIO, NO ABRIR OTRA
            return;
        }

        JIFNegocio vistaNeg = new JIFNegocio();
        vistaNeg.setLocation(((jDesktopPane1.getSize()).width - (vistaNeg.getSize()).width) / 2, ((jDesktopPane1.getSize()).height - (vistaNeg.getSize()).height) / 2);
        jDesktopPane1.add(vistaNeg);
        vistaNeg.toFront();
    }//GEN-LAST:event_btnConfigNegocioActionPerformed

    private void btnAgregarAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAdminActionPerformed
        if (JIFAgregarAdmin.controlVentanaAgregarAdmin) { //SI YA ESTA ACTIVA UNA VENTANA DE CLIENTES, NO ABRIR OTRA
            return;
        }

        JIFAgregarAdmin vistaAA = new JIFAgregarAdmin();
        vistaAA.setLocation(((jDesktopPane1.getSize()).width - (vistaAA.getSize()).width) / 2, ((jDesktopPane1.getSize()).height - (vistaAA.getSize()).height) / 2);
        jDesktopPane1.add(vistaAA);
        vistaAA.toFront();
    }//GEN-LAST:event_btnAgregarAdminActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarAdmin;
    private javax.swing.JButton btnConfigNegocio;
    private javax.swing.JButton btnConfigSistema;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFondo;
    // End of variables declaration//GEN-END:variables
}
