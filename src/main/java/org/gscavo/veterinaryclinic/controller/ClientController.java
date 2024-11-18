/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.gscavo.veterinaryclinic.controller;

import java.util.ArrayList;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.controller.abstractions.BaseController;
import org.gscavo.veterinaryclinic.dao.ClientDAO;
import org.gscavo.veterinaryclinic.model.Client;
import org.gscavo.veterinaryclinic.utils.information.SystemOperationResult;

/**
 *
 * @author gscavo
 */
public class ClientController extends BaseController<Client> {
    
    private static ClientDAO clientDAO = DAOController.getDaoByClass(Client.class);
    
    public ClientController() {
        super(Client.class);
    }
    
    @Override
    public SystemOperationResult register(Client client) {
        return null;
    }
}
