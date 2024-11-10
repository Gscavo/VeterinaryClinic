package org.gscavo.veterinaryclinic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.abstractions.BaseModel;

import java.util.ArrayList;

import static org.gscavo.veterinaryclinic.utils.DefaultRandomizers.getRandomNumber;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Appointment implements BaseModel<Appointment> {

    private ObjectId id;

    private ObjectId clientId;

    private ObjectId animalId;

    private ObjectId veterinarianId;

    private ArrayList<ObjectId> symptomsIdList;

    private ArrayList<ObjectId> proceduresIdList;

    private ObjectId dateId;

    private float costAmount;

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
