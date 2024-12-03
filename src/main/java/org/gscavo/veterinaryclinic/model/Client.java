/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.gscavo.veterinaryclinic.model;

import java.util.ArrayList;
import java.util.List;

import lombok.*;
import org.bson.Document;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.abstractions.BaseModel;
import org.gscavo.veterinaryclinic.model.abstractions.Person;
import org.gscavo.veterinaryclinic.utils.enums.PersonType;

import static org.gscavo.veterinaryclinic.utils.ConversionUtils.listToArrayList;
import static org.gscavo.veterinaryclinic.utils.DefaultRandomizers.getRandomNumericalString;
import static org.gscavo.veterinaryclinic.utils.DefaultRandomizers.getRandomString;

/**
 *
 * @author gscavo
 */
@Getter
@EqualsAndHashCode(callSuper = true)
public class Client extends Person {

    public Client() {
        super();
        this.setType(PersonType.CLIENT);
    }

    @Builder
    public Client(ObjectId id,
                  String name,
                  String password,
                  String cpf,
                  String phoneNumber,
                  String email) {
        super(id, name, password, cpf, phoneNumber, email, PersonType.CLIENT);
    }


    @Override
    public Client randomizeAttributes() {
        return Client.builder()
                .name(getRandomString(null))
                .password(getRandomString(null))
                .cpf(getRandomNumericalString(11))
                .phoneNumber(getRandomNumericalString(11))
                .email(getRandomString(null))
                .build();
    }

    public Client(Document document) {
        super( document );
    }
}
