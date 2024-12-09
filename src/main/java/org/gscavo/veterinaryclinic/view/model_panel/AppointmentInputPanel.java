/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.gscavo.veterinaryclinic.view.model_panel;

import java.awt.BorderLayout;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.IntStream;
import javax.swing.DefaultComboBoxModel;
import lombok.Getter;
import lombok.Setter;
import org.gscavo.veterinaryclinic.App;
import org.gscavo.veterinaryclinic.controller.*;
import org.gscavo.veterinaryclinic.model.*;
import org.gscavo.veterinaryclinic.utils.ConversionUtils;
import org.gscavo.veterinaryclinic.utils.StringUtils;
import org.gscavo.veterinaryclinic.utils.enums.Controllers;
import org.gscavo.veterinaryclinic.utils.enums.Models;
import org.gscavo.veterinaryclinic.view.model_panel.abstractions.BaseInputPanel;
import org.gscavo.veterinaryclinic.view.panels.selectFromDatabase.SelectFromDatabase;

/**
 *
 * @author gscavo
 */
public class AppointmentInputPanel extends javax.swing.JPanel implements BaseInputPanel<Appointment> {

    @Getter
    @Setter
    private Appointment data;

    @Getter
    private AppointmentController mainController;

    @Getter
    private ClientController clientController;
    
    @Getter
    private AnimalController animalController;

    @Getter
    private VeterinarianController veterinarianController;

    @Getter
    private SymptomController symptomController;

    @Getter
    private ProcedureController procedureController;

    private ArrayList<Veterinarian> veterinarians;
    private ArrayList<Client> clients;
    private ArrayList<Animal> animals;
    
    private String dayString;
    private String hourString;

    /**
     * Creates new form AddressInputPanel
     */
    public AppointmentInputPanel() {
        initControllers();
        initComponents();
        setData(new Appointment());
        myInitComponents();
    }

    public AppointmentInputPanel(Appointment appointment) {
        initControllers();
        initComponents();
        setData(appointment);
        myInitComponents();
    }
    

    private void initControllers() {
        this.mainController = (AppointmentController) Controllers.getByName(Appointment.class);
        this.clientController = (ClientController) Controllers.getByName(Client.class);
        this.animalController = (AnimalController) Controllers.getByName(Animal.class);
        this.veterinarianController = (VeterinarianController) Controllers.getByName(Veterinarian.class);
        this.symptomController = (SymptomController) Controllers.getByName(Symptom.class);
        this.procedureController = (ProcedureController) Controllers.getByName(Procedure.class);
    }
    
    private void myInitComponents() {
        updateDate();
        updateVeterinarian();
        updateTutor();
        updateAnimal(true);
        this.tutorPanel.add(
                new SelectFromDatabase(Models.CLIENT),
                BorderLayout.CENTER
        );
        this.veterinarianPanel.add(
                new SelectFromDatabase(Models.VETERINARIAN),
                BorderLayout.CENTER
        );
    }

    public void setData(Appointment appointment) {
        this.data = appointment;

        if (data.getId() != null) {
            this.appointmentPriceInputField.setValue(
                    this.data.getCostAmount()
            );
        }
    }

    private void updateDate() {
        ArrayList<String> dateFromServer = null;

        if (data != null && data.getId() != null) {
            dateFromServer = ConversionUtils.parseDayAndHourString(data.getDate());
        }

        this.appointmentDateSelection.setModel(
                new DefaultComboBoxModel<>(
                        this.mainController.getNextDates().toArray(new String[0])
                )
        );
        if (dateFromServer != null) {
            this.appointmentDateSelection.setSelectedItem(dateFromServer.get(0));
        }
        this.dayString = (String) this.appointmentDateSelection.getSelectedItem();

        this.appointmentHourSelection.setModel(
                new DefaultComboBoxModel<>(
                        this.mainController.getHours().toArray(new String[0])
                )
        );

        if (dateFromServer != null) {
            this.appointmentHourSelection.setSelectedItem(dateFromServer.get(1));
        }

        this.hourString = (String) this.appointmentHourSelection.getSelectedItem();

        updateDateOnData();
    }

