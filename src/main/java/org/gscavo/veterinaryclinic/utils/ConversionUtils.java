package org.gscavo.veterinaryclinic.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.mongodb.client.MongoIterable;
import org.bson.BsonDateTime;
import org.bson.BsonValue;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.utils.exceptions.ExceptionOutput;
import org.gscavo.veterinaryclinic.utils.mapper.DateSerializer;
import org.gscavo.veterinaryclinic.utils.mapper.ObjectIdDeserializer;
import org.gscavo.veterinaryclinic.utils.mapper.ObjectIdSerializer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ConversionUtils {

    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    private static final ObjectMapper objectMapper = initObjectMapper();

    private static ObjectMapper initObjectMapper() {
        ObjectMapper objMp = new ObjectMapper();

        SimpleModule module = new SimpleModule();

        module.addSerializer(ObjectId.class, new ObjectIdSerializer());
        module.addSerializer(Date.class, new DateSerializer());
        module.addDeserializer(ObjectId.class, new ObjectIdDeserializer());

        objMp.registerModule(module);

        return objMp;
    }

    public static void status() {
        System.out.println(objectMapper.getRegisteredModuleIds());
    }

    public static <T> T documentToType(Document document, Class<T> type) {
        if (document == null) { return null; }
        try {
            T obj = type.getConstructor(Document.class).newInstance(document);
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> Document objectToDocument(T object) {
        try {
            String json = objectMapper.writeValueAsString(object);

            System.out.printf("Transforming object of type %s into String:\n%s%n",
                    object.getClass().getSimpleName(),
                    json);
            return Document.parse(json);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> ArrayList<T> documentsListToTypeList(MongoIterable<Document> iterable, Class<T> type) {
        ArrayList<T> res = new ArrayList<>();

        for (Document document : iterable) {
            T object = documentToType(document, type);
            res.add(object);
        }

        return res;
    }

    public static <T> ArrayList<T> listToArrayList(List<T> list) {
        return new ArrayList<T>(
                Optional
                    .ofNullable(list)
                    .orElseGet(Collections::emptyList)
        );
    }

    public static ObjectId getNullableDocumentObjectId(Document document, String key) {
        if (document.containsKey(key)) {
            Object object = document.get(key);
            if (object != null && object.getClass() == ObjectId.class) {
                return document.getObjectId(key);
            }
        }
        return null;
    }

    public static Date parseBsonDateTime(String day, String time) throws ParseException {
        String dayPlusTime = day + " " + time;
        return formatter.parse(dayPlusTime);
    }

    public static ArrayList<String> parseDayAndHourString(Date date) {
        String dayPlusTime = formatter.format(date);
        return Arrays.stream(
                        dayPlusTime.split(" ")
                ).collect(
                        Collectors.toCollection(ArrayList::new)
                );
    }



    public static ObjectId bsonValueToObjectId(BsonValue value) {

        if (value != null) {
            return value.asObjectId().getValue();
        }

        return null;
    }
}
