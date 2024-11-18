/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.gscavo.veterinaryclinic.view.model_panel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import lombok.Getter;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.controller.AnimalController;
import org.gscavo.veterinaryclinic.controller.ClientController;
import org.gscavo.veterinaryclinic.controller.SpeciesController;
import org.gscavo.veterinaryclinic.controller.UserController;
import org.gscavo.veterinaryclinic.model.Animal;
import org.gscavo.veterinaryclinic.model.Client;
import org.gscavo.veterinaryclinic.model.Species;
import org.gscavo.veterinaryclinic.model.abstractions.BaseModel;
import org.gscavo.veterinaryclinic.utils.StringUtils;
import org.gscavo.veterinaryclinic.utils.ViewUtils;
import org.gscavo.veterinaryclinic.utils.enums.Controllers;
import org.gscavo.veterinaryclinic.view.model_panel.abstractions.BaseInputPanel;

/**
 *
 * @author gscavo
 */
public class AnimalInputPanel extends javax.swing.JPanel implements BaseInputPanel<Animal> {

    @Getter
    private Animal data;
    
    private ArrayList<Client> tutorList;
    
    private ArrayList<Species> speciesList;
    
    @Getter
    private AnimalController  mainController;
    
    private ClientController clientController;
            
    private SpeciesController speciesController;
    
    /**
     * Creates new form AddressInputPanel
     */
    public AnimalInputPanel() {
        initComponents();
        initControllers();
        initSelections();
    }
    
    public AnimalInputPanel(Animal animal) {
        initComponents();
        initControllers();

        initSelections(this.data.getTutor(), this.data.getSpecies());

        this.data = animal;

        initSelections();
    }

    private void initControllers() {
        this.mainController = (AnimalController) Controllers.getByName(Animal.class);
        this.clientController = (ClientController) Controllers.getByName(Client.class);
        this.speciesController = (SpeciesController) Controllers.getByName(Species.class);
    }

    private void initSelections(ObjectId tutorId, ObjectId speciesId) {
        initSelections();
    }

