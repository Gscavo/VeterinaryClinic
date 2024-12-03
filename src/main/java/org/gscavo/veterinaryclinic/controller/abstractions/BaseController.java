/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.gscavo.veterinaryclinic.controller.abstractions;

import com.mongodb.client.model.Filters;
import com.sun.jdi.ClassType;
import java.util.ArrayList;

import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.gscavo.veterinaryclinic.controller.DAOController;
import org.gscavo.veterinaryclinic.dao.BaseDAO;
import org.gscavo.veterinaryclinic.utils.ConversionUtils;
import org.gscavo.veterinaryclinic.utils.information.SystemOperationResult;

/**
 *
 * @author gscavo
 */
public abstract class BaseController<T> {
    
    private Class<T> classType;
    
    public BaseController(Class<T> classType) {
        this.classType = classType;
    }
    
    public abstract SystemOperationResult register(T object);
    
    public ArrayList<T> getAll() {
        BaseDAO<T> dao = DAOController.getDaoByClass(this.classType);
        
        return dao.findAll();
    };

    public ArrayList<T> filter(Bson filter) {
        BaseDAO<T> dao = DAOController.getDaoByClass(this.classType);

        return ConversionUtils.documentsListToTypeList(dao.getCollection().find(filter), classType);
    }
}
