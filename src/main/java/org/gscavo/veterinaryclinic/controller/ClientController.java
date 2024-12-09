/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.gscavo.veterinaryclinic.controller;

import java.util.ArrayList;

import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.controller.abstractions.BaseController;
import org.gscavo.veterinaryclinic.dao.ClientDAO;
import org.gscavo.veterinaryclinic.model.Client;
import org.gscavo.veterinaryclinic.utils.ConversionUtils;
import org.gscavo.veterinaryclinic.utils.enums.PersonType;
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

    @Override
    public ArrayList<Client> filter(Bson filter) {
        Bson filterAnd = Filters.and(Filters.eq("type", PersonType.CLIENT), filter);
        return ConversionUtils.documentsListToTypeList(dao.getCollection().find(filterAnd), classType);
    }

    @Override
    public String getReadableIdentifier(Client client) {
        return client.getName();
    }
}
