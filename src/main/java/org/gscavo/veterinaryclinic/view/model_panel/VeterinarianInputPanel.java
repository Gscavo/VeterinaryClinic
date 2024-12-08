/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.gscavo.veterinaryclinic.view.model_panel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import lombok.Getter;
import lombok.Setter;
import org.gscavo.veterinaryclinic.controller.VeterinarianController;
import org.gscavo.veterinaryclinic.model.Veterinarian;
import org.gscavo.veterinaryclinic.utils.enums.Controllers;
import org.gscavo.veterinaryclinic.utils.enums.PersonType;
import org.gscavo.veterinaryclinic.view.model_panel.abstractions.BaseInputPanel;

/**
 *
 * @author gscavo
 */
public class VeterinarianInputPanel extends javax.swing.JPanel implements BaseInputPanel<Veterinarian> {

    @Getter
    @Setter
    private Veterinarian data;

    @Getter
    private VeterinarianController mainController;

    /**
     * Creates new form AddressInputPanel
     */
    public VeterinarianInputPanel() {
        initComponents();
        initControllers();
        this.data = new Veterinarian();
    }
    
    public VeterinarianInputPanel(Veterinarian veterinarian) {
        initComponents();
        myInitComponents();
        initControllers();
        this.data = veterinarian;
    }

    private void initControllers() {
        this.mainController = (VeterinarianController) Controllers.getByName(Veterinarian.class);
    }
    
    private void myInitComponents() {
        this.personInputPanel.addPropertyChangeListener(DATA_PROPERTY_KEY, new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                dataChangedOnPersonInputPanel(evt);
            }
        });
    }
    
    private void dataChangedOnPersonInputPanel(PropertyChangeEvent evt) {
        System.out.println("Changed");
        this.data.fill(
                this.personInputPanel.getData()
        );

        this.data.setType(PersonType.VETERINARIAN);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        procedureTypeButtonGroup = new javax.swing.ButtonGroup();
        specificPanel = new javax.swing.JPanel();
        veterinarianDataHeaderLabel = new javax.swing.JLabel();
        veterinariamCrmvLabel = new javax.swing.JLabel();
        veterinarianCrmvInputField = new javax.swing.JTextField();
        headerSeparator = new javax.swing.JSeparator();
        personInputPanel = new org.gscavo.veterinaryclinic.view.model_panel.abstractions.PersonInputPanel();

        setLayout(new java.awt.BorderLayout());

        veterinarianDataHeaderLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        veterinarianDataHeaderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        veterinarianDataHeaderLabel.setText("Dados do Veterinário");
        veterinarianDataHeaderLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        veterinarianDataHeaderLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        veterinarianDataHeaderLabel.setSize(new java.awt.Dimension(150, 30));

        veterinariamCrmvLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        veterinariamCrmvLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        veterinariamCrmvLabel.setText("CRMV");
        veterinariamCrmvLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        veterinariamCrmvLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        veterinariamCrmvLabel.setSize(new java.awt.Dimension(150, 30));

        veterinarianCrmvInputField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        veterinarianCrmvInputField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        veterinarianCrmvInputField.setPreferredSize(new java.awt.Dimension(150, 30));
        veterinarianCrmvInputField.setSize(new java.awt.Dimension(300, 30));
        veterinarianCrmvInputField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                veterinarianCrmvInputFieldMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout specificPanelLayout = new javax.swing.GroupLayout(specificPanel);
        specificPanel.setLayout(specificPanelLayout);
        specificPanelLayout.setHorizontalGroup(
            specificPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(specificPanelLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(veterinarianCrmvInputField, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(specificPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(specificPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(specificPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(veterinarianDataHeaderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                        .addGroup(specificPanelLayout.createSequentialGroup()
                            .addGroup(specificPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(headerSeparator)
                                .addComponent(veterinariamCrmvLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap()))))
        );
        specificPanelLayout.setVerticalGroup(
            specificPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(specificPanelLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(veterinarianCrmvInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(specificPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(specificPanelLayout.createSequentialGroup()
                    .addGap(13, 13, 13)
                    .addComponent(veterinarianDataHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(headerSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(veterinariamCrmvLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        add(specificPanel, java.awt.BorderLayout.CENTER);
        add(personInputPanel, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void veterinarianCrmvInputFieldMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_veterinarianCrmvInputFieldMouseReleased
        this.data.setCrmv(
                this.veterinarianCrmvInputField.getText()
        );
    }//GEN-LAST:event_veterinarianCrmvInputFieldMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator headerSeparator;
    private org.gscavo.veterinaryclinic.view.model_panel.abstractions.PersonInputPanel personInputPanel;
    private javax.swing.ButtonGroup procedureTypeButtonGroup;
    private javax.swing.JPanel specificPanel;
    private javax.swing.JLabel veterinariamCrmvLabel;
    private javax.swing.JTextField veterinarianCrmvInputField;
    private javax.swing.JLabel veterinarianDataHeaderLabel;
    // End of variables declaration//GEN-END:variables
}
