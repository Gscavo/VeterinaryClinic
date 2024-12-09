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
public class AppointmentView implements BaseModel<AppointmentView> {
    private ObjectId id;
    private float price;
    private String date;
    private String time;
    private AppointmentStatus status;
    private String veterinarianName;
    private String tutorName;
    private String animalName;
    private String procedureName;
    private String symptomsDescription;

    @Override
    public AppointmentView randomizeAttributes() {
        return null;
    }
}
