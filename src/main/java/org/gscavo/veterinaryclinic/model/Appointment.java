package org.gscavo.veterinaryclinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.abstractions.BaseModel;

import java.util.Date;

import static org.gscavo.veterinaryclinic.utils.DefaultRandomizers.getRandomNumber;
import org.gscavo.veterinaryclinic.utils.enums.AppointmentStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Appointment implements BaseModel<Appointment> {
    @JsonIgnore
    private ObjectId id;

    private ObjectId clientId;

    private ObjectId animalId;

    private ObjectId veterinarianId;

    private ObjectId symptomId;
    
    private ObjectId procedureId;
    
    @Builder.Default
    private AppointmentStatus status = AppointmentStatus.NOT_REALIZED;
    
    private Date date;

    @Builder.Default
    private float costAmount = -1f;

    public Appointment(Document document) {
        this.id = document.getObjectId("_id");
        this.clientId = document.getObjectId("clientId");
        this.animalId = document.getObjectId("animalId");
        this.veterinarianId = document.getObjectId("veterinarianId");
        this.symptomId = document.getObjectId("symptomId");
        this.procedureId = document.getObjectId("procedureId");
        this.date = document.getDate("date");
        this.costAmount = document.getDouble("costAmount").floatValue();
        String statusStr = document.getString("status");
        this.status = AppointmentStatus.valueOf(
                statusStr != null ?
                        statusStr :
                        AppointmentStatus.NOT_REALIZED.name()
        );
    }

    @Override
    public Appointment randomizeAttributes() {
        return Appointment.builder()
                .clientId(new ObjectId())
                .animalId(new ObjectId())
                .veterinarianId(new ObjectId())
                .date(new Date())
                .costAmount(getRandomNumber().floatValue())
                .build();
    }
}