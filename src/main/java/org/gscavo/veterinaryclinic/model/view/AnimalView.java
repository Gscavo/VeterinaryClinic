package org.gscavo.veterinaryclinic.model.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.abstractions.BaseModel;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnimalView implements BaseModel<AnimalView> {
    private ObjectId id;
    private String name;
    private String race;
    private String species;
    private String tutorName;

    @Override
    public AnimalView randomizeAttributes() {
        return null;
    }
}
