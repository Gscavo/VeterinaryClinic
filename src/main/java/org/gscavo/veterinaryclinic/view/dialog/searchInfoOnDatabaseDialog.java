/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/OkCancelDialog.java to edit this template
 */
package org.gscavo.veterinaryclinic.view.dialog;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.TableModel;

import com.mongodb.client.model.Filters;
import lombok.Getter;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.controller.abstractions.BaseController;
import org.gscavo.veterinaryclinic.model.Appointment;
import org.gscavo.veterinaryclinic.model.abstractions.BaseModel;
import org.gscavo.veterinaryclinic.utils.ObjectUtils;
import org.gscavo.veterinaryclinic.utils.StringUtils;
import org.gscavo.veterinaryclinic.utils.ViewUtils;
import org.gscavo.veterinaryclinic.utils.enums.Controllers;
import org.gscavo.veterinaryclinic.utils.enums.Models;
import org.gscavo.veterinaryclinic.utils.information.SystemOperationResult;
import org.gscavo.veterinaryclinic.view.MainUserFrame;
import org.gscavo.veterinaryclinic.view.model_panel.AppointmentInputPanel;
import org.gscavo.veterinaryclinic.view.model_panel.abstractions.BaseInputPanel;
import org.gscavo.veterinaryclinic.view.panels.register.RegisterPanel;
import org.gscavo.veterinaryclinic.view.panels.selectFromDatabase.SelectFromDatabase;

/**
 *
 * @author gscavo
 */
public class SearchInfoOnDatabaseDialog<T extends BaseModel> extends javax.swing.JDialog {
    
    private JPanel parentPanel;

    private ObjectId objectId;
    private Models model;
    private Class<?> classType;

    private BaseController<T> controller;

    private String searchTerm;
    private ArrayList<Field> allFieldsFromClass;
    private String[] searchFields;
    private ArrayList<T> objectList;

    private int selectedRow;
    private int selectedColumn;
    private ObjectId selectedId;
    private Object selectedValue;

    @Getter
    private Object selectedData;

    public static final int RET_CANCEL = 0;
    public static final int RET_OK = 1;

