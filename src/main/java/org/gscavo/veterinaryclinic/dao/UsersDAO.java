package org.gscavo.veterinaryclinic.dao;

import org.gscavo.veterinaryclinic.model.abstractions.Person;

public class UsersDAO extends PersonDAO<Person> {

    public UsersDAO() {
        super(Person.class);
    }

    @Override
    public Person getFullFilledObject() {
        return null;
    }
}
