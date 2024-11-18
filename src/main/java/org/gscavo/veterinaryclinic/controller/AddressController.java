package org.gscavo.veterinaryclinic.controller;

import com.mongodb.client.result.InsertOneResult;
import lombok.Getter;
import org.bson.BsonValue;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.controller.abstractions.BaseController;
import org.gscavo.veterinaryclinic.dao.AddressDAO;
import org.gscavo.veterinaryclinic.model.Address;
import org.gscavo.veterinaryclinic.utils.ConversionUtils;
import org.gscavo.veterinaryclinic.utils.enums.StatusCode;
import org.gscavo.veterinaryclinic.utils.information.SystemOperationResult;
import org.gscavo.veterinaryclinic.utils.security.Permissions;

import static org.gscavo.veterinaryclinic.utils.UserUtils.canUserDoAction;
import static org.gscavo.veterinaryclinic.utils.information.SystemOperationResult.failedToInsertResourceSOR;
import static org.gscavo.veterinaryclinic.utils.information.SystemOperationResult.notAuthenticatedOrAllowedActionSOR;

@Getter
public class AddressController extends BaseController<Address> {

    private static final AddressDAO ADDRESS_DAO = DAOController.getDaoByClass(Address.class);

    public AddressController() {
        super(Address.class);
    }
    
    @Override
    public SystemOperationResult<?> register(Address address) {
        if (!canUserDoAction(Permissions::canRegister)) {
            return notAuthenticatedOrAllowedActionSOR();
        }

        InsertOneResult result = ADDRESS_DAO.insertOne(address);

        if (result == null || !result.wasAcknowledged()) {
            return failedToInsertResourceSOR(Address.class);
        }

        return new SystemOperationResult<ObjectId>(
                StatusCode.SUCCESS,
                ConversionUtils.bsonValueToObjectId(result.getInsertedId())
        );
    }
}