    /**
     * Creates new form OperationStatusDialog
     */
    public SearchInfoOnDatabaseDialog(java.awt.Frame parentFrame, JPanel parentPanel, boolean modal, Models model) {
        super(parentFrame, modal);
        initComponents();
        myInitComponents(model, parentPanel);

        // Close the dialog when Esc is pressed
        String cancelName = "Cancelar";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });   
    }
    
    private void myInitControllers() {
        this.controller = (BaseController<T>) Controllers.getByName(classType);
    }
    
    private void myInitComponents(Models model, JPanel parentPanel) {
        this.parentPanel = parentPanel;
        this.model = model;
        this.classType = model.getClassType();

        myInitControllers();

        acquireObjectList();

        initSearchFields();

        setTableModel();

        this.pack();
    }

    private void acquireObjectList() {

        this.objectList = (ArrayList<T>) controller.getAllForDatabaseTable();
    }

    private void initSearchFields() {
        Class<?> viewClass = model.getView();

        this.allFieldsFromClass = ObjectUtils.getAllFieldsFromClass(viewClass);
        this.searchFields = this.allFieldsFromClass.stream()
                .map(Field::getName)
                .toList()
                .toArray(new String[0]);

        ComboBoxModel<String> searchModel = new DefaultComboBoxModel<>( searchFields );

        this.searchFieldSelection.setModel(searchModel);
    }

    public void setTableModel() {
        TableModel model = ViewUtils.generateDataModelFromObjectList(objectList, this.model.getView());

        this.databaseTable.setModel(model);
    }

    public void updateSelectedRowColumn() {
        int idRow = this.databaseTable.getTableHeader().getColumnModel().getColumnIndex("id");

        this.selectedRow = this.databaseTable.getSelectedRow();
        this.selectedColumn = this.databaseTable.getSelectedColumn();

        this.selectedId = (ObjectId) this.databaseTable.getModel().getValueAt(
                selectedRow,
                idRow
        );

        this.selectedValue = this.databaseTable.getModel().getValueAt(
                selectedRow,
                selectedColumn
        );

        this.selectedData = this.objectList.get(selectedRow);

        System.out.println("-------- SELECTED INFORMATION --------");
        System.out.println("idRow: " + idRow);
        System.out.println("selectedRow: " + selectedRow);
        System.out.println("selectedColumn: " + selectedColumn);
        System.out.println("selectedId: " + selectedId);
        System.out.println("selectedValuew: " + selectedValue);
        System.out.println("selectedData: " + selectedData);
        System.out.println("--------------------------------------");
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
        headerPanel = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        searchFieldSelection = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        databaseTable = new javax.swing.JTable();
        buttonRow = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        selectButton = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        mainPanel.setLayout(new java.awt.BorderLayout());

        headerPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 10, 20, 10));
        headerPanel.setLayout(new java.awt.BorderLayout(10, 0));

        searchField.setToolTipText("Barra de busca");
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });
        headerPanel.add(searchField, java.awt.BorderLayout.CENTER);

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/gscavo/veterinaryclinic/icons/search-interface-symbol.png"))); // NOI18N
        searchButton.setMargin(new java.awt.Insets(5, 15, 5, 15));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        headerPanel.add(searchButton, java.awt.BorderLayout.EAST);

        searchFieldSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Null" }));
        searchFieldSelection.setPreferredSize(new java.awt.Dimension(200, 23));
        searchFieldSelection.setSize(new java.awt.Dimension(200, 23));
        headerPanel.add(searchFieldSelection, java.awt.BorderLayout.LINE_START);

        mainPanel.add(headerPanel, java.awt.BorderLayout.PAGE_START);

        databaseTable.setModel(new javax.swing.table.DefaultTableModel(
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
        databaseTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                databaseTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(databaseTable);

        mainPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        buttonRow.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        cancelButton.setText("Cancelar");
        cancelButton.setPreferredSize(new java.awt.Dimension(100, 25));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        buttonRow.add(cancelButton);

        selectButton.setText("Selecionar");
        selectButton.setPreferredSize(new java.awt.Dimension(100, 25));
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });
        buttonRow.add(selectButton);

        getContentPane().add(buttonRow, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        SelectFromDatabase<?> selectFromDatabase = (SelectFromDatabase<?>) parentPanel;

        selectFromDatabase.setData(
                this.selectedData
        );
        this.setVisible(false);
    }//GEN-LAST:event_selectButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        if (!StringUtils.isEmpty(searchTerm)) {
            String searchField = this.searchFields[this.searchFieldSelection.getSelectedIndex()];

            Bson filter = Filters.regex(searchField, searchTerm);
            this.objectList = controller.filter(filter);
            this.setTableModel();
        } else {
            this.objectList = controller.getAllForDatabaseTable();
            this.setTableModel();
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
        this.searchTerm = this.searchField.getText();
    }//GEN-LAST:event_searchFieldKeyReleased

    private void databaseTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_databaseTableMouseClicked
        updateSelectedRowColumn();
    }//GEN-LAST:event_databaseTableMouseClicked
    
    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SearchInfoOnDatabaseDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchInfoOnDatabaseDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchInfoOnDatabaseDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchInfoOnDatabaseDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SearchInfoOnDatabaseDialog dialog = new SearchInfoOnDatabaseDialog(new javax.swing.JFrame(), null, true, Models.CLIENT);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonRow;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTable databaseTable;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JComboBox<String> searchFieldSelection;
    private javax.swing.JButton selectButton;
    // End of variables declaration//GEN-END:variables

    /**
     * -- GETTER --
     *
     * @return the return status of this dialog - one of RET_OK or RET_CANCEL
     */
    @Getter
    private int returnStatus = RET_CANCEL;
}
