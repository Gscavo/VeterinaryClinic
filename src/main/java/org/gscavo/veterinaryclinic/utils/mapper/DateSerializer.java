package org.gscavo.veterinaryclinic.utils.mapper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.bson.types.ObjectId;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateSerializer extends JsonSerializer<Date> {

    private static final String OBJECT_DATE_FIELD_NAME = "$date";
    private static final DateFormat ISO_DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String isoDate = ISO_DATE_FORMATTER.format(date);
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField(OBJECT_DATE_FIELD_NAME, isoDate);
        jsonGenerator.writeEndObject();
    }
}
