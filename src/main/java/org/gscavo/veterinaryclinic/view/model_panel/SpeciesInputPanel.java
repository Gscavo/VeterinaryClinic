/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.gscavo.veterinaryclinic.view.model_panel;

/**
 *
 * @author gscavo
 */
public class SpeciesInputPanel extends javax.swing.JPanel {

    /**
     * Creates new form AddressInputPanel
     */
    public SpeciesInputPanel() {
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

        procedureTypeButtonGroup = new javax.swing.ButtonGroup();
        speciesHeaderLabel = new javax.swing.JLabel();
        speciesNameLabel = new javax.swing.JLabel();
        speciesDescriptionLabel = new javax.swing.JLabel();
        speciesNameInputField = new javax.swing.JTextField();
        headerSeparator = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        speciesDescriptionTextArea = new javax.swing.JTextArea();
        speciesScientificNameLabel = new javax.swing.JLabel();
        speciesScientificNameInputField = new javax.swing.JTextField();

        speciesHeaderLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        speciesHeaderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        speciesHeaderLabel.setText("Espécie");
        speciesHeaderLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        speciesHeaderLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        speciesHeaderLabel.setSize(new java.awt.Dimension(150, 30));

        speciesNameLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        speciesNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        speciesNameLabel.setText("Nome");
        speciesNameLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        speciesNameLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        speciesNameLabel.setSize(new java.awt.Dimension(150, 30));

        speciesDescriptionLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        speciesDescriptionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        speciesDescriptionLabel.setText("Descrição");
        speciesDescriptionLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        speciesDescriptionLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        speciesDescriptionLabel.setSize(new java.awt.Dimension(150, 30));

        speciesNameInputField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        speciesNameInputField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        speciesNameInputField.setPreferredSize(new java.awt.Dimension(150, 30));
        speciesNameInputField.setSize(new java.awt.Dimension(300, 30));
        speciesNameInputField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speciesNameInputFieldActionPerformed(evt);
            }
        });

        speciesDescriptionTextArea.setColumns(20);
        speciesDescriptionTextArea.setRows(5);
        jScrollPane1.setViewportView(speciesDescriptionTextArea);

        speciesScientificNameLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        speciesScientificNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        speciesScientificNameLabel.setText("Nome Cientifico");
        speciesScientificNameLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        speciesScientificNameLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        speciesScientificNameLabel.setSize(new java.awt.Dimension(150, 30));

        speciesScientificNameInputField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        speciesScientificNameInputField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        speciesScientificNameInputField.setPreferredSize(new java.awt.Dimension(150, 30));
        speciesScientificNameInputField.setSize(new java.awt.Dimension(300, 30));
        speciesScientificNameInputField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speciesScientificNameInputFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headerSeparator)
                    .addComponent(speciesHeaderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(speciesDescriptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                            .addComponent(speciesNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(speciesScientificNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(speciesScientificNameInputField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(speciesNameInputField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(speciesHeaderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(headerSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(speciesNameInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(speciesNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(speciesScientificNameInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(speciesScientificNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(speciesDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void speciesNameInputFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speciesNameInputFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_speciesNameInputFieldActionPerformed

    private void speciesScientificNameInputFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speciesScientificNameInputFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_speciesScientificNameInputFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator headerSeparator;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.ButtonGroup procedureTypeButtonGroup;
    private javax.swing.JLabel speciesDescriptionLabel;
    private javax.swing.JTextArea speciesDescriptionTextArea;
    private javax.swing.JLabel speciesHeaderLabel;
    private javax.swing.JTextField speciesNameInputField;
    private javax.swing.JLabel speciesNameLabel;
    private javax.swing.JTextField speciesScientificNameInputField;
    private javax.swing.JLabel speciesScientificNameLabel;
    // End of variables declaration//GEN-END:variables
}
