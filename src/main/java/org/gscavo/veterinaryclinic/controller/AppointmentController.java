package org.gscavo.veterinaryclinic.controller;

import com.mongodb.client.result.InsertOneResult;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.dao.AppointmentDAO;
import org.gscavo.veterinaryclinic.model.Appointment;
import org.gscavo.veterinaryclinic.model.abstractions.Person;
import org.gscavo.veterinaryclinic.utils.enums.StatusCode;
import org.gscavo.veterinaryclinic.utils.information.SystemOperationResult;
import org.gscavo.veterinaryclinic.utils.security.Permissions;

import static org.gscavo.veterinaryclinic.controller.UserController.appendAppointmentToUser;
import static org.gscavo.veterinaryclinic.utils.UserUtils.canUserDoAction;

@Getter
public class AppointmentController {

    private static final AppointmentDAO APPOINTMENT_DAO = DAOController.getDaoByClass(Appointment.class);

    public static SystemOperationResult registerAppointment(Appointment appointment) {
        if (!canUserDoAction(Permissions::canRegister)) {
            return SystemOperationResult.notAuthenticatedOrAllowedActionSOR();
        }

        InsertOneResult result = APPOINTMENT_DAO.insertOne(appointment);

        if (result == null || !result.wasAcknowledged() || result.getInsertedId() == null) {
            return SystemOperationResult.failedToInsertResourceSOR(appointment.getClass());
        }

        ObjectId insertedAppointmentId = result.getInsertedId().asObjectId().getValue();

        SystemOperationResult result_client = appendAppointmentToUser(insertedAppointmentId, appointment.getClientId());
        SystemOperationResult result_veterinarian = appendAppointmentToUser(insertedAppointmentId, appointment.getVeterinarianId());

        if (!result_client.getStatus().isSuccess() || !result_veterinarian.getStatus().isSuccess()) {
            return SystemOperationResult.failedToUpdateResourceSOR(Person.class);
        }

        return new SystemOperationResult(StatusCode.SUCCESS);
    }
}
