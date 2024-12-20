/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.gscavo.veterinaryclinic.view.model_panel;

import lombok.Getter;
import org.gscavo.veterinaryclinic.controller.ClientController;
import org.gscavo.veterinaryclinic.controller.SecretaryController;
import org.gscavo.veterinaryclinic.model.Client;
import org.gscavo.veterinaryclinic.model.Secretary;
import org.gscavo.veterinaryclinic.utils.enums.Controllers;
import org.gscavo.veterinaryclinic.utils.enums.PersonType;
import org.gscavo.veterinaryclinic.view.model_panel.abstractions.BaseInputPanel;

/**
 *
 * @author gscavo
 */
public class SecretaryInputPanel extends javax.swing.JPanel implements BaseInputPanel<Secretary> {

    @Getter
    private SecretaryController mainController;
    
    /**
     * Creates new form ClientInputPanel
     */
    public SecretaryInputPanel() {
        initComponents();
        initControllers();
        myInitComponents();
        this.personInputPanel1.setData(new Secretary());
    }
    
    public SecretaryInputPanel(Secretary secretary) {
        initComponents();
        initControllers();
        myInitComponents();
        this.personInputPanel1.setData(secretary);
    }

    private void initControllers() {
        this.mainController = (SecretaryController) Controllers.getByName(Secretary.class);
    };

    private void myInitComponents() {
    }

    public Secretary getData() {
        return (Secretary) this.personInputPanel1.getData();
    }

    public void setData(Secretary secretary) {
        assert secretary.getType() == PersonType.SECRETARY;

        this.personInputPanel1.setData(secretary);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        personInputPanel1 = new org.gscavo.veterinaryclinic.view.model_panel.abstractions.PersonInputPanel();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(personInputPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(personInputPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.gscavo.veterinaryclinic.view.model_panel.abstractions.PersonInputPanel personInputPanel1;
    // End of variables declaration//GEN-END:variables
}
