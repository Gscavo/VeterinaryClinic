package org.gscavo.veterinaryclinic.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.abstractions.BaseModel;
import org.gscavo.veterinaryclinic.model.abstractions.Person;
import org.gscavo.veterinaryclinic.utils.enums.PersonType;

import java.util.ArrayList;

import static org.gscavo.veterinaryclinic.utils.DefaultRandomizers.getRandomNumericalString;
import static org.gscavo.veterinaryclinic.utils.DefaultRandomizers.getRandomString;

@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Veterinarian extends Person implements BaseModel<Veterinarian> {

    private String crmv;

    private ArrayList<ObjectId> appointmentList;

    @Builder
    public Veterinarian(ObjectId id,
                        String name,
                        String password,
                        String cpf,
                        String phoneNumber,
                        String email,
                        ObjectId address,
                        String crmv,
                        ArrayList<ObjectId> appointmentsList)
    {
        super(id, name, password, cpf, phoneNumber, email, address);
        this.crmv = crmv;
        this.appointmentList = appointmentsList;
    }

    @Override
    public Veterinarian randomizeAttributes() {
        return Veterinarian.builder()
                .name(getRandomString(null))
                .cpf(getRandomNumericalString(11))
                .phoneNumber(getRandomNumericalString(11))
                .email(getRandomString(null))
                .address(new ObjectId())
                .build();
    }

    @Override
    public PersonType getType() {
        return PersonType.VETERINARIAN;
    }
}
