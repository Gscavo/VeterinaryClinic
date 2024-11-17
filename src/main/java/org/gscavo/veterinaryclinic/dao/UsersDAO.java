package org.gscavo.veterinaryclinic.dao;

import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.Secretary;
import org.gscavo.veterinaryclinic.model.SimplePerson;
import org.gscavo.veterinaryclinic.model.abstractions.Person;
import org.gscavo.veterinaryclinic.utils.enums.PersonType;

public class UsersDAO extends PersonDAO<SimplePerson> {

    public UsersDAO() {
        super(SimplePerson.class);
    }

    @Override
    public SimplePerson getFullFilledObject() {
        return SimplePerson.builder()
                .cpf("12345678921")
                .name("John Does")
                .email("john.doe@gmail.com")
                .address(new ObjectId())
                .phoneNumber("19900001234")
                .personType(null)
                .build();
    }
    
    
}
