package org.gscavo.veterinaryclinic.view.menu;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import org.gscavo.veterinaryclinic.utils.ViewUtils;
import org.gscavo.veterinaryclinic.utils.enums.Models;
import org.gscavo.veterinaryclinic.view.MainUserFrame;
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
    
    private final MainUserFrame frame;
    private final JPanel mainPanel;
    private final Models model;
//    private final String cardName;
    
    public RegisterMenuItem(MainUserFrame frame, Models model) {
        super();
        this.model = model;
        this.frame = frame;
        
        this.mainPanel = this.frame.getMainPanel();
        
//        this.cardName = createCardLayoutName();
        
        this.setText(model.getLocalString());
       
        this.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuItemActionPerformed(e);
            }
       });
    }
    
    private void menuItemActionPerformed(ActionEvent evt) {
        RegisterPanel registerPanel = new RegisterPanel(frame, this.model);
        int numberOfComponents = this.mainPanel.getComponentCount();
        
        if (numberOfComponents > 0) {
            this.mainPanel.removeAll();
        }
        
        this.mainPanel.add(
            registerPanel,
            BorderLayout.CENTER
        );
        
        ViewUtils.updateScreen(this.frame, false);

        this.frame.setSize(
                registerPanel.getPreferredSize()
        );
    }
    
    private String createCardLayoutName() {
        return this.model.getClassType().getSimpleName() + "Card";
    };
}
