package org.gscavo.veterinaryclinic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.abstractions.BaseModel;

import static org.gscavo.veterinaryclinic.utils.DefaultRandomizers.getRandomString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Symptom implements BaseModel<Symptom> {
    private ObjectId id;

    private String description;

    @Override
    public Symptom randomizeAttributes() {
        return Symptom.builder()
                .description(getRandomString(null))
                .build();
    }
}
