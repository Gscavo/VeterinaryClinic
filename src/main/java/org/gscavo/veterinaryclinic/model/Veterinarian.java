package org.gscavo.veterinaryclinic.model;

import lombok.*;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.abstractions.Person;
import org.gscavo.veterinaryclinic.utils.enums.PersonType;

import static org.gscavo.veterinaryclinic.utils.DefaultRandomizers.getRandomNumericalString;
import static org.gscavo.veterinaryclinic.utils.DefaultRandomizers.getRandomString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Veterinarian extends Person {

    private String crmv = "";

    public Veterinarian() {
        super();
        this.setType(PersonType.VETERINARIAN);
    }

    @Builder
    public Veterinarian(ObjectId id,
                        String name,
                        String password,
                        String cpf,
                        String phoneNumber,
                        String email,
                        String crmv)
    {
        super(id, name, password, cpf, phoneNumber, email, PersonType.VETERINARIAN);
        this.crmv = crmv;
    }

    public Veterinarian(Document document) {
        super(document);
        this.crmv = document.getString("crmv");
    }

    @Override
    public Veterinarian randomizeAttributes() {
        return Veterinarian.builder()
                .name(getRandomString(null))
                .cpf(getRandomNumericalString(11))
                .phoneNumber(getRandomNumericalString(11))
                .email(getRandomString(null))
                .build();
    }
}