    private void initSelections() {
        this.clientController = (ClientController) Controllers
                .getByName(Client.class);
        this.speciesController = (SpeciesController) Controllers
                .getByName(Species.class);

        this.data = new Animal();
        this.tutorList = this.clientController.getAll();
        this.speciesList = this.speciesController.getAll();


        ComboBoxModel<String> tutorModel = new DefaultComboBoxModel(
                IntStream
                        .range(0, this.tutorList.size())
                        .mapToObj(idx -> StringUtils.formatToSelection(idx, this.tutorList.get(idx).getName()))
                        .toList()
                        .toArray()
        );

        ComboBoxModel<String> speciesModel = new DefaultComboBoxModel(
                IntStream
                        .range(0, this.speciesList.size())
                        .mapToObj(idx -> StringUtils.formatToSelection(idx, this.speciesList.get(idx).getName()))
                        .toList()
                        .toArray()
        );

        this.data.setTutor(this.tutorList.get(0).getId());
        this.data.setSpecies(this.speciesList.get(0).getId());

        animalTutorSelection.setModel(tutorModel);
        animalSpeciesSelection.setModel(speciesModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        animalDataHeaderLabel = new javax.swing.JLabel();
        animalNameLabel = new javax.swing.JLabel();
        animalAgeLabel = new javax.swing.JLabel();
        animalSpeciesLabel = new javax.swing.JLabel();
        animalRaceLabel = new javax.swing.JLabel();
        animalNameInputField = new javax.swing.JTextField();
        animalAgeInputField = new javax.swing.JSpinner();
        headerSeparator = new javax.swing.JSeparator();
        animalRaceInputField = new javax.swing.JTextField();
        animalTutorLabel = new javax.swing.JLabel();
        animalSpeciesSelection = new javax.swing.JComboBox<>();
        animalTutorSelection = new javax.swing.JComboBox<>();

        animalDataHeaderLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        animalDataHeaderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        animalDataHeaderLabel.setText("Dados do Animal");
        animalDataHeaderLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        animalDataHeaderLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        animalDataHeaderLabel.setSize(new java.awt.Dimension(150, 30));

        animalNameLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        animalNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        animalNameLabel.setText("Nome");
        animalNameLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        animalNameLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        animalNameLabel.setSize(new java.awt.Dimension(150, 30));

        animalAgeLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        animalAgeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        animalAgeLabel.setText("Idade");
        animalAgeLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        animalAgeLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        animalAgeLabel.setSize(new java.awt.Dimension(150, 30));

        animalSpeciesLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        animalSpeciesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        animalSpeciesLabel.setText("Espécie");
        animalSpeciesLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        animalSpeciesLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        animalSpeciesLabel.setSize(new java.awt.Dimension(150, 30));

        animalRaceLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        animalRaceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        animalRaceLabel.setText("Raça");
        animalRaceLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        animalRaceLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        animalRaceLabel.setSize(new java.awt.Dimension(150, 30));

        animalNameInputField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        animalNameInputField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        animalNameInputField.setPreferredSize(new java.awt.Dimension(300, 30));
        animalNameInputField.setSize(new java.awt.Dimension(300, 30));
        animalNameInputField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                animalNameInputFieldKeyReleased(evt);
            }
        });

        animalAgeInputField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        animalAgeInputField.setModel(new javax.swing.SpinnerNumberModel());
        animalAgeInputField.setPreferredSize(new java.awt.Dimension(300, 30));
        animalAgeInputField.setSize(new java.awt.Dimension(300, 30));
        animalAgeInputField.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                animalAgeInputFieldStateChanged(evt);
            }
        });

        animalRaceInputField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        animalRaceInputField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        animalRaceInputField.setPreferredSize(new java.awt.Dimension(300, 30));
        animalRaceInputField.setSize(new java.awt.Dimension(300, 30));
        animalRaceInputField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                animalRaceInputFieldKeyReleased(evt);
            }
        });

        animalTutorLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        animalTutorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        animalTutorLabel.setText("Tutor");
        animalTutorLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        animalTutorLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        animalTutorLabel.setSize(new java.awt.Dimension(150, 30));

        animalSpeciesSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ERROR" }));
        animalSpeciesSelection.setPreferredSize(new java.awt.Dimension(300, 30));
        animalSpeciesSelection.setSize(new java.awt.Dimension(300, 30));
        animalSpeciesSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animalSpeciesSelectionActionPerformed(evt);
            }
        });

        animalTutorSelection.setPreferredSize(new java.awt.Dimension(300, 30));
        animalTutorSelection.setSize(new java.awt.Dimension(300, 30));
        animalTutorSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animalTutorSelectionActionPerformed(evt);
            }
        });

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
                                .addComponent(animalAgeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                .addComponent(animalNameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(animalRaceLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(animalAgeInputField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(animalNameInputField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(animalRaceInputField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(headerSeparator, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(animalDataHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(animalTutorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(animalTutorSelection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(animalSpeciesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(animalSpeciesSelection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(animalDataHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(headerSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(animalNameInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(animalNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(animalAgeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(animalAgeInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(animalRaceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(animalRaceInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(animalSpeciesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(animalSpeciesSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(animalTutorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(animalTutorSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void animalNameInputFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_animalNameInputFieldKeyReleased
        this.data.setName(
                this.animalNameInputField.getText()
        );
    }//GEN-LAST:event_animalNameInputFieldKeyReleased

    private void animalAgeInputFieldStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_animalAgeInputFieldStateChanged
        this.data.setAge(
                ViewUtils.getIntFromJSpinner(this.animalAgeInputField)
        );
    }//GEN-LAST:event_animalAgeInputFieldStateChanged

    private void animalRaceInputFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_animalRaceInputFieldKeyReleased
        this.data.setRace(
                this.animalRaceInputField.getText()
        );
    }//GEN-LAST:event_animalRaceInputFieldKeyReleased

    private void animalTutorSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_animalTutorSelectionActionPerformed
        Integer selectedIndex = this.animalTutorSelection.getSelectedIndex();
        
        this.data.setTutor(
                this.tutorList.get(selectedIndex).getId()
        );
    }//GEN-LAST:event_animalTutorSelectionActionPerformed

    private void animalSpeciesSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_animalSpeciesSelectionActionPerformed
        Integer selectedIndex = this.animalSpeciesSelection.getSelectedIndex();
        
        this.data.setSpecies(
                this.speciesList.get(selectedIndex).getId()
        );
    }//GEN-LAST:event_animalSpeciesSelectionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner animalAgeInputField;
    private javax.swing.JLabel animalAgeLabel;
    private javax.swing.JLabel animalDataHeaderLabel;
    private javax.swing.JTextField animalNameInputField;
    private javax.swing.JLabel animalNameLabel;
    private javax.swing.JTextField animalRaceInputField;
    private javax.swing.JLabel animalRaceLabel;
    private javax.swing.JLabel animalSpeciesLabel;
    private javax.swing.JComboBox<String> animalSpeciesSelection;
    private javax.swing.JLabel animalTutorLabel;
    private javax.swing.JComboBox<String> animalTutorSelection;
    private javax.swing.JSeparator headerSeparator;
    // End of variables declaration//GEN-END:variables
}
