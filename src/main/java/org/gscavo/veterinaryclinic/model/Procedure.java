package org.gscavo.veterinaryclinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.abstractions.BaseModel;
import org.gscavo.veterinaryclinic.utils.enums.ProcedureType;

import static org.gscavo.veterinaryclinic.utils.DefaultRandomizers.getRandomNumber;
import static org.gscavo.veterinaryclinic.utils.DefaultRandomizers.getRandomString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Procedure implements BaseModel<Procedure> {
    @JsonIgnore
    private ObjectId id;

    private String name = "";

    private String description = "";

    private float price = -1f;

    private ProcedureType type = ProcedureType.TREATMENT;

    public Procedure(Document document) {
        this.id = document.getObjectId("_id");
        this.name = document.getString("name");
        this.description = document.getString("description");
        this.price = document.getDouble("price").floatValue();
        this.type = document.get("type", ProcedureType.class);
    }

    @Override
    public Procedure randomizeAttributes() {
        return Procedure.builder()
                .name(getRandomString(null))
                .price(getRandomNumber().floatValue())
                .description(getRandomString(50))
                .build();
    }
}
