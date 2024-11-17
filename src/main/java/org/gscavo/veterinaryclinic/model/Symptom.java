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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Symptom implements BaseModel<Symptom> {
    @JsonIgnore
    private ObjectId id;

    private String description = "";

    public Symptom(Document document) {
        this.id = document.getObjectId("_id");
        this.description = document.getString("description");
    }

    @Override
    public Symptom randomizeAttributes() {
        return Symptom.builder()
                .description(getRandomString(null))
                .build();
    }
}
