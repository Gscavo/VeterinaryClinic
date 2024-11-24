/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.gscavo.veterinaryclinic.controller;

import org.gscavo.veterinaryclinic.dao.*;
import org.gscavo.veterinaryclinic.model.*;

import java.util.HashMap;
import java.util.Map;

public class DAOController {

    private static final Map<Object, Object> DAO_MAP = new HashMap<>();

    static {
        DAO_MAP.put(Admin.class, new AdminDAO());
        DAO_MAP.put(Animal.class, new AnimalDAO());
        DAO_MAP.put(Appointment.class, new AppointmentDAO());
        DAO_MAP.put(Client.class, new ClientDAO());
        DAO_MAP.put(Procedure.class, new ProcedureDAO());
        DAO_MAP.put(Secretary.class, new SecretaryDAO());
        DAO_MAP.put(Symptom.class, new SymptomDAO());
        DAO_MAP.put(Species.class, new SpeciesDAO());
        DAO_MAP.put(User.class, new UsersDAO());
        DAO_MAP.put(Veterinarian.class, new VeterinarianDAO());
    }

    @SuppressWarnings("unchecked")
    public static <T extends BaseDAO> T getDaoByClass(Class<?> classType) {
        T dao = (T) DAO_MAP.get(classType);

        if (dao == null) {
            throw new IllegalArgumentException("No DAO found for class: " + classType.getName());
        }
        
        return dao;
    }
}
