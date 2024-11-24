/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package org.gscavo.veterinaryclinic.utils.enums;

import lombok.Getter;
import org.gscavo.veterinaryclinic.controller.*;
import org.gscavo.veterinaryclinic.controller.abstractions.BaseController;

/**
 *
 * @author gscavo
 */
@Getter
public enum Controllers {
    ADMIN(new AdminController()),
    ANIMAL(new AnimalController()),
    APPOINTMENT(new AppointmentController()),
    CLIENT(new ClientController()),
    PROCEDURE(new ProcedureController()),
    USER(new UserController()),
    SECRETARY(new SecretaryController()),
    SPECIES(new SpeciesController()),
    SYMPTOM(new SymptomController()),
    VETERINARIAN(new VeterinarianController());
    
    private final BaseController<?> controller;

    private Controllers(BaseController<?> controller) {
        this.controller = controller;
    }
    
    public static BaseController<?> getByName(String name) {
        return Controllers.valueOf(name.toUpperCase()).getController();
    }
    
    public static BaseController<?> getByName(Class<?> classType) {
        System.out.println(classType.getSimpleName());
        return Controllers.valueOf(classType.getSimpleName().toUpperCase()).getController();
    }
}
