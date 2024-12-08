/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.gscavo.veterinaryclinic.view.model_panel.abstractions;

import lombok.Getter;
import lombok.Setter;
import org.gscavo.veterinaryclinic.controller.UserController;
import org.gscavo.veterinaryclinic.model.User;
import org.gscavo.veterinaryclinic.model.abstractions.Person;
import org.gscavo.veterinaryclinic.utils.enums.Controllers;

/**
 *
 * @author gscavo
 */
public class PersonInputPanel extends javax.swing.JPanel implements BaseInputPanel<Person> {

    @Getter @Setter
    private Person data;

    @Getter
    private UserController mainController;
    
    /**
     * Creates new form AddressInputPanel
     */
    public PersonInputPanel() {
        initComponents();
        initControllers();
        myInitComponents();
    }
    
    public <T extends Person> PersonInputPanel(T user) {
        this.data = user;
        initComponents();
        initControllers();
        myInitComponents();
    }

    private void initControllers() {
        this.mainController = (UserController) Controllers.getByName("USER");
    }

    private void myInitComponents() {
        if (this.data !=null && this.data.getId() != null) {
            this.personNameInputField.setText(this.data.getName());
            this.cpfInputField.setText(this.data.getCpf());
            this.emailInputField.setText(this.data.getEmail());
            this.telephoneInputField.setText(this.data.getPhoneNumber());
        }
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        personalDataHeaderLabel = new javax.swing.JLabel();
        personNameLabel = new javax.swing.JLabel();
        cpfLabel = new javax.swing.JLabel();
        telephoneLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        personNameInputField = new javax.swing.JTextField();
        cpfInputField = new javax.swing.JTextField();
        telephoneInputField = new javax.swing.JTextField();
        emailInputField = new javax.swing.JTextField();
        headerSeparator = new javax.swing.JSeparator();

        personalDataHeaderLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        personalDataHeaderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        personalDataHeaderLabel.setText("Dados Pessoais");
        personalDataHeaderLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        personalDataHeaderLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        personalDataHeaderLabel.setSize(new java.awt.Dimension(150, 30));

        personNameLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        personNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        personNameLabel.setText("Nome");
        personNameLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        personNameLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        personNameLabel.setSize(new java.awt.Dimension(150, 30));

        cpfLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cpfLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cpfLabel.setText("CPF");
        cpfLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        cpfLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        cpfLabel.setSize(new java.awt.Dimension(150, 30));

        telephoneLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        telephoneLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        telephoneLabel.setText("Telefone");
        telephoneLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        telephoneLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        telephoneLabel.setSize(new java.awt.Dimension(150, 30));

        emailLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        emailLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emailLabel.setText("Email");
        emailLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        emailLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        emailLabel.setSize(new java.awt.Dimension(150, 30));

        personNameInputField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        personNameInputField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        personNameInputField.setPreferredSize(new java.awt.Dimension(300, 30));
        personNameInputField.setSize(new java.awt.Dimension(300, 30));
        personNameInputField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                personNameInputFieldKeyReleased(evt);
            }
        });

        cpfInputField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cpfInputField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        cpfInputField.setPreferredSize(new java.awt.Dimension(300, 30));
        cpfInputField.setSize(new java.awt.Dimension(300, 30));
        cpfInputField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cpfInputFieldKeyReleased(evt);
            }
        });

        telephoneInputField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        telephoneInputField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        telephoneInputField.setPreferredSize(new java.awt.Dimension(300, 30));
        telephoneInputField.setSize(new java.awt.Dimension(300, 30));
        telephoneInputField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                telephoneInputFieldKeyReleased(evt);
            }
        });

        emailInputField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        emailInputField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        emailInputField.setPreferredSize(new java.awt.Dimension(300, 30));
        emailInputField.setSize(new java.awt.Dimension(300, 30));
        emailInputField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emailInputFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(personalDataHeaderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(emailLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                            .addComponent(telephoneLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(cpfLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(personNameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(telephoneInputField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(emailInputField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(personNameInputField, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                            .addComponent(cpfInputField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(headerSeparator))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(personalDataHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(headerSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(personNameInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(personNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpfLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpfInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telephoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telephoneInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void personNameInputFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_personNameInputFieldKeyReleased
        this.data.setName(
                personNameInputField.getText()
        );
    }//GEN-LAST:event_personNameInputFieldKeyReleased

    private void cpfInputFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpfInputFieldKeyReleased
        this.data.setCpf(
                cpfInputField.getText()
        );
    }//GEN-LAST:event_cpfInputFieldKeyReleased

    private void telephoneInputFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telephoneInputFieldKeyReleased
        this.data.setPhoneNumber(
            this.telephoneInputField.getText()
        );
    }//GEN-LAST:event_telephoneInputFieldKeyReleased

    private void emailInputFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailInputFieldKeyReleased
        this.data.setEmail(
                this.emailInputField.getText()
        );
    }//GEN-LAST:event_emailInputFieldKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cpfInputField;
    private javax.swing.JLabel cpfLabel;
    private javax.swing.JTextField emailInputField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JSeparator headerSeparator;
    private javax.swing.JTextField personNameInputField;
    private javax.swing.JLabel personNameLabel;
    private javax.swing.JLabel personalDataHeaderLabel;
    private javax.swing.JTextField telephoneInputField;
    private javax.swing.JLabel telephoneLabel;
    // End of variables declaration//GEN-END:variables
}
