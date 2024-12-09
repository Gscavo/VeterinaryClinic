package org.gscavo.veterinaryclinic.dao;

import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.Admin;
import org.gscavo.veterinaryclinic.model.Secretary;
import org.gscavo.veterinaryclinic.utils.enums.PersonType;

import java.util.ArrayList;

public class SecretaryDAO extends PersonDAO<Secretary> {

    public SecretaryDAO() {
        super(Secretary.class);
    }

    @Override
    public ArrayList<Secretary> findAll() {
        Bson filter = Filters.eq("type", PersonType.SECRETARY);

        ArrayList<Secretary> allSecretaries = new ArrayList<>();

        for (Document document : this.collection.find(filter)) {
            Secretary secretary = new Secretary(document);

            allSecretaries.add(secretary);
        }

        return allSecretaries;
    }

    @Override
    public Secretary getFullFilledObject() {
        return Secretary.builder()
                .name("Maria")
                .password("12345678")
                .cpf("12312312348")
                .email("maria.mari@gmail.com")
                .phoneNumber("12907867451")
                .build();
    }
}
