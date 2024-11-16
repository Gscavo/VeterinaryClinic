package org.gscavo.veterinaryclinic.model;

import lombok.*;
import org.bson.Document;
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
        super(id, name, password, cpf, phoneNumber, email, address, PersonType.VETERINARIAN);
        this.crmv = crmv;
        this.appointmentList = appointmentsList;
    }

    public Veterinarian(Document document) {
        super(document);
        this.crmv = document.getString("crmv");
        this.appointmentList = new ArrayList<>(document.getList("appointmentList", ObjectId.class));
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
}
