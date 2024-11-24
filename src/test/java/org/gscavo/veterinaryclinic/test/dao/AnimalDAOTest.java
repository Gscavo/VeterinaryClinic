package org.gscavo.veterinaryclinic.test.dao;

import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.Animal;

public class AnimalDAOTest {

    public static Animal getTestAnimalFullFilled() {
        return Animal.builder()
                .name("Linux")
                .race("SRD")
                .tutor(new ObjectId())
                .species(new ObjectId())
                .build();
    }
}