    private void updateDateOnData() {
        if (dayString == null || hourString == null) {
            return;
        }
        try {
            Date date = ConversionUtils.parseBsonDateTime(this.dayString, this.hourString);

            this.data.setDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void updateVeterinarian() {

        this.veterinarians = this.veterinarianController.getAllForDatabaseTable();

        this.appointmentVeterinarianSelection.setModel(
                new DefaultComboBoxModel<>(
                        IntStream
                                .range(0, this.veterinarians.size())
                                .mapToObj(idx -> StringUtils.formatToSelection(idx, this.veterinarians.get(idx).getName()))
                                .toList()
                                .toArray(new String[0])
                )
        );

        if (data != null && data.getId() != null) {
            int indexOf = -1;

            for (int i = 0; i < veterinarians.size(); i++) {
                if (veterinarians.get(i).getId().equals(data.getVeterinarianId())) {
                    indexOf = i;
                    break;
                }
            }

            this.appointmentVeterinarianSelection
                .setSelectedIndex(
                    indexOf
                );
        }

        updateVeterinarianOnData();
    }

    private void updateVeterinarianOnData() {
        int selectedIndex = this.appointmentVeterinarianSelection.getSelectedIndex();

        if (selectedIndex == -1) { return; }

        Veterinarian selected = this.veterinarians.get(
                selectedIndex
        );

        this.data.setVeterinarianId(
                selected.getId()
        );
    }

    private void updateTutor() {
        this.clients = this.clientController.getAllForDatabaseTable();

        this.appointmentClientSelection.setModel(
                new DefaultComboBoxModel<>(
                        IntStream
                                .range(0, this.clients.size())
                                .mapToObj(idx -> StringUtils.formatToSelection(idx, this.clients.get(idx).getName()))
                                .toList()
                                .toArray(new String[0])

                )
        );

        if (data != null && data.getId() != null) {
            int indexOf = -1;

            for (int i = 0; i < clients.size(); i++) {
                if (clients.get(i).getId().equals(data.getClientId())) {
                    indexOf = i;
                    break;
                }
            }

            this.appointmentClientSelection
                    .setSelectedIndex(
                            indexOf
                    );
        }

        updateTutorOnData();
    }

    private void updateTutorOnData() {
        int selectedIndex = this.appointmentClientSelection.getSelectedIndex();

        if (selectedIndex == -1) { return; }

        Client selected = this.clients.get(
                selectedIndex
        );

        this.data.setClientId(
                selected.getId()
        );
    }

    private void updateAnimal(Boolean init) {
        this.animals = animalController.getAllByClientId(this.data.getClientId());

        this.appointmentAnimalSelection.setModel(
                new DefaultComboBoxModel<>(
                        IntStream
                                .range(0, this.animals.size())
                                .mapToObj(idx -> StringUtils.formatToSelection(idx, this.animals.get(idx).getName()))
                                .toList()
                                .toArray(new String[0])
                )
        );

        if (data != null && data.getId() != null && init) {
            int indexOf = -1;

            for (int i = 0; i < animals.size(); i++) {
                if (animals.get(i).getId().equals(data.getAnimalId())) {
                    indexOf = i;
                    break;
                }
            }

            this.appointmentAnimalSelection
                .setSelectedIndex(
                        indexOf
                );

        }

        updateAnimalOnData();
    }

    private void updateAnimalOnData() {
        int selectedIndex = this.appointmentAnimalSelection.getSelectedIndex();

        if (selectedIndex == -1) { return; }

        Animal selected = this.animals.get(
                selectedIndex
        );

        this.data.setAnimalId(
                selected.getId()
        );
    }

    private void updateCostOnData() {
        this.data.setCostAmount(
                (float) this.appointmentPriceInputField.getValue()
        );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        appointmentClientSelection = new javax.swing.JComboBox<>();
        appointmentVeterinarianSelection = new javax.swing.JComboBox<>();
        appointmentHeaderLabel = new javax.swing.JLabel();
        appointmentPriceLabel = new javax.swing.JLabel();
        appointmentDateLabel = new javax.swing.JLabel();
        appointmentAnimalLabel = new javax.swing.JLabel();
        appointmentVeterinarianLabel = new javax.swing.JLabel();
        headerSeparator = new javax.swing.JSeparator();
        appointmentTutorLabel = new javax.swing.JLabel();
        appointmentAnimalSelection = new javax.swing.JComboBox<>();
        appointmentPriceInputField = new javax.swing.JSpinner();
        appointmentDateSelection = new javax.swing.JComboBox<>();
        appointmentHourLabel = new javax.swing.JLabel();
        appointmentHourSelection = new javax.swing.JComboBox<>();
        tutorPanel = new javax.swing.JPanel();
        veterinarianPanel = new javax.swing.JPanel();

        appointmentClientSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ERROR" }));
        appointmentClientSelection.setPreferredSize(new java.awt.Dimension(300, 30));
        appointmentClientSelection.setSize(new java.awt.Dimension(300, 30));
        appointmentClientSelection.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                appointmentClientSelectionItemStateChanged(evt);
            }
        });

        appointmentVeterinarianSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ERROR" }));
        appointmentVeterinarianSelection.setPreferredSize(new java.awt.Dimension(300, 30));
        appointmentVeterinarianSelection.setSize(new java.awt.Dimension(300, 30));
        appointmentVeterinarianSelection.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                appointmentVeterinarianSelectionItemStateChanged(evt);
            }
        });

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

        appointmentAnimalSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um Cliente" }));
        appointmentAnimalSelection.setFocusCycleRoot(true);
        appointmentAnimalSelection.setPreferredSize(new java.awt.Dimension(300, 30));
        appointmentAnimalSelection.setSize(new java.awt.Dimension(300, 30));
        appointmentAnimalSelection.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                appointmentAnimalSelectionItemStateChanged(evt);
            }
        });

        appointmentPriceInputField.setModel(new javax.swing.SpinnerNumberModel(0.0f, null, null, 1.0f));
        appointmentPriceInputField.setPreferredSize(new java.awt.Dimension(300, 30));
        appointmentPriceInputField.setSize(new java.awt.Dimension(300, 30));
        appointmentPriceInputField.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                appointmentPriceInputFieldStateChanged(evt);
            }
        });

        appointmentDateSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ERROR" }));
        appointmentDateSelection.setPreferredSize(new java.awt.Dimension(300, 30));
        appointmentDateSelection.setSize(new java.awt.Dimension(300, 30));
        appointmentDateSelection.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                appointmentDateSelectionItemStateChanged(evt);
            }
        });

        appointmentHourLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        appointmentHourLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appointmentHourLabel.setText("Horário");
        appointmentHourLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        appointmentHourLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        appointmentHourLabel.setSize(new java.awt.Dimension(150, 30));

        appointmentHourSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ERROR" }));
        appointmentHourSelection.setPreferredSize(new java.awt.Dimension(300, 30));
        appointmentHourSelection.setSize(new java.awt.Dimension(300, 30));
        appointmentHourSelection.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                appointmentHourSelectionItemStateChanged(evt);
            }
        });

        tutorPanel.setPreferredSize(new java.awt.Dimension(300, 30));
        tutorPanel.setSize(new java.awt.Dimension(300, 30));
        tutorPanel.setLayout(new java.awt.BorderLayout());

        veterinarianPanel.setPreferredSize(new java.awt.Dimension(300, 30));
        veterinarianPanel.setSize(new java.awt.Dimension(300, 30));
        veterinarianPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headerSeparator, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(appointmentHeaderLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(appointmentAnimalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(appointmentAnimalSelection, 0, 312, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(appointmentDateLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                    .addComponent(appointmentPriceLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(appointmentHourLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                                .addComponent(appointmentVeterinarianLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(appointmentTutorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(appointmentPriceInputField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(appointmentDateSelection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(appointmentHourSelection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tutorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(veterinarianPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(appointmentHourLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appointmentHourSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(appointmentVeterinarianLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(veterinarianPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(appointmentTutorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tutorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(appointmentAnimalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appointmentAnimalSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void appointmentClientSelectionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_appointmentClientSelectionItemStateChanged
        updateTutorOnData();
        updateAnimal(false);
    }//GEN-LAST:event_appointmentClientSelectionItemStateChanged

    private void appointmentDateSelectionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_appointmentDateSelectionItemStateChanged
        // TODO add your handling code here:
        this.dayString = (String) this.appointmentDateSelection.getSelectedItem();
        updateDateOnData();
        
    }//GEN-LAST:event_appointmentDateSelectionItemStateChanged

    private void appointmentHourSelectionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_appointmentHourSelectionItemStateChanged
        this.hourString = (String) this.appointmentHourSelection.getSelectedItem();
        updateDateOnData();
    }//GEN-LAST:event_appointmentHourSelectionItemStateChanged

    private void appointmentVeterinarianSelectionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_appointmentVeterinarianSelectionItemStateChanged
        // TODO add your handling code here:
        updateVeterinarianOnData();
    }//GEN-LAST:event_appointmentVeterinarianSelectionItemStateChanged

    private void appointmentAnimalSelectionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_appointmentAnimalSelectionItemStateChanged
        // TODO add your handling code here:
        updateAnimalOnData();
    }//GEN-LAST:event_appointmentAnimalSelectionItemStateChanged

    private void appointmentPriceInputFieldStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_appointmentPriceInputFieldStateChanged
        // TODO add your handling code here:
        updateCostOnData();
    }//GEN-LAST:event_appointmentPriceInputFieldStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel appointmentAnimalLabel;
    private javax.swing.JComboBox<String> appointmentAnimalSelection;
    private javax.swing.JComboBox<String> appointmentClientSelection;
    private javax.swing.JLabel appointmentDateLabel;
    private javax.swing.JComboBox<String> appointmentDateSelection;
    private javax.swing.JLabel appointmentHeaderLabel;
    private javax.swing.JLabel appointmentHourLabel;
    private javax.swing.JComboBox<String> appointmentHourSelection;
    private javax.swing.JSpinner appointmentPriceInputField;
    private javax.swing.JLabel appointmentPriceLabel;
    private javax.swing.JLabel appointmentTutorLabel;
    private javax.swing.JLabel appointmentVeterinarianLabel;
    private javax.swing.JComboBox<String> appointmentVeterinarianSelection;
    private javax.swing.JSeparator headerSeparator;
    private javax.swing.JPanel tutorPanel;
    private javax.swing.JPanel veterinarianPanel;
    // End of variables declaration//GEN-END:variables
}
