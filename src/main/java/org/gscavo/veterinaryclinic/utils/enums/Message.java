/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package org.gscavo.veterinaryclinic.utils.enums;

import java.util.Locale;
import javax.swing.ImageIcon;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author gscavo
 */

@AllArgsConstructor
public enum Message {
    SUCCESS("Sucesso", "/Users/gscavo/Documents/Unicamp/TT001/VeterinaryClinic/src/main/resources/org/gscavo/veterinaryclinic/icons/result_icon.png");
    
    @Getter
    private String localizedString;
    
    @Getter
    private String iconPath;
    
    public static Message getByString(String message) {
        String lowString = message.toLowerCase(Locale.ROOT);
        
        for (Message m : Message.values()) {
            String lowMessage = message.toLowerCase();
            
            if (lowMessage.equals(lowString)) {
                return m;
            }
        }
        
        
        System.err.println("No message found for string: " + message);
        return null;
    }
}
