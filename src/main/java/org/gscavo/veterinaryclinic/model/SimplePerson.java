package org.gscavo.veterinaryclinic.model;

import lombok.Builder;
import lombok.NoArgsConstructor;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.abstractions.Person;
import org.gscavo.veterinaryclinic.utils.enums.PersonType;

import static org.gscavo.veterinaryclinic.utils.DefaultRandomizers.getRandomNumericalString;
import static org.gscavo.veterinaryclinic.utils.DefaultRandomizers.getRandomString;

@NoArgsConstructor
public class SimplePerson extends Person {

    @Builder
    public SimplePerson(ObjectId id,
                     String name,
                     String password,
                     String cpf,
                     String phoneNumber,
                     String email,
                     ObjectId address,
                     PersonType personType)
    {
        super(id, name, password, cpf, phoneNumber, email, address, personType);
    }

    public SimplePerson(Document document) {
        super(document);
    }

    @Override
    public SimplePerson randomizeAttributes() {
        return SimplePerson.builder()
                .name(getRandomString(null))
                .cpf(getRandomNumericalString(11))
                .phoneNumber(getRandomNumericalString(11))
                .email(getRandomString(null))
                .address(new ObjectId())
                .build();
    }
}
