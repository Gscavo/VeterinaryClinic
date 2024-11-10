package org.gscavo.veterinaryclinic.dao;

import org.gscavo.veterinaryclinic.model.Symptom;

public class SymptomDAO extends BaseDAO<Symptom> {
    public SymptomDAO() {
        super("symptom", Symptom.class);
    }

    @Override
    public Symptom getFullFilledObject() {
        return Symptom.builder()
                .description("Dor")
                .build();
    }
}
