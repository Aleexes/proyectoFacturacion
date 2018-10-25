package Vista;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author alexc
 */
public class JIFCompras extends javax.swing.JInternalFrame {

    int backspace = 0;
    int punto = 0;
    static public boolean controlVentanaCompras;

    public JIFCompras(){
        initComponents();
        controlVentanaCompras = true;
        txtNumCompra.setHorizontalAlignment(SwingConstants.CENTER);
        lblRestriccionCompraNoRegistrada1.setVisible(false);
        lblRestriccionCompraNoRegistrada2.setVisible(false);
        txtLACOMPRA.setVisible(false);
        txtNumCompra.setVisible(false);
        
        //compraSinRegistrarON();
        

    }

    private void compraSinRegistrarON(){
        lblRestriccionCompraNoRegistrada1.setVisible(true);
        lblRestriccionCompraNoRegistrada2.setVisible(true);
        txtLACOMPRA.setVisible(true);
        txtNumCompra.setVisible(true);
        ImageIcon imageicon = new ImageIcon(this.getClass().getResource("/imagenes/ButtonSaveBlock.png"));
        btnRegistrarCompra.setIcon(imageicon); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        txtNumeroFactura = new javax.swing.JTextField();
        txtMontoTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        calendarioFechaRealizacion = new com.toedter.calendar.JCalendar();
        btnRegistrarCompra = new javax.swing.JButton();
        txtLACOMPRA = new javax.swing.JLabel();
        txtNumCompra = new javax.swing.JLabel();
        lblRestriccionCompraNoRegistrada1 = new javax.swing.JLabel();
        lblRestriccionCompraNoRegistrada2 = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Registrar compra");
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

        lblTitulo.setFont(new java.awt.Font("Taurus", 0, 48)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 51));
        lblTitulo.setText("Registro de Compra");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 440, -1));
        jPanel1.add(txtNumeroFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 180, 30));

        txtMontoTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMontoTotalKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoTotalKeyTyped(evt);
            }
        });
        jPanel1.add(txtMontoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 150, 30));

        jLabel2.setFont(new java.awt.Font("Taurus", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 51));
        jLabel2.setText("Fecha de realizacion:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 230, -1));

        jLabel3.setFont(new java.awt.Font("Taurus", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 51));
        jLabel3.setText("Numero factura:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 180, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 51));
        jLabel4.setText("Q");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 30, -1));

        jLabel5.setFont(new java.awt.Font("Taurus", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 51));
        jLabel5.setText("Monto Total:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 140, -1));

        calendarioFechaRealizacion.setBackground(new java.awt.Color(255, 255, 0));
        calendarioFechaRealizacion.setDecorationBackgroundColor(new java.awt.Color(255, 255, 51));
        calendarioFechaRealizacion.setTodayButtonVisible(true);
        calendarioFechaRealizacion.setWeekOfYearVisible(false);
        jPanel1.add(calendarioFechaRealizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 340, 210));

        btnRegistrarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ButtonSave.png"))); // NOI18N
        btnRegistrarCompra.setBorderPainted(false);
        btnRegistrarCompra.setContentAreaFilled(false);
        btnRegistrarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCompraActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 140, 50));

        txtLACOMPRA.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtLACOMPRA.setForeground(new java.awt.Color(255, 102, 102));
        txtLACOMPRA.setText("La compra asociada a la factura #");
        jPanel1.add(txtLACOMPRA, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 320, 20));

        txtNumCompra.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtNumCompra.setForeground(new java.awt.Color(255, 102, 102));
        txtNumCompra.setText("123456789");
        jPanel1.add(txtNumCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, 110, 20));

        lblRestriccionCompraNoRegistrada1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblRestriccionCompraNoRegistrada1.setForeground(new java.awt.Color(255, 102, 102));
        lblRestriccionCompraNoRegistrada1.setText("Aun no ha sido ingresada al inventario");
        jPanel1.add(lblRestriccionCompraNoRegistrada1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, -1, 20));

        lblRestriccionCompraNoRegistrada2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblRestriccionCompraNoRegistrada2.setForeground(new java.awt.Color(255, 102, 102));
        lblRestriccionCompraNoRegistrada2.setText("¡Porfavor prodecer a ingresarla al inventario antes de registrar una nueva compra!");
        jPanel1.add(lblRestriccionCompraNoRegistrada2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 570, 20));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/JFICompras_fondo.png"))); // NOI18N
        jPanel1.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 430));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        controlVentanaCompras = false;
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnRegistrarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCompraActionPerformed
        
        if (txtNumeroFactura.getText().equals("")) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Indicar el numero de factura");
            return;
        }

        if (txtMontoTotal.getText().equals("")) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Indicar el monto total de la compra");
            return;
        }

        java.util.Date fechaAutorizacion = calendarioFechaRealizacion.getDate();
        java.sql.Date sqlFechaAutorizacion = new java.sql.Date(fechaAutorizacion.getTime());
        
        /*ControladorModeloResolucion cMR = new ControladorModeloResolucion(txtNumeroResolucion.getText(), txtNumeroSerie.getText(), (String) tipoDocumento.getSelectedItem(),
                Integer.parseInt(txtNumeroInicial.getText()), Integer.parseInt(txtNumeroFinal.getText()), sqlFechaAutorizacion, sqlFechaActual);
        cMR.crearModeloResolucion(cMR);*/

        
    }//GEN-LAST:event_btnRegistrarCompraActionPerformed

    private void txtMontoTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoTotalKeyTyped
        
        if (punto == 1) {
            punto = 0;
            return;
        }
        
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
    }//GEN-LAST:event_txtMontoTotalKeyTyped

    private void txtMontoTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoTotalKeyPressed
        
        if((evt.getKeyCode() == KeyEvent.VK_PERIOD) || (evt.getKeyCode() == KeyEvent.VK_DECIMAL)){
            punto = 1;
            return;
        }
              
        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            backspace = 1;
            return;
        }
    }//GEN-LAST:event_txtMontoTotalKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarCompra;
    private com.toedter.calendar.JCalendar calendarioFechaRealizacion;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblRestriccionCompraNoRegistrada1;
    private javax.swing.JLabel lblRestriccionCompraNoRegistrada2;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel txtLACOMPRA;
    private javax.swing.JTextField txtMontoTotal;
    private javax.swing.JLabel txtNumCompra;
    private javax.swing.JTextField txtNumeroFactura;
    // End of variables declaration//GEN-END:variables
}
