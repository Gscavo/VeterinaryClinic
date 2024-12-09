/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.gscavo.veterinaryclinic.view.panels.selectFromDatabase;

import java.awt.*;
import javax.swing.JFrame;
import lombok.Getter;
import lombok.Setter;
import org.gscavo.veterinaryclinic.controller.abstractions.BaseController;
import org.gscavo.veterinaryclinic.model.Appointment;
import org.gscavo.veterinaryclinic.model.Veterinarian;
import org.gscavo.veterinaryclinic.model.abstractions.BaseModel;
import org.gscavo.veterinaryclinic.utils.enums.Controllers;
import org.gscavo.veterinaryclinic.utils.enums.Models;
import org.gscavo.veterinaryclinic.view.dialog.SearchInfoOnDatabaseDialog;
import org.gscavo.veterinaryclinic.view.model_panel.AppointmentInputPanel;
import org.gscavo.veterinaryclinic.view.model_panel.abstractions.BaseInputPanel;

/**
 *
 * @author gscavo
 */
public class SelectFromDatabase<T extends BaseModel> extends javax.swing.JPanel {

    private BaseInputPanel parentInputPanel;

    private BaseController<T> controller;
    
    private Models model;
    
    @Getter
    private T data;
    
    private CardLayout cl ;
    
    /**
     * Creates new form SelectFromDatabase
     */
    public SelectFromDatabase() {
        this.model = Models.CLIENT;
        initComponents();
        initController();
        myInitComponents();
    }
    
    public SelectFromDatabase(Models model, T data) {
        this.model = model;
        initComponents();
        initController();
        myInitComponents();
        this.setData(data);
    }
    
    private void initController() {
        controller = (BaseController<T>) Controllers.getByName(model.getClassType());
                
    };
    
    private void myInitComponents() {
        cl = (CardLayout) this.mainPanel.getLayout();
    }
    
    private void flipCardLayout() { 
        cl.show(this.mainPanel, "selectedCard");
    }

    public void setData(Object data) {

        if (data == null) { return; }

        this.data = (T) data;

        this.itemNameField.setText(
                controller.getReadableIdentifier(this.data)
        );
        
        if (this.data.getId() != null) {
            this.flipCardLayout();
        }
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
        selectItem = new javax.swing.JButton();
        alreadySelectedPanel = new javax.swing.JPanel();
        changeButton = new javax.swing.JButton();
        itemNameField = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        mainPanel.setLayout(new java.awt.CardLayout());

        selectItem.setText("Selecionar");
        selectItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectItemActionPerformed(evt);
            }
        });
        mainPanel.add(selectItem, "default");

        alreadySelectedPanel.setLayout(new java.awt.BorderLayout(10, 0));

        changeButton.setText("Alterar");
        changeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeButtonActionPerformed(evt);
            }
        });
        alreadySelectedPanel.add(changeButton, java.awt.BorderLayout.EAST);

        itemNameField.setEditable(false);
        itemNameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemNameField.setText("item");
        alreadySelectedPanel.add(itemNameField, java.awt.BorderLayout.CENTER);

        mainPanel.add(alreadySelectedPanel, "selectedCard");

        add(mainPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void changeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeButtonActionPerformed
        new SearchInfoOnDatabaseDialog<>(
                (Frame) null,
                this,
                true,
                model
        ).setVisible(true);
    }//GEN-LAST:event_changeButtonActionPerformed

    private void selectItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectItemActionPerformed
        new SearchInfoOnDatabaseDialog<>(
                (Frame) null,
                this,
                true,
                model
        ).setVisible(true);
        
        flipCardLayout();
    }//GEN-LAST:event_selectItemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel alreadySelectedPanel;
    private javax.swing.JButton changeButton;
    private javax.swing.JTextField itemNameField;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton selectItem;
    // End of variables declaration//GEN-END:variables
}
