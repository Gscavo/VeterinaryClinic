package org.gscavo.veterinaryclinic.test.dao;

import org.bson.BsonDateTime;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.Appointment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class AppointmentDAOTest {

    public static Appointment getTestAppointmentFullFilled() {
        return Appointment.builder()
                .animalId(new ObjectId())
                .clientId(new ObjectId())
                .costAmount(100.0f)
                .date(new Date())
                .veterinarianId(new ObjectId())
                .build();
    }
}
