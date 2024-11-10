package org.gscavo.veterinaryclinic.dao;

import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.Veterinarian;

import java.util.ArrayList;
import java.util.Collections;

public class VeterinarianDAO extends PersonDAO<Veterinarian> {
    public VeterinarianDAO() {
        super(Veterinarian.class);
    }

    @Override
    public Veterinarian getFullFilledObject() {
        return Veterinarian.builder()
                .name("Dr. Pera")
                .password("12345678")
                .cpf("09190128931")
                .crmv("123455")
                .email("pera.dr@gmail.com")
                .phoneNumber("18901233214")
                .address(new ObjectId())
                .appointmentsList(new ArrayList<>(Collections.singletonList(new ObjectId())))
                .build();
    }
}
