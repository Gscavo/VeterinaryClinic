/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.gscavo.veterinaryclinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.abstractions.BaseModel;

import static org.gscavo.veterinaryclinic.utils.DefaultRandomizers.*;
import org.gscavo.veterinaryclinic.utils.ObjectUtils;

/**
 *
 * @author gscavo
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address implements BaseModel<Address> {

    @JsonIgnore
    private ObjectId id;

    @Builder.Default
    private int number = -1;
    @Builder.Default
    private String street = "";
    @Builder.Default
    private String neighborhood = "";
    @Builder.Default
    private String city = "";
    @Builder.Default
    private String state = "";
    @Builder.Default
    private String zipCode = "";
    
    public Address(Document document) {
        this.id = document.getObjectId("_id");
        this.number = document.getInteger("number", -1);
        this.street = document.getString("street");
        this.neighborhood = document.getString("neighborhood");
        this.city = document.getString("city");
        this.state = document.getString("state");
        this.zipCode = document.getString("zipCode");
    }
    
    @Override
    public Address randomizeAttributes() {
        return Address.builder()
                .number(getRandomNumber())
                .street(getRandomString(null))
                .neighborhood(getRandomString(null))
                .city(getRandomString(null))
                .state(getRandomString(null))
                .zipCode(getRandomNumericalString(8))
                .build();
    }
}
