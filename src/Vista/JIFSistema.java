package Vista;

import Controlador.ControladorConfigSistema;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author alexc
 */
public class JIFSistema extends javax.swing.JInternalFrame {

    int backspace = 0;
    static public boolean controlVentanaSistema;

    public JIFSistema() {
        initComponents();
        controlVentanaSistema = true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtResolucionSistema = new javax.swing.JTextField();
        calendario = new com.toedter.calendar.JCalendar();
        jLabel6 = new javax.swing.JLabel();
        txtNumeroMaquina = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Configuración del sistema");
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

        jLabel3.setFont(new java.awt.Font("Taurus", 0, 32)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(152, 255, 89));
        jLabel3.setText("Configuracion del sistema");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel4.setFont(new java.awt.Font("Taurus", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(152, 255, 89));
        jLabel4.setText("Numero de resolucion:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 200, -1));
        jPanel1.add(txtResolucionSistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 190, -1));

        calendario.setBackground(new java.awt.Color(0, 0, 0));
        calendario.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        calendario.setDecorationBackgroundColor(new java.awt.Color(152, 255, 89));
        calendario.setWeekOfYearVisible(false);
        calendario.setWeekdayForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(calendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 380, 240));

        jLabel6.setFont(new java.awt.Font("Taurus", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(152, 255, 89));
        jLabel6.setText("Numero de maquina/computadora:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 300, -1));

        txtNumeroMaquina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumeroMaquinaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroMaquinaKeyTyped(evt);
            }
        });
        jPanel1.add(txtNumeroMaquina, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 90, -1));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ButtonSaveMaster.png"))); // NOI18N
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setFocusPainted(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 140, 50));

        jLabel5.setFont(new java.awt.Font("Taurus", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(152, 255, 89));
        jLabel5.setText("Fecha de autorizacion:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, -1, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/JIFMaster_fondoSistema.png"))); // NOI18N
        jPanel1.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 530));

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
        controlVentanaSistema = false;
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (txtResolucionSistema.getText().equals("")) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Especificar el numero de resolucion para el sistema");
            return;
        }

        if (txtNumeroMaquina.getText().equals("")) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Especificar el numero de la máquina o equipo");
            return;
        }

        java.util.Date fechaActual = new java.util.Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        formateador.format(fechaActual);
        java.sql.Date sqlFechaActual = new java.sql.Date(fechaActual.getTime());

        java.util.Date fechaAutorizacion = calendario.getDate();
        java.sql.Date sqlFechaAutorizacion = new java.sql.Date(fechaAutorizacion.getTime());

        if (sqlFechaAutorizacion.equals("")) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Especificar la fecha de autorización");
            return;
        } else if (sqlFechaAutorizacion.compareTo(sqlFechaActual) > 0) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "La fecha de autorización no es válida");
            return;
        }

        ControladorConfigSistema cS = new ControladorConfigSistema(txtResolucionSistema.getText(), sqlFechaAutorizacion, Integer.parseInt(txtNumeroMaquina.getText()));
        cS.configurarSistema(cS);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtNumeroMaquinaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroMaquinaKeyTyped
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
    }//GEN-LAST:event_txtNumeroMaquinaKeyTyped

    private void txtNumeroMaquinaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroMaquinaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            backspace = 1;
            return;
        }
    }//GEN-LAST:event_txtNumeroMaquinaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnGuardar;
    private com.toedter.calendar.JCalendar calendario;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JTextField txtNumeroMaquina;
    private javax.swing.JTextField txtResolucionSistema;
    // End of variables declaration//GEN-END:variables
}
