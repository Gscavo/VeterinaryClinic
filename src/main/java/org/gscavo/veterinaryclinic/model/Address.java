/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.gscavo.veterinaryclinic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.abstractions.BaseModel;

import static org.gscavo.veterinaryclinic.utils.DefaultRandomizers.*;

/**
 *
 * @author gscavo
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address implements BaseModel<Address> {
    
    private ObjectId id;
    
    private int number;
    
    private String street;
    
    private String neighborhood;
    
    private String city;
    
    private String state;
    
    private String zipCode;

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
