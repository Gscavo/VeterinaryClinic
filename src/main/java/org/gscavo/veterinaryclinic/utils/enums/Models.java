/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package org.gscavo.veterinaryclinic.utils.enums;

import lombok.Getter;
import org.gscavo.veterinaryclinic.model.*;
import org.gscavo.veterinaryclinic.model.abstractions.Person;
import org.gscavo.veterinaryclinic.view.model_panel.*;
import org.gscavo.veterinaryclinic.view.model_panel.abstractions.PersonInputPanel;

/**
 *
 * @author gscavo
 */
public enum Models {
    ADDRESS("Endereço", Address.class, AddressInputPanel.class),
    ADMIN("Admin", Admin.class, PersonInputPanel.class),
    ANIMAL("Animal", Animal.class, AnimalInputPanel.class),
    APPOINTMENT("Consulta", Appointment.class, AppointmentInputPanel.class),
    CLIENT("Cliente", Client.class, PersonInputPanel.class),
    PERSON("Pessoa", Person.class, UserInputPanel.class),
    PROCEDURE("Procedimento", Procedure.class, ProcedureInputPanel.class),
    SECRETARY("Secretária", Secretary.class, UserInputPanel.class),
    SPECIES("Espécie", Species.class, SpeciesInputPanel.class),
    SYMPTOM("Sintomas", Symptom.class, SymptomInputPanel.class),
    VETERINARIAN("Veterinário", Veterinarian.class, VeterinarianInputPanel.class);
    
    @Getter
    private String localString;
    
    @Getter
    private Class<?> classType;
    
    @Getter
    private Class<?> inputPanelClass;
    
    private Models(String localizedString, Class<?> classType, Class<?> inputPanelClass) {
        this.localString = localizedString;
        this.classType = classType;
        this.inputPanelClass = inputPanelClass;
    }

    public static Models getByClassType(Class<?> classType) {
        for (Models model : Models.values()) {
            if (model.getClassType().equals(classType)) {
                return model;
            }
        }

        throw new EnumConstantNotPresentException(Models.class, classType.getSimpleName());
    }
    
}
