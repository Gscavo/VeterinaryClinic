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
public class User extends Person {

    @Builder
    public User(ObjectId id,
                String name,
                String password,
                String cpf,
                String phoneNumber,
                String email,
                PersonType personType)
    {
        super(id, name, password, cpf, phoneNumber, email, personType);
    }

    public User(Document document) {
        super(document);
    }

    @Override
    public User randomizeAttributes() {
        return User.builder()
                .name(getRandomString(null))
                .cpf(getRandomNumericalString(11))
                .phoneNumber(getRandomNumericalString(11))
                .email(getRandomString(null))
                .build();
    }
}
