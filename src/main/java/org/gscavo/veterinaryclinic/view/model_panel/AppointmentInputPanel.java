/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.gscavo.veterinaryclinic.view.model_panel;

import lombok.Getter;
import org.gscavo.veterinaryclinic.controller.AppointmentController;
import org.gscavo.veterinaryclinic.model.Appointment;
import org.gscavo.veterinaryclinic.utils.enums.Controllers;
import org.gscavo.veterinaryclinic.view.model_panel.abstractions.BaseInputPanel;

/**
 *
 * @author gscavo
 */
public class AppointmentInputPanel extends javax.swing.JPanel implements BaseInputPanel {

    @Getter
    private Appointment data;

    @Getter
    private AppointmentController mainController;

    /**
     * Creates new form AddressInputPanel
     */
    public AppointmentInputPanel() {
        initComponents();
        initControllers();
        this.data = new Appointment();
    }

    public AppointmentInputPanel(Appointment appointment) {
        initComponents();
        initControllers();
        this.data = appointment;
    }

    private void initControllers() {
        this.mainController = (AppointmentController) Controllers.getByName(Appointment.class);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        appointmentHeaderLabel = new javax.swing.JLabel();
        appointmentPriceLabel = new javax.swing.JLabel();
        appointmentDateLabel = new javax.swing.JLabel();
        appointmentAnimalLabel = new javax.swing.JLabel();
        appointmentVeterinarianLabel = new javax.swing.JLabel();
        headerSeparator = new javax.swing.JSeparator();
        appointmentTutorLabel = new javax.swing.JLabel();
        appointmentAnimalSelection = new javax.swing.JComboBox<>();
        appointmentTutorSelection = new javax.swing.JComboBox<>();
        appointmentVeterinarianSelection = new javax.swing.JComboBox<>();
        appointmentPriceInputField = new javax.swing.JSpinner();
        appointmentDateSelection = new javax.swing.JComboBox<>();

        appointmentHeaderLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        appointmentHeaderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appointmentHeaderLabel.setText("Consulta");
        appointmentHeaderLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        appointmentHeaderLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        appointmentHeaderLabel.setSize(new java.awt.Dimension(150, 30));

        appointmentPriceLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        appointmentPriceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appointmentPriceLabel.setText("Preço");
        appointmentPriceLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        appointmentPriceLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        appointmentPriceLabel.setSize(new java.awt.Dimension(150, 30));

        appointmentDateLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        appointmentDateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appointmentDateLabel.setText("Data");
        appointmentDateLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        appointmentDateLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        appointmentDateLabel.setSize(new java.awt.Dimension(150, 30));

        appointmentAnimalLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        appointmentAnimalLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appointmentAnimalLabel.setText("Animal");
        appointmentAnimalLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        appointmentAnimalLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        appointmentAnimalLabel.setSize(new java.awt.Dimension(150, 30));

        appointmentVeterinarianLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        appointmentVeterinarianLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appointmentVeterinarianLabel.setText("Veterinário");
        appointmentVeterinarianLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        appointmentVeterinarianLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        appointmentVeterinarianLabel.setSize(new java.awt.Dimension(150, 30));

        appointmentTutorLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        appointmentTutorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appointmentTutorLabel.setText("Tutor");
        appointmentTutorLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        appointmentTutorLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        appointmentTutorLabel.setSize(new java.awt.Dimension(150, 30));

        appointmentAnimalSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ERROR" }));
        appointmentAnimalSelection.setPreferredSize(new java.awt.Dimension(300, 30));
        appointmentAnimalSelection.setSize(new java.awt.Dimension(300, 30));
        appointmentAnimalSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appointmentAnimalSelectionActionPerformed(evt);
            }
        });

        appointmentTutorSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ERROR" }));
        appointmentTutorSelection.setPreferredSize(new java.awt.Dimension(300, 30));
        appointmentTutorSelection.setSize(new java.awt.Dimension(300, 30));
        appointmentTutorSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appointmentTutorSelectionActionPerformed(evt);
            }
        });

        appointmentVeterinarianSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ERROR" }));
        appointmentVeterinarianSelection.setPreferredSize(new java.awt.Dimension(300, 30));
        appointmentVeterinarianSelection.setSize(new java.awt.Dimension(300, 30));
        appointmentVeterinarianSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appointmentVeterinarianSelectionActionPerformed(evt);
            }
        });

        appointmentPriceInputField.setModel(new javax.swing.SpinnerNumberModel(0.0f, null, null, 1.0f));
        appointmentPriceInputField.setEnabled(false);
        appointmentPriceInputField.setPreferredSize(new java.awt.Dimension(300, 30));
        appointmentPriceInputField.setSize(new java.awt.Dimension(300, 30));

        appointmentDateSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ERROR" }));
        appointmentDateSelection.setPreferredSize(new java.awt.Dimension(300, 30));
        appointmentDateSelection.setSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(appointmentDateLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                .addComponent(appointmentPriceLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(appointmentVeterinarianLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(appointmentVeterinarianSelection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(appointmentPriceInputField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(appointmentDateSelection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(headerSeparator, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(appointmentHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(appointmentTutorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(appointmentTutorSelection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(appointmentAnimalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(appointmentAnimalSelection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(appointmentHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(headerSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(appointmentPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appointmentPriceInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(appointmentDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appointmentDateSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(appointmentVeterinarianLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appointmentVeterinarianSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(appointmentAnimalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appointmentAnimalSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(appointmentTutorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appointmentTutorSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void appointmentAnimalSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appointmentAnimalSelectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_appointmentAnimalSelectionActionPerformed

    private void appointmentTutorSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appointmentTutorSelectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_appointmentTutorSelectionActionPerformed

    private void appointmentVeterinarianSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appointmentVeterinarianSelectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_appointmentVeterinarianSelectionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel appointmentAnimalLabel;
    private javax.swing.JComboBox<String> appointmentAnimalSelection;
    private javax.swing.JLabel appointmentDateLabel;
    private javax.swing.JComboBox<String> appointmentDateSelection;
    private javax.swing.JLabel appointmentHeaderLabel;
    private javax.swing.JSpinner appointmentPriceInputField;
    private javax.swing.JLabel appointmentPriceLabel;
    private javax.swing.JLabel appointmentTutorLabel;
    private javax.swing.JComboBox<String> appointmentTutorSelection;
    private javax.swing.JLabel appointmentVeterinarianLabel;
    private javax.swing.JComboBox<String> appointmentVeterinarianSelection;
    private javax.swing.JSeparator headerSeparator;
    // End of variables declaration//GEN-END:variables
}
