package org.gscavo.veterinaryclinic.controller;

import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import lombok.Getter;
import org.bson.conversions.Bson;
import org.gscavo.veterinaryclinic.controller.abstractions.BaseController;
import org.gscavo.veterinaryclinic.dao.AdminDAO;
import org.gscavo.veterinaryclinic.model.Admin;
import org.gscavo.veterinaryclinic.model.Client;
import org.gscavo.veterinaryclinic.utils.ConversionUtils;
import org.gscavo.veterinaryclinic.utils.enums.PersonType;
import org.gscavo.veterinaryclinic.utils.enums.StatusCode;
import org.gscavo.veterinaryclinic.utils.information.SystemOperationResult;

import java.util.ArrayList;

public class AdminController extends BaseController<Admin> {
    @Getter
    private static final AdminDAO ADMIN_DAO = DAOController.getDaoByClass(Admin.class);

    public AdminController() {
        super(Admin.class);
    }

    @Override
    public SystemOperationResult<?> register(Admin admin) {
        InsertOneResult result = ADMIN_DAO.insertOne(admin);

        if (result == null || !result.wasAcknowledged() || result.getInsertedId() == null) {
            return SystemOperationResult.failedToInsertResourceSOR(Admin.class);
        }

        return new SystemOperationResult<>(
                StatusCode.SUCCESS,
                ConversionUtils.bsonValueToObjectId(result.getInsertedId())
        );
    }
    @Override
    public ArrayList<Admin> filter(Bson filter) {
        Bson filterAnd = Filters.and(Filters.eq("type", PersonType.ADMIN), filter);
        return ConversionUtils.documentsListToTypeList(dao.getCollection().find(filterAnd), classType);
    }

    @Override
    public String getReadableIdentifier(Admin admin) {
        return admin.getName();
    }
}
