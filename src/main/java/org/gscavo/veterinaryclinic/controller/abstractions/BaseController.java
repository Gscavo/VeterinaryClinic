/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.gscavo.veterinaryclinic.controller.abstractions;

import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
import com.sun.jdi.ClassType;
import java.util.ArrayList;
import java.util.Objects;

import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.controller.DAOController;
import org.gscavo.veterinaryclinic.dao.BaseDAO;
import org.gscavo.veterinaryclinic.model.abstractions.BaseModel;
import org.gscavo.veterinaryclinic.utils.ConversionUtils;
import org.gscavo.veterinaryclinic.utils.enums.StatusCode;
import org.gscavo.veterinaryclinic.utils.information.SystemOperationResult;
import org.gscavo.veterinaryclinic.utils.security.Permissions;

import static org.gscavo.veterinaryclinic.utils.ConversionUtils.objectToDocument;
import static org.gscavo.veterinaryclinic.utils.UserUtils.canUserDoAction;
import static org.gscavo.veterinaryclinic.utils.information.SystemOperationResult.notAuthenticatedOrAllowedActionSOR;

/**
 *
 * @author gscavo
 */
public abstract class BaseController<T extends BaseModel> {
    
    private BaseDAO<T> dao;
    private Class<T> classType;
    
    public BaseController(Class<T> classType) {
        this.classType = classType;
        this.dao = DAOController.getDaoByClass(this.classType);
    }
    
    public abstract SystemOperationResult<?> register(T object);

    public SystemOperationResult<ObjectId> update(T object) {
        if (!canUserDoAction(Permissions::canUpdateInfo)) {
            return notAuthenticatedOrAllowedActionSOR();
        }
        try {
            UpdateResult result = this.dao.updateById(
                object.getId(),
                object
            );

            if (!result.wasAcknowledged() || result.getModifiedCount() < 1) {
                SystemOperationResult.failedToUpdateResourceSOR(classType);
            }

            return new SystemOperationResult<>(
                    StatusCode.SUCCESS,
                    ConversionUtils.bsonValueToObjectId(result.getUpsertedId())
            );
        } catch (Exception e) {
            System.err.println("A error occured while trying to update a resource.");
            return SystemOperationResult.failedToUpdateResourceSOR(classType);
        }
    }


    public T getById(ObjectId id) {
        return dao.findById(id);
    }
    
    public ArrayList<T> getAll() {
        return dao.findAll();
    };

    public ArrayList<T> filter(Bson filter) {
        return ConversionUtils.documentsListToTypeList(dao.getCollection().find(filter), classType);
    }
}
