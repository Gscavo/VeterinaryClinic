package org.gscavo.veterinaryclinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.abstractions.BaseModel;

import java.util.ArrayList;

import static org.gscavo.veterinaryclinic.utils.DefaultRandomizers.getRandomNumber;

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

    private ArrayList<ObjectId> symptomsIdList;

    private ArrayList<ObjectId> proceduresIdList;

    private ObjectId dateId;

    private float costAmount;

    public Appointment(Document document) {
        this.id = document.getObjectId("_id");
        this.clientId = document.getObjectId("clientId");
        this.animalId = document.getObjectId("animalId");
        this.veterinarianId = document.getObjectId("veterinarianId");
        this.symptomsIdList = new ArrayList<>(document.getList("symptomsIdList", ObjectId.class));
        this.proceduresIdList = new ArrayList<>(document.getList("proceduresIdList", ObjectId.class));
        this.dateId = document.getObjectId("dateId");
        this.costAmount = document.getDouble("costAmount").floatValue();
    }

    @Override
    public Appointment randomizeAttributes() {
        return Appointment.builder()
                .clientId(new ObjectId())
                .animalId(new ObjectId())
                .veterinarianId(new ObjectId())
                .symptomsIdList(getSymptomsIdList())
                .proceduresIdList(getProceduresIdList())
                .dateId(new ObjectId())
                .costAmount(getRandomNumber().floatValue())
                .build();
    }
}
