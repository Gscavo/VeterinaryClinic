package org.gscavo.veterinaryclinic.dao;

import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import org.bson.conversions.Bson;
import org.gscavo.veterinaryclinic.model.abstractions.Person;
import org.gscavo.veterinaryclinic.utils.enums.PersonType;

public class UsersDAO extends PersonDAO<Person> {

    public UsersDAO() {
        super(Person.class);
    }

    @Override
    public Person getFullFilledObject() {
        return null;
    }
    
    
}
