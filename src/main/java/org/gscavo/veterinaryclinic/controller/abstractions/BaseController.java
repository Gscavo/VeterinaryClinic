/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.gscavo.veterinaryclinic.controller.abstractions;

import java.util.ArrayList;
import org.gscavo.veterinaryclinic.controller.DAOController;
import org.gscavo.veterinaryclinic.dao.BaseDAO;

/**
 *
 * @author gscavo
 */
public abstract class BaseController {
    
    public static <T> ArrayList<T> getAll(Class<T> classType) {
        BaseDAO<T> dao = DAOController.getDaoByClass(classType);
        
        return dao.findAll();
    };
}
