package org.gscavo.veterinaryclinic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    private ObjectId id;

    private String name;

    private String description;

    private float price;

    private ProcedureType type;

    @Override
    public Procedure randomizeAttributes() {
        return Procedure.builder()
                .name(getRandomString(null))
                .price(getRandomNumber().floatValue())
                .description(getRandomString(50))
                .build();
    }
}
