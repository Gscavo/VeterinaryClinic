package org.gscavo.veterinaryclinic.dao;

import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.Client;
import java.util.ArrayList;
import java.util.Collections;

public class ClientDAO extends PersonDAO<Client> {
    public ClientDAO() {
        super(Client.class);
    }

    @Override
    public Client getFullFilledObject() {
        return Client.builder()
                .cpf("12345678921")
                .name("John Does")
                .email("john.doe@gmail.com")
                .address(new ObjectId())
                .phoneNumber("19900001234")
                .animal(new ArrayList<>(Collections.singletonList(new ObjectId())))
                .appointmentList(new ArrayList<>(Collections.singletonList(new ObjectId())))
                .build();
    }
}
