package org.gscavo.veterinaryclinic.controller;

import org.gscavo.veterinaryclinic.controller.abstractions.BaseController;
import org.gscavo.veterinaryclinic.dao.VeterinarianDAO;
import org.gscavo.veterinaryclinic.model.Veterinarian;
import org.gscavo.veterinaryclinic.utils.information.SystemOperationResult;

public class VeterinarianController extends BaseController<String> {
    
    private static VeterinarianDAO VETERINARIAN_DAO = DAOController.getDaoByClass(Veterinarian.class);;
    
    public VeterinarianController() {
        super(String.class);
    }

    @Override
    public SystemOperationResult register(String object) {
        return this.registerCrmv();
    }

    private SystemOperationResult registerCrmv() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
