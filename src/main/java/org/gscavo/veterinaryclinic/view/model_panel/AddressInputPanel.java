/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.gscavo.veterinaryclinic.view.model_panel;

import lombok.Getter;
import org.gscavo.veterinaryclinic.model.Address;
import org.gscavo.veterinaryclinic.utils.ViewUtils;
import org.gscavo.veterinaryclinic.view.model_panel.abstractions.BaseInputPanel;

/**
 *
 * @author gscavo
 */
public class AddressInputPanel extends javax.swing.JPanel implements BaseInputPanel<Address> {

    @Getter
    private Address data;
    
    /**
     * Creates new form AddressInputPanel
     */
    public AddressInputPanel() {
        initComponents();
        this.data = new Address();
    }
    
    public AddressInputPanel(Address address) {
        initComponents();
        this.data = address;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addressHeaderLabel = new javax.swing.JLabel();
        cepLabel = new javax.swing.JLabel();
        numberLabel = new javax.swing.JLabel();
        streetLabel = new javax.swing.JLabel();
        neighborhoodLabel = new javax.swing.JLabel();
        citylabel = new javax.swing.JLabel();
        stateLabel = new javax.swing.JLabel();
        cepInputField = new javax.swing.JTextField();
        streetInputField = new javax.swing.JTextField();
        neighborhoodInputField = new javax.swing.JTextField();
        cityInputField = new javax.swing.JTextField();
        stateInputField = new javax.swing.JTextField();
        numberInputField = new javax.swing.JSpinner();
        headerSeparator = new javax.swing.JSeparator();

        addressHeaderLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        addressHeaderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addressHeaderLabel.setText("Endereço");
        addressHeaderLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        addressHeaderLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        addressHeaderLabel.setSize(new java.awt.Dimension(150, 30));

        cepLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cepLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cepLabel.setText("CEP");
        cepLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        cepLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        cepLabel.setSize(new java.awt.Dimension(150, 30));

        numberLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        numberLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numberLabel.setText("Número");
        numberLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        numberLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        numberLabel.setSize(new java.awt.Dimension(150, 30));

        streetLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        streetLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        streetLabel.setText("Rua");
        streetLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        streetLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        streetLabel.setSize(new java.awt.Dimension(150, 30));

        neighborhoodLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        neighborhoodLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        neighborhoodLabel.setText("Bairro");
        neighborhoodLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        neighborhoodLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        neighborhoodLabel.setSize(new java.awt.Dimension(150, 30));

        citylabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        citylabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        citylabel.setText("Cidade");
        citylabel.setMaximumSize(new java.awt.Dimension(150, 30));
        citylabel.setPreferredSize(new java.awt.Dimension(150, 30));
        citylabel.setSize(new java.awt.Dimension(150, 30));

        stateLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        stateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stateLabel.setText("Estado");
        stateLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        stateLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        stateLabel.setSize(new java.awt.Dimension(150, 30));

        cepInputField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cepInputField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        cepInputField.setPreferredSize(new java.awt.Dimension(300, 30));
        cepInputField.setSize(new java.awt.Dimension(300, 30));
        cepInputField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cepInputFieldMouseReleased(evt);
            }
        });

        streetInputField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        streetInputField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        streetInputField.setPreferredSize(new java.awt.Dimension(300, 30));
        streetInputField.setSize(new java.awt.Dimension(300, 30));
        streetInputField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                streetInputFieldKeyReleased(evt);
            }
        });

        neighborhoodInputField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        neighborhoodInputField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        neighborhoodInputField.setPreferredSize(new java.awt.Dimension(300, 30));
        neighborhoodInputField.setSize(new java.awt.Dimension(300, 30));
        neighborhoodInputField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                neighborhoodInputFieldKeyReleased(evt);
            }
        });

        cityInputField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cityInputField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        cityInputField.setPreferredSize(new java.awt.Dimension(300, 30));
        cityInputField.setSize(new java.awt.Dimension(300, 30));
        cityInputField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cityInputFieldKeyReleased(evt);
            }
        });

        stateInputField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        stateInputField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        stateInputField.setPreferredSize(new java.awt.Dimension(300, 30));
        stateInputField.setSize(new java.awt.Dimension(300, 30));
        stateInputField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stateInputFieldKeyReleased(evt);
            }
        });

        numberInputField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        numberInputField.setPreferredSize(new java.awt.Dimension(300, 30));
        numberInputField.setSize(new java.awt.Dimension(300, 30));
        numberInputField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numberInputFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(addressHeaderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(stateLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                            .addComponent(citylabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(neighborhoodLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(streetLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(numberLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(cepLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(streetInputField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(neighborhoodInputField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cityInputField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(stateInputField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(numberInputField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cepInputField, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)))
                    .addComponent(headerSeparator))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addressHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(headerSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cepInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cepLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(numberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(numberInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(streetLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(streetInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(neighborhoodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(neighborhoodInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(citylabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cityInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stateInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cepInputFieldMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cepInputFieldMouseReleased
        this.data.setZipCode(
                this.cepInputField.getText()
        );
    }//GEN-LAST:event_cepInputFieldMouseReleased

    private void numberInputFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numberInputFieldKeyReleased
        this.data.setNumber(
                ViewUtils.getIntFromJSpinner(this.numberInputField)
        );
    }//GEN-LAST:event_numberInputFieldKeyReleased

    private void streetInputFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_streetInputFieldKeyReleased
        this.data.setStreet(
            this.streetInputField.getText()
        );
    }//GEN-LAST:event_streetInputFieldKeyReleased

    private void neighborhoodInputFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_neighborhoodInputFieldKeyReleased
        this.data.setNeighborhood(
                this.neighborhoodInputField.getText()
        );
    }//GEN-LAST:event_neighborhoodInputFieldKeyReleased

    private void cityInputFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cityInputFieldKeyReleased
        this.data.setCity(
                this.cityInputField.getText()
        );
    }//GEN-LAST:event_cityInputFieldKeyReleased

    private void stateInputFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stateInputFieldKeyReleased
        this.data.setState(
                this.stateInputField.getText()
        );
    }//GEN-LAST:event_stateInputFieldKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressHeaderLabel;
    private javax.swing.JTextField cepInputField;
    private javax.swing.JLabel cepLabel;
    private javax.swing.JTextField cityInputField;
    private javax.swing.JLabel citylabel;
    private javax.swing.JSeparator headerSeparator;
    private javax.swing.JTextField neighborhoodInputField;
    private javax.swing.JLabel neighborhoodLabel;
    private javax.swing.JSpinner numberInputField;
    private javax.swing.JLabel numberLabel;
    private javax.swing.JTextField stateInputField;
    private javax.swing.JLabel stateLabel;
    private javax.swing.JTextField streetInputField;
    private javax.swing.JLabel streetLabel;
    // End of variables declaration//GEN-END:variables
}
