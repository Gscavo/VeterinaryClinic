/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.gscavo.veterinaryclinic.model;

import java.util.ArrayList;

import lombok.*;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.abstractions.BaseModel;
import org.gscavo.veterinaryclinic.model.abstractions.Person;
import org.gscavo.veterinaryclinic.utils.enums.PersonType;

import static org.gscavo.veterinaryclinic.utils.DefaultRandomizers.getRandomNumericalString;
import static org.gscavo.veterinaryclinic.utils.DefaultRandomizers.getRandomString;

/**
 *
 * @author gscavo
 */
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Client extends Person implements BaseModel<Client> {

    private ArrayList<ObjectId> animal;
    
    private ArrayList<ObjectId> appointmentList;

    @Builder
    public Client(ObjectId id,
                  String name,
                  String password,
                  String cpf,
                  String phoneNumber,
                  String email,
                  ObjectId address,
                  ArrayList<ObjectId> animal,
                  ArrayList<ObjectId> appointmentList) {
        super(id, name, password, cpf, phoneNumber, email, address);
        this.animal = animal;
        this.appointmentList = appointmentList;
    }


    @Override
    public Client randomizeAttributes() {
        return Client.builder()
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
        return PersonType.CLIENT;
    }
}
