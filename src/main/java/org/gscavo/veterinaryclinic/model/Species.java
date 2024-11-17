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

import static org.gscavo.veterinaryclinic.utils.DefaultRandomizers.getRandomString;

/**
 *
 * @author gscavo
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Species implements BaseModel<Species> {
    @JsonIgnore
    private ObjectId id;

    private String name;

    private String scientificName;

    private String description;

    public Species(Document document) {
        this.id = document.getObjectId("_id");
        this.name = document.getString("name");
        this.scientificName = document.getString("scientificName");
        this.description = document.getString("description");
    }

    @Override
    public Species randomizeAttributes() {
        return Species.builder()
                .name(getRandomString(null))
                .description(getRandomString(null))
                .scientificName(getRandomString(20))
                .build();
    }
}
