package org.gscavo.veterinaryclinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.BsonDateTime;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.abstractions.BaseModel;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalendarDate implements BaseModel<CalendarDate> {
    @JsonIgnore
    private ObjectId id;

    private BsonDateTime date;

    private ObjectId appointmentId;

    public CalendarDate(Document document) {
        this.id = document.getObjectId("_id");
        this.date = document.get("date", BsonDateTime.class);
        this.appointmentId = document.getObjectId("appointmentId");
    }

    @Override
    public CalendarDate randomizeAttributes() {
        return CalendarDate.builder()
                .date(new BsonDateTime(5000L))
                .appointmentId(new ObjectId())
                .build();
    }
}
