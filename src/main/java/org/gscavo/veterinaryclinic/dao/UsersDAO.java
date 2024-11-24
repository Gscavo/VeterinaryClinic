package org.gscavo.veterinaryclinic.dao;

import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.User;

public class UsersDAO extends PersonDAO<User> {

    public UsersDAO() {
        super(User.class);
    }

    @Override
    public User getFullFilledObject() {
        return User.builder()
                .cpf("12345678921")
                .name("John Does")
                .email("john.doe@gmail.com")
                .phoneNumber("19900001234")
                .personType(null)
                .build();
    }
    
    
}
