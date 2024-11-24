package org.gscavo.veterinaryclinic.dao;

import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.Animal;

public class AnimalDAO extends BaseDAO<Animal> {
    public AnimalDAO() {
        super("animal", Animal.class);
    }

    @Override
    public Animal getFullFilledObject() {
        return Animal.builder()
                .name("Linux")
                .race("SRD")
                .tutor(new ObjectId())
                .species(new ObjectId())
                .build();
    }
}
