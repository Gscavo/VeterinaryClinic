package org.gscavo.veterinaryclinic.controller;

import com.mongodb.client.result.InsertOneResult;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.dao.ProcedureDAO;
import org.gscavo.veterinaryclinic.model.Procedure;
import org.gscavo.veterinaryclinic.utils.ConversionUtils;
import org.gscavo.veterinaryclinic.utils.enums.StatusCode;
import org.gscavo.veterinaryclinic.utils.information.SystemOperationResult;
import org.gscavo.veterinaryclinic.utils.security.Permissions;

import java.util.Objects;

import static org.gscavo.veterinaryclinic.utils.UserUtils.canUserDoAction;

public class ProcedureController {

    private static final ProcedureDAO PROCEDURE_DAO = DAOController.getDaoByClass(Procedure.class);


    public static SystemOperationResult registerProcedure(Procedure procedure) {
        if (!canUserDoAction(Permissions::canRegisterProcedures)) {
            return SystemOperationResult.notAuthenticatedOrAllowedActionSOR();
        }

        InsertOneResult result = PROCEDURE_DAO.insertOne(procedure);

        if (result == null || !result.wasAcknowledged()) {
            return SystemOperationResult.failedToInsertResourceSOR(procedure.getClass());
        }



        return new SystemOperationResult<>(StatusCode.SUCCESS, ConversionUtils.bsonValueToObjectId(result.getInsertedId()));
    }
}
