package org.gscavo.veterinaryclinic.controller;

import com.mongodb.client.result.InsertOneResult;
import org.gscavo.veterinaryclinic.dao.SymptomDAO;
import org.gscavo.veterinaryclinic.model.Symptom;
import org.gscavo.veterinaryclinic.utils.enums.StatusCode;
import org.gscavo.veterinaryclinic.utils.information.SystemOperationResult;
import org.gscavo.veterinaryclinic.utils.security.Permissions;

import static org.gscavo.veterinaryclinic.utils.UserUtils.canUserDoAction;

public class SymptomController {

    private static final SymptomDAO SYMPTOM_DAO = DAOController.getDaoByClass(Symptom.class);

    public static SystemOperationResult registerSymptom(Symptom symptom) {
        if (!canUserDoAction(Permissions::canRegisterSymptoms)) {
            return SystemOperationResult.notAuthenticatedOrAllowedActionSOR();
        }

        InsertOneResult result = SYMPTOM_DAO.insertOne(symptom);

        if (result == null || !result.wasAcknowledged()) {
            return SystemOperationResult.failedToInsertResourceSOR(symptom.getClass());
        }

        return new SystemOperationResult(StatusCode.SUCCESS);
    }
}
