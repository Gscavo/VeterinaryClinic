package org.gscavo.veterinaryclinic.test.dao;

import org.bson.BsonDateTime;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.CalendarDate;

public class CalendarDateDAOTest {

    public static CalendarDate getTestCalendarDateFullFilled() {
        return CalendarDate.builder()
                .date(new BsonDateTime(100000L))
                .appointmentId(new ObjectId())
                .build();
    }
}
