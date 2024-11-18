/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.gscavo.veterinaryclinic.view.menu;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import lombok.Getter;
import org.gscavo.veterinaryclinic.utils.enums.Models;
import org.gscavo.veterinaryclinic.view.MainUserFrame;

/**
 *
 * @author gscavo
 */
public class MainMenuBar extends JMenuBar {

    private String registerMenuLabel = "Cadastrar";
    private String findMenuLabel = "Procurar";
    
    @Getter
    private JMenu registerMenu;
    
    @Getter
    private JMenu findMenu;
    
    private final MainUserFrame frame;
    
    public MainMenuBar(MainUserFrame frame) {
        this.frame = frame;
        initComponents();
    }
    
    
    private void initComponents() {
        registerMenu = new JMenu(registerMenuLabel);
        findMenu = new JMenu(findMenuLabel);
        
        add(registerMenu);
        add(findMenu);
        
        for (Models model : Models.values()) {
            this.registerMenu.add(
                    new RegisterMenuItem(this.frame, model)
            );
            
            this.findMenu.add(
                    new FindMenuItem(this.frame, model)
            );
        }
        
        setVisible(true);
    }
}
