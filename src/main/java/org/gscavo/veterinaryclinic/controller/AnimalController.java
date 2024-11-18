package org.gscavo.veterinaryclinic.controller;

import com.mongodb.client.result.InsertOneResult;
import java.util.ArrayList;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.controller.abstractions.BaseController;
import org.gscavo.veterinaryclinic.dao.AnimalDAO;
import org.gscavo.veterinaryclinic.model.Animal;
import org.gscavo.veterinaryclinic.model.Client;
import static org.gscavo.veterinaryclinic.utils.UserUtils.canUserDoAction;

import org.gscavo.veterinaryclinic.utils.ConversionUtils;
import org.gscavo.veterinaryclinic.utils.information.SystemOperationResult;
import org.gscavo.veterinaryclinic.utils.enums.StatusCode;
import static org.gscavo.veterinaryclinic.utils.information.SystemOperationResult.failedToInsertResourceSOR;
import static org.gscavo.veterinaryclinic.utils.information.SystemOperationResult.notAuthenticatedOrAllowedActionSOR;
import org.gscavo.veterinaryclinic.utils.security.Permissions;

public class AnimalController extends BaseController<Animal> {

    private static final AnimalDAO ANIMAL_DAO = DAOController.getDaoByClass(Animal.class);

    public AnimalController() {
        super(Animal.class);
    }
    
    @Override
    public SystemOperationResult<?> register(Animal animal) {
        if (!canUserDoAction(Permissions::canRegister)) {
            return notAuthenticatedOrAllowedActionSOR();
        }

        InsertOneResult result_animal = ANIMAL_DAO.insertOne(animal);

        if (result_animal == null || !result_animal.wasAcknowledged() || result_animal.getInsertedId() == null) {
            return failedToInsertResourceSOR(Animal.class);
        }

        ObjectId animalId = ConversionUtils.bsonValueToObjectId(result_animal.getInsertedId());

        SystemOperationResult<?> result_client = UserController.appendAnimalToClient(animalId, animal.getTutor());

        if (!result_client.getStatus().isSuccess()) {
            return SystemOperationResult.failedToUpdateResourceSOR(Client.class);
        }

        return new SystemOperationResult<ObjectId>(StatusCode.SUCCESS, animalId);
    }
}
