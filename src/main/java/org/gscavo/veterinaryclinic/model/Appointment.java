package org.gscavo.veterinaryclinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.abstractions.BaseModel;

import java.util.Date;

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

//    private ArrayList<ObjectId> symptomsIdList;

//    private ArrayList<ObjectId> proceduresIdList;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private Date date;

    private float costAmount = -1f;

    public Appointment(Document document) {
        this.id = document.getObjectId("_id");
        this.clientId = document.getObjectId("clientId");
        this.animalId = document.getObjectId("animalId");
        this.veterinarianId = document.getObjectId("veterinarianId");
//        this.symptomsIdList = new ArrayList<>(document.getList("symptomsIdList", ObjectId.class));
//        this.proceduresIdList = new ArrayList<>(document.getList("proceduresIdList", ObjectId.class));
        this.date = document.getDate("date");
        this.costAmount = document.getDouble("costAmount").floatValue();
    }

    @Override
    public Appointment randomizeAttributes() {
        return Appointment.builder()
                .clientId(new ObjectId())
                .animalId(new ObjectId())
                .veterinarianId(new ObjectId())
//                .symptomsIdList(getSymptomsIdList())
//                .proceduresIdList(getProceduresIdList())
                .date(new Date())
                .costAmount(getRandomNumber().floatValue())
                .build();
    }
}
