package org.gscavo.veterinaryclinic.utils.security;

import org.gscavo.veterinaryclinic.model.abstractions.Person;

import static org.gscavo.veterinaryclinic.utils.enums.PersonType.*;

public class Permissions {

//    public static boolean canRegisterProcedures(Person person) { return isPersonAdmin(person); }
    public static boolean canRegisterProcedures(Person person) { return true; }

//    public static boolean canRegisterEmployees(Person person) { return isPersonAdmin(person); }
    public static boolean canRegisterEmployees(Person person) { return true; }

//    public static boolean canRegisterSymptoms(Person person) { return isPersonVeterinarian(person); }
    public static boolean canRegisterSymptoms(Person person) { return true; }

//    public static boolean canRegister(Person person) { return !isPersonClient(person); }
    public static boolean canRegister(Person person) { return true; }

    public static boolean canUpdateInfo(Person person) { return true; }

    public static boolean any(Person person) { return true; }
}
