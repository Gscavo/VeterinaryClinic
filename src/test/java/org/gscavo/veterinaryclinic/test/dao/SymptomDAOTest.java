package org.gscavo.veterinaryclinic.test.dao;

import org.gscavo.veterinaryclinic.model.Symptom;

public class SymptomDAOTest {

    public static Symptom getTestSymptomFullFilled() {
        return Symptom.builder()
                .description("Dor")
                .build();
    }
}
