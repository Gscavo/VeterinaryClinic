package org.gscavo.veterinaryclinic.test.dao;

import org.gscavo.veterinaryclinic.model.Species;

public class SpeciesDAOTest {

    public static Species getTestSpeciesFullFilled() {
        return Species.builder()
                .name("Gato")
                .scientificName("Gatus Limeiraneus")
                .description("Animal felino")
                .build();
    }
}
