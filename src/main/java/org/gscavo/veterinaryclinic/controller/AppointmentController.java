package org.gscavo.veterinaryclinic.controller;

import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.dao.AppointmentDAO;
import org.gscavo.veterinaryclinic.model.Appointment;
import org.gscavo.veterinaryclinic.model.abstractions.Person;
import org.gscavo.veterinaryclinic.utils.enums.StatusCode;
import org.gscavo.veterinaryclinic.utils.information.SystemOperationResult;
import org.gscavo.veterinaryclinic.utils.security.Permissions;

import static org.gscavo.veterinaryclinic.controller.UserController.appendAppointmentToUser;
import org.gscavo.veterinaryclinic.controller.abstractions.BaseController;
import org.gscavo.veterinaryclinic.dao.VeterinarianDAO;
import org.gscavo.veterinaryclinic.model.Veterinarian;
import static org.gscavo.veterinaryclinic.utils.UserUtils.canUserDoAction;
import org.gscavo.veterinaryclinic.utils.enums.Controllers;

@Getter
public class AppointmentController extends BaseController<Appointment> {

    private static final AppointmentDAO APPOINTMENT_DAO = DAOController.getDaoByClass(Appointment.class);

    public AppointmentController() {
        super(Appointment.class);
    }
    
    @Override
    public SystemOperationResult register(Appointment appointment) {
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
    
    public List<String> getNextDates() {
        ArrayList<String> dates = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Calendar calendar = Calendar.getInstance();
        
        int addedDays = 0;
        while (addedDays < 15) {
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                dates.add(dateFormat.format(calendar.getTime())); // Add the weekday
                addedDays++;
            }
            calendar.add(Calendar.DAY_OF_MONTH, 1); // Move to the next day
        }

        return dates;
    }
    
    public ArrayList<String> getHours() {
        ArrayList<String> hours = new ArrayList<>();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

        // Get today's date and set the start time to 8:00 AM
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        // Generate hours between 8:00 AM and 6:00 PM (inclusive)
        for (int i = 0; i < 15 && calendar.get(Calendar.HOUR_OF_DAY) <= 18; i++) {
            hours.add(timeFormat.format(calendar.getTime())); // Format and add the time
            calendar.add(Calendar.HOUR_OF_DAY, 1); // Move to the next hour
        }

        return hours;
    }
}
