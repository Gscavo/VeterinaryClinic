package org.gscavo.veterinaryclinic.utils;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.gscavo.veterinaryclinic.utils.information.SystemOperationResult;
import org.gscavo.veterinaryclinic.view.dialog.OperationStatusDialog;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gscavo
 */
public class ViewUtils {
    
    public static Float getFloatFromJSpinner(JSpinner spinnerEl) {
        SpinnerNumberModel numberModel = (SpinnerNumberModel) spinnerEl.getModel();
        
        return numberModel.getNumber().floatValue();
    }
    
    public static Integer getIntFromJSpinner(JSpinner spinnerEl) {
        SpinnerNumberModel numberModel = (SpinnerNumberModel) spinnerEl.getModel();
        
        return numberModel.getNumber().intValue();
    }
    
    public static void closeWindow(ActionEvent evt) {
        
        JComponent comp = (JComponent) evt.getSource();
        
        Window win = SwingUtilities.getWindowAncestor(comp);
        
        win.dispose();
    }
    
    public static <T> TableModel generateDataModelFromObjectList(ArrayList<T> objectList) {
        ArrayList<Field> allFields = ObjectUtils.getAllFieldsFromClass(objectList.get(0).getClass());

        List<String> columnNames = allFields.stream()
                .map(Field::getName)
                .toList();
        Object[][] data = new Object[objectList.size()][];

        int numOfCols = columnNames.size();
        int idx_row = 0;
        for (T object : objectList) {
            Object[] row = new Object[numOfCols];
            int idx_col = 0;
            for (Field field : allFields) {
                try {
                    Object value = field.get(object);
                    row[idx_col++] = value;
                } catch (Exception ex) {
                    System.err.println("!ERROR!");
                    System.err.println(ex.getCause().getMessage());
                    System.err.println(ex.getLocalizedMessage());
                }
            };
            data[idx_row++] = row;
        };

        return new DefaultTableModel(
                data,
                columnNames.toArray()
        );
    }

    public static void showInformationDialog(JPanel panel, SystemOperationResult<?> sysOpRes) {
           JFrame frame =  (JFrame) panel.getTopLevelAncestor();
           OperationStatusDialog dialog = new OperationStatusDialog(frame, false, sysOpRes);
           dialog.setVisible(true);
    }
}
