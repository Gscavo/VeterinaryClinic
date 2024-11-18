package org.gscavo.veterinaryclinic.model.simpleModels;

import lombok.Getter;
import lombok.Setter;
import org.gscavo.veterinaryclinic.model.Address;
import org.gscavo.veterinaryclinic.model.abstractions.Person;

@Getter
@Setter
public class PersonXAddress<T extends Person> {

    private T person;

    private Address address;

    public PersonXAddress(T person, Address address) {
        this.person = person;
        this.address = address;
    }
}
