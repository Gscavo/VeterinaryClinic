/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.gscavo.veterinaryclinic.view.panels.database_table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.TableModel;

import com.mongodb.client.model.Filters;
import java.awt.Font;
import java.util.Locale;

import lombok.Getter;
import lombok.Setter;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.controller.abstractions.BaseController;
import org.gscavo.veterinaryclinic.model.abstractions.BaseModel;
import org.gscavo.veterinaryclinic.utils.ObjectUtils;
import org.gscavo.veterinaryclinic.utils.StringUtils;
import org.gscavo.veterinaryclinic.utils.ViewUtils;
import org.gscavo.veterinaryclinic.utils.enums.Controllers;
import org.gscavo.veterinaryclinic.utils.enums.Models;
import org.gscavo.veterinaryclinic.utils.information.SystemOperationResult;
import org.gscavo.veterinaryclinic.view.dialog.UpdateDialog;

/**
 *
 * @author gscavo
 */
public class DatabaseTable<T extends BaseModel> extends javax.swing.JPanel {
    private int selectedRow;
    private int selectedColumn;
    private ObjectId selectedId;
    private Object selectedData;

    private final Class<T> classType;

    private BaseController<T> controller;
    
    @Getter @Setter
    private ArrayList<Field> allFieldsFromClass;
    private String searchTerm;

    private String[] searchFields;

    private Models modelData;
    
    /**
     * Creates new form DatabaseTable
     */
    public DatabaseTable() {
        this.classType = null;
        this.controller = null;
        this.modelData = null;
        initComponents();
    }
    
    public DatabaseTable(Class<T> classType) {
        this.classType = classType;
        initComponents();
        initController();
        myInitComponents();
    }

    private void myInitComponents() {
        this.modelData = Models.getByClassType(classType);

        Class<?> viewClass = modelData.getView();

        refreshTable();

        this.allFieldsFromClass = ObjectUtils.getAllFieldsFromClass(viewClass);

        this.searchFields = this.allFieldsFromClass.stream()
                .map(Field::getName)
                .toList()
                .toArray(new String[0]);

        ComboBoxModel<String> searchModel = new DefaultComboBoxModel(
                searchFields
        );

        this.fieldSearchSelection.setModel(searchModel);

        this.setHeader(
                Models.getByClassType(this.classType).getLocalString()
        );

        this.dataTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
    }

    private void initController() {
        this.controller = (BaseController<T>) Controllers.getByName(this.classType);
    }
    
    public void setHeader(String text) {
        this.headerLabel.setText(text);
    }
    
    public void setModel(ArrayList<?> objectList) {
        TableModel model = ViewUtils.generateDataModelFromObjectList(objectList, this.modelData.getView());

        this.dataTable.setModel(model);
    }

    private void refreshTable() {
        ArrayList<?> dataList = this.controller
                .getAllForDatabaseTable();

        this.setModel(dataList);
    }

    public void updateSelectedRowColumn() {
        int idRow = this.dataTable.getTableHeader().getColumnModel().getColumnIndex("id");

        this.selectedRow = this.dataTable.getSelectedRow();
        this.selectedColumn = this.dataTable.getSelectedColumn();

        this.selectedId = (ObjectId) this.dataTable.getModel().getValueAt(
                selectedRow,
                idRow
        );

        this.selectedData = this.dataTable.getModel().getValueAt(
                selectedRow,
                selectedColumn
        );

        System.out.println("-------- SELECTED INFORMATION --------");
        System.out.println("idRow: " + idRow);
        System.out.println("selectedRow: " + selectedRow);
        System.out.println("selectedColumn: " + selectedColumn);
        System.out.println("selectedId: " + selectedId);
        System.out.println("selectedData: " + selectedData);
        System.out.println("--------------------------------------");

        if (selectedData.toString().toLowerCase(Locale.ROOT).equals("delete")) {
            deleteSelectedItem();
            return;
        }

        new UpdateDialog(
                (JFrame) this.getTopLevelAncestor(), 
                true, 
                Models.getByClassType(classType), 
                selectedId)
                .setVisible(true);
    }

    private void deleteSelectedItem() {
        int resposta = JOptionPane.showConfirmDialog(
                null,
                "Deseja mesmo excluir esse registro?",
                "Confirme a exclusão",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            SystemOperationResult<ObjectId> systemOperationResult = controller.deleteById(this.selectedId);
            ViewUtils.showInformationDialog(this, systemOperationResult);
            refreshTable();
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
        searchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyReleased(evt);
            }
        });

        searchButton.setIcon(new javax.swing.ImageIcon("/Users/gscavo/Documents/Unicamp/TT001/VeterinaryClinic/src/main/resources/org/gscavo/veterinaryclinic/icons/search-interface-symbol.png")); // NOI18N
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        fieldSearchSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Field" }));

        dataTable.setAutoCreateRowSorter(true);
        dataTable.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
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
        dataTable.setRowHeight(30);
        dataTable.setRowSelectionAllowed(false);
        dataTable.setShowGrid(true);
        dataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataTableMouseClicked(evt);
            }
        });
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

    private void searchTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyReleased
        this.searchTerm = this.searchTextField.getText();
    }//GEN-LAST:event_searchTextFieldKeyReleased

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        if (!StringUtils.isEmpty(searchTerm)) {
            String searchField = this.searchFields[this.fieldSearchSelection.getSelectedIndex()];

            Bson filter = Filters.eq(searchField, searchTerm);

            this.setModel(controller.filter(filter));
        } else {
            this.setModel(controller.getAllForDatabaseTable());
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void dataTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataTableMouseClicked
        updateSelectedRowColumn();
    }//GEN-LAST:event_dataTableMouseClicked


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
