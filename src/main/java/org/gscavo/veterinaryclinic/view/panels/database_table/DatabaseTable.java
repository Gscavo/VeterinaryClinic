/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.gscavo.veterinaryclinic.view.panels.database_table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.stream.IntStream;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.TableModel;
import lombok.Getter;
import lombok.Setter;
import org.gscavo.veterinaryclinic.controller.abstractions.BaseController;
import org.gscavo.veterinaryclinic.dao.BaseDAO;
import org.gscavo.veterinaryclinic.utils.ObjectUtils;
import org.gscavo.veterinaryclinic.utils.StringUtils;
import org.gscavo.veterinaryclinic.utils.ViewUtils;
import org.gscavo.veterinaryclinic.utils.enums.Controllers;
import org.gscavo.veterinaryclinic.utils.enums.Models;

/**
 *
 * @author gscavo
 */
public class DatabaseTable<T> extends javax.swing.JPanel {

    private final Class<T> classType;

    private final BaseController<T> CONTROLLER; 
    
    @Getter @Setter
    private ArrayList<Field> allFieldsFromClass;
    
    /**
     * Creates new form DatabaseTable
     */
    public DatabaseTable() {
        initComponents();
        this.CONTROLLER = null;
        this.classType = null;
    }
    
    public DatabaseTable(Class<T> classType) {
        initComponents();  

        this.classType = classType;
        this.CONTROLLER = (BaseController<T>) Controllers.getByName(classType);
        
        ArrayList<T> dataList = this.CONTROLLER
                .getAll();
        
        this.allFieldsFromClass = ObjectUtils.getAllFieldsFromClass(classType);
        
        ComboBoxModel<String> searchModel = new DefaultComboBoxModel(
                this.allFieldsFromClass.stream()
                        .map(Field::getName)
                        .toArray()
        );
        
        this.fieldSearchSelection.setModel(searchModel);
        
        this.setHeader(
                Models.getByClassType(classType).getLocalString()
        );
        
        this.setModel(dataList);
        
    }
    
    public void setHeader(String text) {
        this.headerLabel.setText(text);
    }
    
    public void setModel(ArrayList<T> objectList) {
        TableModel model = ViewUtils.generateDataModelFromObjectList(objectList, classType);
        
        this.dataTable.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerLabel = new javax.swing.JLabel();
        headerSeparator = new javax.swing.JSeparator();
        searchTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        fieldSearchSelection = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();

        headerLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLabel.setText("DatabaseName");

        searchTextField.setText("Pesquisar");
        searchTextField.setPreferredSize(new java.awt.Dimension(78, 30));

        searchButton.setIcon(new javax.swing.ImageIcon("/Users/gscavo/Documents/Unicamp/TT001/VeterinaryClinic/src/main/resources/org/gscavo/veterinaryclinic/icons/search-interface-symbol.png")); // NOI18N

        fieldSearchSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Field" }));
        fieldSearchSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldSearchSelectionActionPerformed(evt);
            }
        });

        dataTable.setAutoCreateRowSorter(true);
        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(dataTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                    .addComponent(headerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(headerSeparator, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fieldSearchSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(headerSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fieldSearchSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void fieldSearchSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldSearchSelectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldSearchSelectionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dataTable;
    private javax.swing.JComboBox<String> fieldSearchSelection;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JSeparator headerSeparator;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextField;
    // End of variables declaration//GEN-END:variables
}
