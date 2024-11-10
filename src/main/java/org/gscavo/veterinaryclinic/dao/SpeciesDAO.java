package org.gscavo.veterinaryclinic.dao;

import org.gscavo.veterinaryclinic.model.Species;

public class SpeciesDAO extends BaseDAO<Species> {
    public SpeciesDAO() {
        super("species", Species.class);
    }

    @Override
    public Species getFullFilledObject() {
        return Species.builder()
                .name("Gato")
                .scientificName("Gatus Limeiraneus")
                .description("Animal felino")
                .build();
    }
}
