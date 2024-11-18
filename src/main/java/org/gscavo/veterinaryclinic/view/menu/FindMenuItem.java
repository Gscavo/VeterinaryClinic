package org.gscavo.veterinaryclinic.view.menu;


import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import org.gscavo.veterinaryclinic.utils.enums.Models;
import org.gscavo.veterinaryclinic.view.MainUserFrame;
import org.gscavo.veterinaryclinic.view.dialog.BaseOperationsDialog;
import org.gscavo.veterinaryclinic.view.panels.database_table.DatabaseTable;
import org.gscavo.veterinaryclinic.view.panels.register.RegisterPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gscavo
 */
public class FindMenuItem extends JMenuItem {
    
    private final MainUserFrame frame;
    private final Models model;
    private final JPanel mainPanel;
    private final String cardName;
    
    public FindMenuItem(MainUserFrame frame, Models model) {
        super();
        this.model = model;
        this.frame = frame;
        this.cardName = createCardLayoutName();
        this.mainPanel = frame.getMainPanel();
        
        this.setText(model.getLocalString());
       
        this.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuItemActionPerformed(e);
            }
       });
    }
    
    private void menuItemActionPerformed(ActionEvent evt) {
        DatabaseTable<?> table = new DatabaseTable(this.model.getClassType());
        int numberOfComponents = this.mainPanel.getComponentCount();
        
        if (numberOfComponents > 0) {
            this.mainPanel.removeAll();
        }
        
        this.mainPanel.add(table, this.cardName);
        
        CardLayout cl = (CardLayout) this.mainPanel.getLayout();
        
        cl.show(this.mainPanel, cardName);
        
        this.mainPanel.revalidate();
        this.mainPanel.repaint();
    }
    
    private String createCardLayoutName() {
        return this.model.getClassType().getSimpleName() + "Card";
    };
}
