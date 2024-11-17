package org.gscavo.veterinaryclinic.utils;

import java.awt.Window;
import java.awt.event.ActionEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
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

    public static void showInformationDialog(JFrame frame, SystemOperationResult<?> sysOpRes) {
           OperationStatusDialog dialog = new OperationStatusDialog(frame, false, sysOpRes);
           dialog.setVisible(true);
    }
}
