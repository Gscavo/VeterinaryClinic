package org.gscavo.veterinaryclinic.utils.enums;

import lombok.Getter;
import org.gscavo.veterinaryclinic.dao.*;

@Getter
public enum DAOs {
    ADDRESS(AddressDAO.class),
    ADMIN(AdminDAO.class),
    ANIMAL(AnimalDAO.class),
    APPOINTMENT(AppointmentDAO.class),
    CALENDAR_DATE(CalendarDateDAO.class),
    CLIENT(ClientDAO.class),
    PROCEDURE(ProcedureDAO.class),
    SECRETARY(SecretaryDAO.class),
    SPECIES(SpeciesDAO.class),
    SYMPTOM(SymptomDAO.class),
    VETERINARIAN(VeterinarianDAO.class);

    final private Class<? extends BaseDAO<?>> daoClass;

    DAOs(Class<? extends BaseDAO<?>> classValue) {
        this.daoClass = classValue;
    }
}
