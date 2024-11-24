package org.gscavo.veterinaryclinic.dao;

import com.mongodb.client.model.Filters;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.Client;

import java.util.ArrayList;
import java.util.Collections;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.gscavo.veterinaryclinic.utils.enums.PersonType;

public class ClientDAO extends PersonDAO<Client> {

    public ClientDAO() {
        super(Client.class);
    }
    
    @Override
    public ArrayList<Client> findAll() {
        Bson filter = Filters.eq("type", PersonType.CLIENT);
        
        ArrayList<Client> allClients = new ArrayList<>();

        for (Document document : this.collection.find(filter)) {
            Client client = new Client(document);

            allClients.add(client);
        }

        return allClients;

    }

    @Override
    public Client getFullFilledObject() {
        return Client.builder()
                .cpf("12345678921")
                .name("John Does")
                .email("john.doe@gmail.com")
                .phoneNumber("19900001234")
                .animal(new ArrayList<>(Collections.singletonList(new ObjectId())))
                .appointmentList(new ArrayList<>(Collections.emptyList()))
                .build();
    }
}
