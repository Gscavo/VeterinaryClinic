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

import static org.gscavo.veterinaryclinic.utils.DefaultRandomizers.getRandomNumber;
import static org.gscavo.veterinaryclinic.utils.DefaultRandomizers.getRandomString;

/**
 *
 * @author gscavo
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Animal implements BaseModel<Animal> {
    
    private ObjectId id;
    
    private ObjectId tutor;
    
    private String name;
    
    private ObjectId species;
    
    private String race;
    
    private int age;

    @Override
    public Animal randomizeAttributes() {
        return Animal.builder()
                .age(getRandomNumber())
                .species(new ObjectId())
                .tutor(new ObjectId())
                .race(getRandomString(null))
                .name(getRandomString(null))
                .build();
    }
}
