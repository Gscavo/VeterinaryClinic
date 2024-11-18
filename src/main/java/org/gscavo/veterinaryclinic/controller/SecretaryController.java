package org.gscavo.veterinaryclinic.controller;

import com.mongodb.client.result.InsertOneResult;
import org.gscavo.veterinaryclinic.controller.abstractions.BaseController;
import org.gscavo.veterinaryclinic.dao.BaseDAO;
import org.gscavo.veterinaryclinic.dao.SecretaryDAO;
import org.gscavo.veterinaryclinic.model.Secretary;
import org.gscavo.veterinaryclinic.utils.ConversionUtils;
import org.gscavo.veterinaryclinic.utils.enums.StatusCode;
import org.gscavo.veterinaryclinic.utils.information.SystemOperationResult;

public class SecretaryController extends BaseController<Secretary> {


    private static final SecretaryDAO SECRETARY_DAO = DAOController.getDaoByClass(Secretary.class);

    public SecretaryController() {
        super(Secretary.class);
    }

    @Override
    public SystemOperationResult<?> register(Secretary secretary) {
        InsertOneResult result = SECRETARY_DAO.insertOne(secretary);

        if (result == null || !result.wasAcknowledged() || result.getInsertedId() == null) {
            return SystemOperationResult.failedToInsertResourceSOR(Secretary.class);
        }

        return new SystemOperationResult<>(
                StatusCode.SUCCESS,
                ConversionUtils.bsonValueToObjectId(result.getInsertedId())
        );
    }

}
