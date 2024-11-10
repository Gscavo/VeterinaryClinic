package org.gscavo.veterinaryclinic.dao;

import org.bson.BsonDateTime;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.CalendarDate;

public class CalendarDateDAO extends BaseDAO<CalendarDate> {
    public CalendarDateDAO() {
        super("calendarDate", CalendarDate.class);
    }


    @Override
    public CalendarDate getFullFilledObject() {
        return CalendarDate.builder()
                .date(new BsonDateTime(100000L))
                .appointmentId(new ObjectId())
                .build();
    }
}
