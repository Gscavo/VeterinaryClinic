package org.gscavo.veterinaryclinic.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.mongodb.client.MongoIterable;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.utils.mapper.ObjectIdDeserializer;
import org.gscavo.veterinaryclinic.utils.mapper.ObjectIdSerializer;

import java.util.*;

public class ConversionUtils {

    private static final ObjectMapper objectMapper = initObjectMapper();

    private static ObjectMapper initObjectMapper() {
        ObjectMapper objMp = new ObjectMapper();

        SimpleModule module = new SimpleModule();

        module.addSerializer(ObjectId.class, new ObjectIdSerializer());
        module.addDeserializer(ObjectId.class, new ObjectIdDeserializer());

        objMp.registerModule(module);

        return objMp;
    }

    public static void status() {
        System.out.println(objectMapper.getRegisteredModuleIds());
    }

    public static <T> T documentToType(Document document, Class<T> type) {
        try {
            return type.getConstructor(Document.class).newInstance(document);
        } catch (Exception e) {
            System.err.println("!ERROR!\n" + e.getMessage());
            return null;
        }
    }

    public static <T> Document objectToDocument(T object) {
        try {
            String json = objectMapper.writeValueAsString(object);
            return Document.parse(json);
        } catch (Exception e) {
            System.err.println("!ERROR!\n" + e.getMessage());
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
            if (object.getClass() == ObjectId.class) {
                return document.getObjectId(key);
            }
        }
        return null;
    }
}
