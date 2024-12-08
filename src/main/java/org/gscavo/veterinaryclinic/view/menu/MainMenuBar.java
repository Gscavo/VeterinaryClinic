/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.gscavo.veterinaryclinic.view.menu;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import lombok.Getter;
import org.gscavo.veterinaryclinic.utils.enums.Models;
import org.gscavo.veterinaryclinic.view.MainUserFrame;
import org.gscavo.veterinaryclinic.view.panels.mainScreen.MainScreenPanel;

/**
 *
 * @author gscavo
 */
public class MainMenuBar extends JMenuBar {

    private final String registerMenuLabel = "Cadastrar";
    private final String findMenuLabel = "Procurar";
    private final String mainScreenLabel = "Tela Inicial";

    @Getter
    private JMenu mainScreenMenu;

    @Getter
    private JMenu registerMenu;
    
    @Getter
    private JMenu findMenu;
    
    private final MainUserFrame frame;
    
    public MainMenuBar(MainUserFrame frame) {
        this.frame = frame;
        myInitComponents();
    }
    
    
    private void myInitComponents() {
        registerMenu = new JMenu(registerMenuLabel);
        findMenu = new JMenu(findMenuLabel);

        mainScreenMenu = new GoToMainScreenMenu(
                this.frame,
                mainScreenLabel,
                new MainScreenPanel()
        );

        add(mainScreenMenu);
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
