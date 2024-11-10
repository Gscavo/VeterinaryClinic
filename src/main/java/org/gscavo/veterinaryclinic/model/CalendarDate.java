package org.gscavo.veterinaryclinic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.BsonDateTime;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.abstractions.BaseModel;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalendarDate implements BaseModel<CalendarDate> {

    private ObjectId id;

    private BsonDateTime date;

    private ObjectId appointmentId;


    @Override
    public CalendarDate randomizeAttributes() {
        return CalendarDate.builder()
                .date(new BsonDateTime(5000L))
                .appointmentId(new ObjectId())
                .build();
    }
}
