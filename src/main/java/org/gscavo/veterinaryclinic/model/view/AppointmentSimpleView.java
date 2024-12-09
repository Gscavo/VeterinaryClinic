package org.gscavo.veterinaryclinic.model.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.abstractions.BaseModel;
import org.gscavo.veterinaryclinic.utils.enums.AppointmentStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentSimpleView implements BaseModel<AppointmentSimpleView> {
    private ObjectId id;
    private float price;
    private String date;
    private String time;
    private AppointmentStatus status;
    private String tutorName;
    private String animalName;

    @Override
    public AppointmentSimpleView randomizeAttributes() {
        return null;
    }
}
