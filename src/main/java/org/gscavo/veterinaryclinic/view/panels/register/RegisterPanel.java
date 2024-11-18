/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.gscavo.veterinaryclinic.view.panels.register;

import javax.swing.JPanel;
import org.gscavo.veterinaryclinic.view.model_panel.abstractions.BaseInputPanel;

import java.awt.*;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.utils.ViewUtils;
import org.gscavo.veterinaryclinic.utils.enums.Models;
import org.gscavo.veterinaryclinic.utils.exceptions.ExceptionOutput;
import org.gscavo.veterinaryclinic.utils.information.SystemOperationResult;

/**
 *
 * @author gscavo
 */
public class RegisterPanel extends javax.swing.JPanel {

    private final String CARD_NAME = "inputPanelCard";

    private BaseInputPanel baseInputPanel;

    /**
     * Creates new form RegisterPanel
     */
    public RegisterPanel() {
        initComponents();
    }
    
    public <T extends JPanel> RegisterPanel(Models model) {
        initComponents();
        try {
            T panel = (T) model.getInputPanelClass().getDeclaredConstructor().newInstance();
            if (panel instanceof BaseInputPanel) {
                this.baseInputPanel = (BaseInputPanel<?>) panel;
            } else {
                System.err.println("Panel: " + panel.getClass().getSimpleName() + " doesn't implements BaseInputPanel");
            }        
        
            mainPanel.add(panel, BorderLayout.CENTER);
        } catch (Exception e) {
            ExceptionOutput.showExceptionErr(e);
        }

        
    }
    
    public <T extends JPanel> RegisterPanel(T panel) {
        initComponents();

        if (panel instanceof BaseInputPanel) {
            this.baseInputPanel = (BaseInputPanel<?>) panel;
        } else {
            System.err.println("Panel: " + panel.getClass().getSimpleName() + " doesn't implements BaseInputPanel");
        }        
        
        mainPanel.add(panel, BorderLayout.CENTER);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        buttonRow = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(420, 420));
        setLayout(new java.awt.BorderLayout());

        mainPanel.setRequestFocusEnabled(false);
        mainPanel.setLayout(new java.awt.BorderLayout());
        add(mainPanel, java.awt.BorderLayout.CENTER);

        buttonRow.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        cancelButton.setText("Cancelar");
        cancelButton.setPreferredSize(new java.awt.Dimension(100, 25));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        buttonRow.add(cancelButton);

        registerButton.setText("Cadastrar");
        registerButton.setPreferredSize(new java.awt.Dimension(100, 25));
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });
        buttonRow.add(registerButton);

        add(buttonRow, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        ViewUtils.closeWindow(evt);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        SystemOperationResult<ObjectId> res = this.baseInputPanel.getMainController()
                .register(this.baseInputPanel.getData());

        ViewUtils.showInformationDialog(this, res);

    }//GEN-LAST:event_registerButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonRow;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton registerButton;
    // End of variables declaration//GEN-END:variables
}
