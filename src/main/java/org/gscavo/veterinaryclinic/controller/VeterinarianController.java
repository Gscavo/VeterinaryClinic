package org.gscavo.veterinaryclinic.controller;

import com.mongodb.client.result.InsertOneResult;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.controller.abstractions.BaseController;
import org.gscavo.veterinaryclinic.dao.VeterinarianDAO;
import org.gscavo.veterinaryclinic.model.Veterinarian;
import org.gscavo.veterinaryclinic.utils.ConversionUtils;
import org.gscavo.veterinaryclinic.utils.enums.StatusCode;
import org.gscavo.veterinaryclinic.utils.information.SystemOperationResult;

public class VeterinarianController extends BaseController<Veterinarian> {
    
    private static VeterinarianDAO VETERINARIAN_DAO = DAOController.getDaoByClass(Veterinarian.class);
    
    public VeterinarianController() {
        super(Veterinarian.class);
    }

    @Override
    public SystemOperationResult<?> register(Veterinarian veterinarian) {
        InsertOneResult result = VETERINARIAN_DAO.insertOne(veterinarian);

        if (result == null || !result.wasAcknowledged() || result.getInsertedId() == null) {
            return SystemOperationResult.failedToUpdateResourceSOR(Veterinarian.class);
        }

        return new SystemOperationResult<ObjectId>(
                StatusCode.SUCCESS,
                ConversionUtils.bsonValueToObjectId(result.getInsertedId())
        );
    }
}
