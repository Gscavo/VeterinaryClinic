/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.gscavo.veterinaryclinic.view.panels;

/**
 *
 * @author gscavo
 */
public class LoginPanel extends javax.swing.JPanel {

    /**
     * Creates new form LoginPanel
     */
    public LoginPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        enterSystemLabel = new javax.swing.JLabel();
        loginEmailLabel = new javax.swing.JLabel();
        loginEmailInputField = new javax.swing.JTextField();
        loginPasswordLabel = new javax.swing.JLabel();
        signInButton = new javax.swing.JButton();
        jPasswordField2 = new javax.swing.JPasswordField();

        enterSystemLabel.setFont(new java.awt.Font("AppleGothic", 1, 18)); // NOI18N
        enterSystemLabel.setText("Entrar no Sistema Veterinario");

        loginEmailLabel.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 16)); // NOI18N
        loginEmailLabel.setText("Email");

        loginEmailInputField.setColumns(18);
        loginEmailInputField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginEmailInputFieldActionPerformed(evt);
            }
        });

        loginPasswordLabel.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 16)); // NOI18N
        loginPasswordLabel.setText("Senha");

        signInButton.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 18)); // NOI18N
        signInButton.setText("Entrar");
        signInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInButtonActionPerformed(evt);
            }
        });

        jPasswordField2.setPreferredSize(new java.awt.Dimension(212, 23));
        jPasswordField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(signInButton)
                    .addComponent(loginPasswordLabel)
                    .addComponent(loginEmailInputField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginEmailLabel)
                    .addComponent(enterSystemLabel)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(enterSystemLabel)
                .addGap(18, 18, 18)
                .addComponent(loginEmailLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginEmailInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginPasswordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(signInButton)
                .addContainerGap(40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loginEmailInputFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginEmailInputFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginEmailInputFieldActionPerformed

    private void signInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("Hello World!");
    }//GEN-LAST:event_signInButtonActionPerformed

    private void jPasswordField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel enterSystemLabel;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField loginEmailInputField;
    private javax.swing.JLabel loginEmailLabel;
    private javax.swing.JLabel loginPasswordLabel;
    private javax.swing.JButton signInButton;
    // End of variables declaration//GEN-END:variables
}
