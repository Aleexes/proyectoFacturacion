package Vista;

import Controlador.ControladorConfigNegocio;
import javax.swing.JOptionPane;

/**
 *
 * @author alexc
 */
public class JIFNegocio extends javax.swing.JInternalFrame {

    static public boolean controlVentanaNegocio;

    public JIFNegocio() {
        initComponents();
        controlVentanaNegocio = true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblIcono = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombreSocial = new javax.swing.JTextField();
        txtNitdelNegocio = new javax.swing.JTextField();
        txtNombreNegocio = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblFondo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Configuración del negocio");
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

        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_negocio.png"))); // NOI18N
        jPanel1.add(lblIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        jLabel1.setFont(new java.awt.Font("Taurus", 2, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(152, 255, 89));
        jLabel1.setText("NEGOCIO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 250, -1));

        jLabel4.setFont(new java.awt.Font("Taurus", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(152, 255, 89));
        jLabel4.setText("Denominacion social:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 180, -1));

        jLabel6.setFont(new java.awt.Font("Taurus", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(152, 255, 89));
        jLabel6.setText("Nombre comercial:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 150, -1));

        jLabel5.setFont(new java.awt.Font("Taurus", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(152, 255, 89));
        jLabel5.setText("NIT:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 40, -1));
        jPanel1.add(txtNombreSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 250, -1));
        jPanel1.add(txtNitdelNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 200, -1));
        jPanel1.add(txtNombreNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 250, -1));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ButtonSaveMaster.png"))); // NOI18N
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 140, 50));

        jLabel7.setFont(new java.awt.Font("Taurus", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(152, 255, 89));
        jLabel7.setText("Direccion:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 90, -1));
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 250, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/JIFNegocio_fondo.png"))); // NOI18N
        jPanel1.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 320));

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
        controlVentanaNegocio = false;
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        if (txtNitdelNegocio.getText().equals("")) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Ingresar NIT del negocio");
            return;
        }

        if (txtNombreNegocio.getText().equals("")) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Ingresar el nombre del negocio");
            return;
        }
        
        if (txtNombreSocial.getText().equals("")) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Ingresar nombre social para el negocio");
            return;
        }
        
        if (txtDireccion.getText().equals("")) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Ingresar direccion para el negocio");
            return;
        }
        
        ControladorConfigNegocio cN = new ControladorConfigNegocio(txtNitdelNegocio.getText(), txtNombreNegocio.getText(), txtNombreSocial.getText(), txtDireccion.getText());
        cN.configurarSistema(cN);
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblIcono;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNitdelNegocio;
    private javax.swing.JTextField txtNombreNegocio;
    private javax.swing.JTextField txtNombreSocial;
    // End of variables declaration//GEN-END:variables
}
