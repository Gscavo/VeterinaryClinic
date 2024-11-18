package org.gscavo.veterinaryclinic.view.menu;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import org.gscavo.veterinaryclinic.utils.enums.Models;
import org.gscavo.veterinaryclinic.view.dialog.BaseOperationsDialog;
import org.gscavo.veterinaryclinic.view.panels.register.RegisterPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gscavo
 */
public class RegisterMenuItem extends JMenuItem {
    
    private final JFrame frame;
    private final Models model;
    
    public RegisterMenuItem(JFrame frame, Models model) {
        super();
        this.model = model;
        this.frame = frame;
        
        this.setText(model.getLocalString());
       
        this.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuItemActionPerformed(e);
            }
       });
    }
    
    private void menuItemActionPerformed(ActionEvent evt) {
        new BaseOperationsDialog(
                frame, 
                true,
                new RegisterPanel(model)
        ).setVisible(true);
    }
}
