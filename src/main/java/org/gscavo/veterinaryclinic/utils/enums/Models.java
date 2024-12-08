/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package org.gscavo.veterinaryclinic.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.gscavo.veterinaryclinic.model.*;
import org.gscavo.veterinaryclinic.model.abstractions.Person;
import org.gscavo.veterinaryclinic.model.view.AnimalView;
import org.gscavo.veterinaryclinic.model.view.AppointmentView;
import org.gscavo.veterinaryclinic.view.model_panel.*;
import org.gscavo.veterinaryclinic.view.model_panel.abstractions.PersonInputPanel;

/**
 *
 * @author gscavo
 */
@AllArgsConstructor
public enum Models {
    ADMIN("Admin", Admin.class, PersonInputPanel.class, Person.class),
    ANIMAL("Animal", Animal.class, AnimalInputPanel.class, AnimalView.class),
    APPOINTMENT("Consulta", Appointment.class, AppointmentInputPanel.class, AppointmentView.class ),
    CLIENT("Cliente", Client.class, ClientInputPanel.class, Client.class),
    USER("Usuários", User.class, PersonInputPanel.class, User.class),
    PROCEDURE("Procedimento", Procedure.class, ProcedureInputPanel.class, Procedure.class),
    SECRETARY("Secretária", Secretary.class, PersonInputPanel.class, Secretary.class),
    SPECIES("Espécie", Species.class, SpeciesInputPanel.class, Species.class),
    SYMPTOM("Sintomas", Symptom.class, SymptomInputPanel.class, Symptom.class),
    VETERINARIAN("Veterinário", Veterinarian.class, VeterinarianInputPanel.class, Veterinarian.class);
    
    @Getter
    private String localString;
    
    @Getter
    private Class<?> classType;
    
    @Getter
    private Class<?> inputPanelClass;

    @Getter
    private Class<?> view;

    public static Models getByClassType(Class<?> classType) {
        for (Models model : Models.values()) {
            if (model.getClassType().equals(classType)) {
                return model;
            }
        }

        throw new EnumConstantNotPresentException(Models.class, classType.getSimpleName());
    }
    
}
