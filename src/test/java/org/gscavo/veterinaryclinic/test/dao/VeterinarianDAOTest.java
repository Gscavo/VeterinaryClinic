package org.gscavo.veterinaryclinic.test.dao;

import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.Veterinarian;

import java.util.ArrayList;
import java.util.Collections;

public class VeterinarianDAOTest {

    public static Veterinarian getTestVeterinarianFullFilled() {
        return Veterinarian.builder()
                .name("Dr. Pera")
                .cpf("09190128931")
                .address(new ObjectId())
                .crmv("123455")
                .email("pera.dr@gmail.com")
                .appointmentsList((ArrayList) Collections.singletonList(new ObjectId()))
                .phoneNumber("18901233214")
                .build();
    }
}
