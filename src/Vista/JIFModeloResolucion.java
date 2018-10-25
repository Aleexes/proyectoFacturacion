/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorModeloResolucion;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import Vista.MDI.*;

/**
 *
 * @author alexc
 */
public class JIFModeloResolucion extends javax.swing.JInternalFrame{

    int backspace = 0;
    static public boolean controlVentanaModeloResolucion;

    public JIFModeloResolucion() {
        initComponents();
        controlVentanaModeloResolucion = true;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        calendario = new com.toedter.calendar.JCalendar();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tipoDocumento = new javax.swing.JComboBox<>();
        txtNumeroSerie = new javax.swing.JTextField();
        txtNumeroFinal = new javax.swing.JTextField();
        txtNumeroInicial = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        txtNumeroResolucion = new javax.swing.JTextField();
        fondo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Modelo de resolución ");
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

        jLabel1.setFont(new java.awt.Font("Taurus", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 51));
        jLabel1.setText("Modelo de resolucion");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Taurus", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 51));
        jLabel2.setText("Numero de resolucion:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 200, -1));

        jLabel3.setFont(new java.awt.Font("Taurus", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 51));
        jLabel3.setText("Fecha de autorizacion:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));

        calendario.setBackground(new java.awt.Color(0, 0, 0));
        calendario.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        calendario.setDecorationBackgroundColor(new java.awt.Color(255, 255, 102));
        calendario.setWeekOfYearVisible(false);
        calendario.setWeekdayForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(calendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 121, 380, 240));

        jLabel4.setFont(new java.awt.Font("Taurus", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 51));
        jLabel4.setText("Numero de serie:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        jLabel5.setFont(new java.awt.Font("Taurus", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 51));
        jLabel5.setText("Numero inicial:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        jLabel6.setFont(new java.awt.Font("Taurus", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 51));
        jLabel6.setText("Numero final:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        jLabel7.setFont(new java.awt.Font("Taurus", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 51));
        jLabel7.setText("Tipo de documento:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, -1, -1));

        tipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Factura", "Nota de crédito", "Nota de débito" }));
        tipoDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoDocumentoActionPerformed(evt);
            }
        });
        jPanel1.add(tipoDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, 190, -1));

        txtNumeroSerie.setText("axf");
        txtNumeroSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroSerieActionPerformed(evt);
            }
        });
        jPanel1.add(txtNumeroSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 190, -1));

        txtNumeroFinal.setText("1000");
        txtNumeroFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumeroFinalKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroFinalKeyTyped(evt);
            }
        });
        jPanel1.add(txtNumeroFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 190, -1));

        txtNumeroInicial.setText("12");
        txtNumeroInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumeroInicialKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroInicialKeyTyped(evt);
            }
        });
        jPanel1.add(txtNumeroInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 190, -1));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ButtonSave.png"))); // NOI18N
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setFocusPainted(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 510, 140, 50));

        txtNumeroResolucion.setText("666");
        jPanel1.add(txtNumeroResolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 60, 190, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/JIFModeloResolucion.png"))); // NOI18N
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tipoDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoDocumentoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (txtNumeroInicial.getText().equals("")) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Especificar un numero inicial");
            return;
        }

        if (txtNumeroFinal.getText().equals("")) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Especificar un numero final");
            return;
        }

        java.util.Date fechaActual = new java.util.Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        formateador.format(fechaActual);
        java.sql.Date sqlFechaActual = new java.sql.Date(fechaActual.getTime());

        java.util.Date fechaAutorizacion = calendario.getDate();
        java.sql.Date sqlFechaAutorizacion = new java.sql.Date(fechaAutorizacion.getTime());

        ControladorModeloResolucion cMR = new ControladorModeloResolucion(txtNumeroResolucion.getText(), txtNumeroSerie.getText(), (String) tipoDocumento.getSelectedItem(),
                Integer.parseInt(txtNumeroInicial.getText()), Integer.parseInt(txtNumeroFinal.getText()), sqlFechaAutorizacion, sqlFechaActual);
        cMR.crearModeloResolucion(cMR);

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtNumeroInicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroInicialKeyTyped
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
    }//GEN-LAST:event_txtNumeroInicialKeyTyped

    private void txtNumeroFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroFinalKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            backspace = 1;
            return;
        }
    }//GEN-LAST:event_txtNumeroFinalKeyPressed

    private void txtNumeroFinalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroFinalKeyTyped
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
    }//GEN-LAST:event_txtNumeroFinalKeyTyped

    private void txtNumeroSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroSerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroSerieActionPerformed

    private void txtNumeroInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroInicialKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            backspace = 1;
            return;
        }
    }//GEN-LAST:event_txtNumeroInicialKeyPressed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        controlVentanaModeloResolucion = false;
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnGuardar;
    private com.toedter.calendar.JCalendar calendario;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> tipoDocumento;
    private javax.swing.JTextField txtNumeroFinal;
    private javax.swing.JTextField txtNumeroInicial;
    private javax.swing.JTextField txtNumeroResolucion;
    private javax.swing.JTextField txtNumeroSerie;
    // End of variables declaration//GEN-END:variables

}
