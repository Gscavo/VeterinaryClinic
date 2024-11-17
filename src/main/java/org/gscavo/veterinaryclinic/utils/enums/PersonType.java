package org.gscavo.veterinaryclinic.utils.enums;

import lombok.Getter;
import org.gscavo.veterinaryclinic.model.*;
import org.gscavo.veterinaryclinic.model.abstractions.Person;

@Getter
public enum PersonType {
    ADMIN(Admin.class),
    SECRETARY(Secretary.class),
    CLIENT(Client.class),
    VETERINARIAN(Veterinarian.class),
    NONE(SimplePerson.class);

    private final Class<? extends Person> modelClass;

    PersonType(Class<? extends Person> modelClass) {
        this.modelClass = modelClass;
    }
    
    public static PersonType getByName(String name) {
        return PersonType.valueOf(name.toUpperCase());
    }

    public static PersonType getByClassType(Class<?> classType) {
        for (PersonType userType : values()) {
            if (userType.modelClass.equals(classType)) {
                return userType;
            }
        }
        throw new IllegalArgumentException("No UserType found for the given class type: " + classType.getName());
    }

    public static boolean isPersonClient(Person person) { return person.getType().equals(CLIENT); }

    public static boolean isPersonVeterinarian(Person person) { return person.getType().equals(VETERINARIAN); }

    public static boolean isPersonSecretary(Person person) { return person.getType().equals(SECRETARY); }

    public static boolean isPersonAdmin(Person person) { return person.getType().equals(ADMIN); }
}
