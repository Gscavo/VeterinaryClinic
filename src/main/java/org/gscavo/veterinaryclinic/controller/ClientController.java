/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.gscavo.veterinaryclinic.controller;

import java.util.ArrayList;

import com.mongodb.client.result.InsertOneResult;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.controller.abstractions.BaseController;
import org.gscavo.veterinaryclinic.dao.ClientDAO;
import org.gscavo.veterinaryclinic.model.Client;
import org.gscavo.veterinaryclinic.utils.ConversionUtils;
import org.gscavo.veterinaryclinic.utils.enums.StatusCode;
import org.gscavo.veterinaryclinic.utils.information.SystemOperationResult;

/**
 *
 * @author gscavo
 */
public class ClientController extends BaseController<Client> {
    
    private final static ClientDAO CLIENT_DAO = DAOController.getDaoByClass(Client.class);
    
    public ClientController() {
        super(Client.class);
    }
    
    @Override
    public SystemOperationResult<?> register(Client client) {
        InsertOneResult result = CLIENT_DAO.insertOne(client);

        if (result == null || !result.wasAcknowledged() || result.getInsertedId() == null) {
            return SystemOperationResult.failedToInsertResourceSOR(Client.class);
        }

        return new SystemOperationResult<ObjectId>(
            StatusCode.SUCCESS,
            ConversionUtils.bsonValueToObjectId(result.getInsertedId())
        );
    }
}
