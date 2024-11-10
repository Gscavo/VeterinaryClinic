package org.gscavo.veterinaryclinic.dao;

import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.Appointment;

import java.util.ArrayList;
import java.util.Collections;

public class AppointmentDAO extends BaseDAO<Appointment> {
    public AppointmentDAO() {
        super("appointments", Appointment.class);
    }

    @Override
    public Appointment getFullFilledObject() {
        return Appointment.builder()
                .animalId(new ObjectId())
                .clientId(new ObjectId())
                .costAmount(100.0f)
                .dateId(new ObjectId())
                .proceduresIdList(new ArrayList<>(Collections.singletonList(new ObjectId())))
                .symptomsIdList(new ArrayList<>(Collections.singletonList(new ObjectId())))
                .veterinarianId(new ObjectId())
                .build();
    }
}
