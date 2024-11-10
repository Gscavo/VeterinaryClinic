package org.gscavo.veterinaryclinic.test.dao;

import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.Client;

import java.util.ArrayList;
import java.util.Collections;

public class ClientDAOTest {

    public static Client getTestClientFullFilled() {
        return Client.builder()
                .cpf("12345678921")
                .name("John Does")
                .email("john.doe@gmail.com")
                .address(new ObjectId())
                .phoneNumber("19900001234")
                .animal((ArrayList) Collections.singletonList(new ObjectId()))
                .appointmentList((ArrayList) Collections.singletonList(new ObjectId()))
                .build();
    }
}
