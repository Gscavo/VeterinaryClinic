package org.gscavo.veterinaryclinic.utils;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.lang.reflect.Field;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.gscavo.veterinaryclinic.utils.enums.Message;

import org.gscavo.veterinaryclinic.utils.exceptions.ExceptionOutput;
import org.gscavo.veterinaryclinic.utils.information.SystemOperationResult;

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
    
    public static <T> TableModel generateDataModelFromObjectList(ArrayList<?> objectList, Class<T> classType) {
        ArrayList<Field> allFields = ObjectUtils.getAllFieldsFromClass(classType);

        ArrayList<String> columnNames = new ArrayList<>(allFields.stream()
                .map(Field::getName)
                .toList());
        columnNames.add("Delete");

        Object[][] data = new Object[objectList.size()][];

        int numOfCols = columnNames.size();
        int idx_row = 0;
        for (Object object : objectList) {
            Object[] row = new Object[numOfCols + 1];
            int idx_col = 0;
            for (Field field : allFields) {
                try {
                    Object value = field.get(object);
                    row[idx_col++] = value;
                } catch (Exception ex) {
                    ExceptionOutput.showExceptionErr(ex);
                }
            };
            row[idx_col] = "Delete";
            data[idx_row++] = row;
        };

        return new DefaultTableModel(
                data,
                columnNames.toArray()
        );
    }

    public static void showInformationDialog(JPanel panel, SystemOperationResult<?> sysOpRes) {
        Message message = Message.getByString(sysOpRes.getStatus().name());
        
        ImageIcon icon = new ImageIcon(message.getIconPath());
        
        JOptionPane.showMessageDialog(
                null, 
                message.getLocalizedString(),
                "Resultado da Operação",
                JOptionPane.INFORMATION_MESSAGE,
                icon
        );
    }

    public static void updateScreen(JFrame frame,  Boolean pack) {
        if (pack != null && pack) {
            frame.pack();
        }

        frame.repaint();
    }
}
