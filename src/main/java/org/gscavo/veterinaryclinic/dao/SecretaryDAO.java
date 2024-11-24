package org.gscavo.veterinaryclinic.dao;

import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.Secretary;

public class SecretaryDAO extends PersonDAO<Secretary> {

    public SecretaryDAO() {
        super(Secretary.class);
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
