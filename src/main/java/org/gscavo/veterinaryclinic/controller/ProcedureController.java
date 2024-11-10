package org.gscavo.veterinaryclinic.controller;

import com.mongodb.client.result.InsertOneResult;
import org.gscavo.veterinaryclinic.dao.ProcedureDAO;
import org.gscavo.veterinaryclinic.model.Procedure;
import org.gscavo.veterinaryclinic.utils.enums.StatusCode;
import org.gscavo.veterinaryclinic.utils.information.SystemOperationResult;
import org.gscavo.veterinaryclinic.utils.security.Permissions;

import static org.gscavo.veterinaryclinic.utils.UserUtils.canUserDoAction;

public class ProcedureController {

    private static final ProcedureDAO PROCEDURE_DAO = new ProcedureDAO();


    public static SystemOperationResult registerProcedure(Procedure procedure) {
        if (!canUserDoAction(Permissions::canRegisterProcedures)) {
            return SystemOperationResult.notAuthenticatedOrAllowedActionSOR();
        }

        InsertOneResult result = PROCEDURE_DAO.insertOne(procedure);

        if (result == null || !result.wasAcknowledged()) {
            return SystemOperationResult.failedToInsertResourceSOR(procedure.getClass());
        }

        return new SystemOperationResult(StatusCode.SUCCESS);
    }
}
