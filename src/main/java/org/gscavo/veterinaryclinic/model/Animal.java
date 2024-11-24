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
    @JsonIgnore
    private ObjectId id;
    
    private ObjectId tutor;
    
    private String name = "";
    
    private ObjectId species;
    
    private String race = "";

    public Animal(Document document) {
        this.id = document.getObjectId("_id");

        this.tutor = document.getObjectId("tutor");

        this.name = document.getString("name");

        this.species = document.getObjectId("species");

        this.race = document.getString("race");
    }

    @Override
    public Animal randomizeAttributes() {
        return Animal.builder()
                .species(new ObjectId())
                .tutor(new ObjectId())
                .race(getRandomString(null))
                .name(getRandomString(null))
                .build();
    }
}
