package org.gscavo.veterinaryclinic.controller;

import com.mongodb.client.result.InsertOneResult;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.dao.SpeciesDAO;
import org.gscavo.veterinaryclinic.model.Species;
import org.gscavo.veterinaryclinic.utils.ConversionUtils;
import org.gscavo.veterinaryclinic.utils.enums.StatusCode;
import org.gscavo.veterinaryclinic.utils.information.SystemOperationResult;
import org.gscavo.veterinaryclinic.utils.security.Permissions;

import java.util.ArrayList;
import org.gscavo.veterinaryclinic.controller.abstractions.BaseController;

import static org.gscavo.veterinaryclinic.utils.UserUtils.canUserDoAction;

public class SpeciesController extends BaseController<Species> {

    private static final SpeciesDAO SPECIES_DAO = DAOController.getDaoByClass(Species.class);

    public SpeciesController() {
        super(Species.class);
    }
    
    @Override
    public SystemOperationResult<?> register(Species species) {
        if (!canUserDoAction(Permissions::canRegister)) {
            return SystemOperationResult.notAuthenticatedOrAllowedActionSOR();
        }

        InsertOneResult result = SPECIES_DAO.insertOne(species);

        if (result == null || !result.wasAcknowledged()) {
            return SystemOperationResult.failedToInsertResourceSOR(species.getClass());
        }

        return new SystemOperationResult<ObjectId>(
                StatusCode.SUCCESS,
                ConversionUtils.bsonValueToObjectId(result.getInsertedId())
        );
    }
}
