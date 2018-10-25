package Vista;

import Controlador.ControladorUsuario;
import javax.swing.JOptionPane;

/**
 *
 * @author alexc
 */
public class JIFAgregarAdmin extends javax.swing.JInternalFrame {

    static public boolean controlVentanaAgregarAdmin;
    
    public JIFAgregarAdmin() {
        initComponents();
        controlVentanaAgregarAdmin = true;
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
        txtUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnRegistrarUsuario = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbRol = new javax.swing.JComboBox<>();
        txtPassword = new javax.swing.JPasswordField();
        fondo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Agregar usuario admin");
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
        jLabel1.setText("Administracion");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 330, -1));

        jLabel3.setFont(new java.awt.Font("Taurus", 2, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(152, 255, 89));
        jLabel3.setText("Username:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 120, -1));
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 170, -1));

        jLabel4.setFont(new java.awt.Font("Taurus", 2, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(152, 255, 89));
        jLabel4.setText("Password:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 130, -1));

        jLabel2.setFont(new java.awt.Font("Taurus", 2, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(152, 255, 89));
        jLabel2.setText("Rol:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 150, -1));

        btnRegistrarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ButtonSaveMaster.png"))); // NOI18N
        btnRegistrarUsuario.setBorderPainted(false);
        btnRegistrarUsuario.setContentAreaFilled(false);
        btnRegistrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 140, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AdminsIcon.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 210, 190));

        cbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "empleado" }));
        jPanel1.add(cbRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 170, -1));
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 170, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoAgregarAdmin.png"))); // NOI18N
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 420));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        controlVentanaAgregarAdmin = false;
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnRegistrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarUsuarioActionPerformed

        if (txtUsername.getText().equals("")) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Indicar el numero de NIT");
            return;
        }

        if (txtPassword.getPassword().equals("")) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Especificar un nombre");
            return;
        }
        String passString = new String(txtPassword.getPassword());

        ControladorUsuario cU = new ControladorUsuario((String) cbRol.getSelectedItem(), txtUsername.getText(), passString);
        cU.crearUsuario(cU);
        
    }//GEN-LAST:event_btnRegistrarUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarUsuario;
    private javax.swing.JComboBox<String> cbRol;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
