/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Proyecto;

import javax.swing.JFrame;

/**
 *
 * @author agust
 */
public class Probabilidades extends javax.swing.JFrame {

    /**
     * Creates new form Probabilidades
     */
    public Probabilidades() {
        initComponents();
        setLocationRelativeTo(null); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iniciarBoton = new javax.swing.JButton();
        salirBoton = new javax.swing.JButton();
        creditosBoton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iniciarBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/INICIAR.png"))); // NOI18N
        iniciarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarBotonActionPerformed(evt);
            }
        });
        getContentPane().add(iniciarBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, 340, 120));

        salirBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/SALIR.png"))); // NOI18N
        salirBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBotonActionPerformed(evt);
            }
        });
        getContentPane().add(salirBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 560, 340, 120));

        creditosBoton.setBackground(new java.awt.Color(153, 255, 255));
        creditosBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/CREDITOS.png"))); // NOI18N
        creditosBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditosBotonActionPerformed(evt);
            }
        });
        getContentPane().add(creditosBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 430, 340, 120));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/PROBABILIDADES.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarBotonActionPerformed
        // TODO add your handling code here:
        Iniciar ventanaProbabilidades = new Iniciar();
        ventanaProbabilidades.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_iniciarBotonActionPerformed

    private void creditosBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditosBotonActionPerformed
        // TODO add your handling code here:
        Creditos ventanaProbabilidades = new Creditos();
        ventanaProbabilidades.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_creditosBotonActionPerformed

    private void salirBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBotonActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_salirBotonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Probabilidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Probabilidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Probabilidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Probabilidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Probabilidades().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton creditosBoton;
    private javax.swing.JButton iniciarBoton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton salirBoton;
    // End of variables declaration//GEN-END:variables
}
