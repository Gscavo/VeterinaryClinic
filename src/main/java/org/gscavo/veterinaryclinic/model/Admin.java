package org.gscavo.veterinaryclinic.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.abstractions.BaseModel;
import org.gscavo.veterinaryclinic.model.abstractions.Person;
import org.gscavo.veterinaryclinic.utils.enums.PersonType;

import static org.gscavo.veterinaryclinic.utils.DefaultRandomizers.getRandomNumericalString;
import static org.gscavo.veterinaryclinic.utils.DefaultRandomizers.getRandomString;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Admin extends Person implements BaseModel<Admin> {

    @Builder
    public Admin(ObjectId id,
                     String name,
                     String password,
                     String cpf,
                     String phoneNumber,
                     String email,
                     ObjectId address)
    {
        super(id, name, password, cpf, phoneNumber, email, address);
    }


    @Override
    public Admin randomizeAttributes() {
        return Admin.builder()
                .name(getRandomString(null))
                .password(getRandomString(null))
                .cpf(getRandomNumericalString(11))
                .phoneNumber(getRandomNumericalString(11))
                .email(getRandomString(null))
                .address(new ObjectId())
                .build();
    }

    @Override
    public PersonType getType() {
        return PersonType.ADMIN;
    }
}
