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
                .date(new BsonDateTime(new Date().getTime()))
                .proceduresIdList(new ArrayList<>(Collections.singletonList(new ObjectId())))
                .symptomsIdList(new ArrayList<>(Collections.singletonList(new ObjectId())))
                .veterinarianId(new ObjectId())
                .build();
    }
}
