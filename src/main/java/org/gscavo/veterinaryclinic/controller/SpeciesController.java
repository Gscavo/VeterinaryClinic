package org.gscavo.veterinaryclinic.controller;

import com.mongodb.client.result.InsertOneResult;
import org.gscavo.veterinaryclinic.dao.SpeciesDAO;
import org.gscavo.veterinaryclinic.model.Species;
import org.gscavo.veterinaryclinic.utils.enums.StatusCode;
import org.gscavo.veterinaryclinic.utils.information.SystemOperationResult;
import org.gscavo.veterinaryclinic.utils.security.Permissions;

import java.util.ArrayList;

import static org.gscavo.veterinaryclinic.utils.UserUtils.canUserDoAction;

public class SpeciesController {

    private static final SpeciesDAO SPECIES_DAO = DAOController.getDaoByClass(Species.class);

    public static SystemOperationResult registerSpecies(Species species) {
        if (!canUserDoAction(Permissions::canRegister)) {
            return SystemOperationResult.notAuthenticatedOrAllowedActionSOR();
        }

        InsertOneResult result = SPECIES_DAO.insertOne(species);

        if (result == null || !result.wasAcknowledged()) {
            return SystemOperationResult.failedToInsertResourceSOR(species.getClass());
        }

        return new SystemOperationResult(StatusCode.SUCCESS);
    }
}
