package org.gscavo.veterinaryclinic.dao;

import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.Animal;

import java.util.ArrayList;
import java.util.stream.Stream;

public class AnimalDAO extends BaseDAO<Animal> {
    public AnimalDAO() {
        super("animal", Animal.class);
    }

    public ArrayList<Animal> findByClientId(ObjectId clientId) {
        ArrayList<Animal> result = new ArrayList<>();
        Bson filter = Filters.eq("tutor", clientId);

        try(MongoCursor<Document> cursor = collection.find(filter).cursor()) {
            while (cursor.hasNext()){
                Animal curAnimal = new Animal(cursor.next());
                result.add(curAnimal);
            }
        }

        return result;
    }

    @Override
    public Animal getFullFilledObject() {
        return Animal.builder()
                .name("Linux")
                .race("SRD")
                .tutor(new ObjectId())
                .species(new ObjectId())
                .build();
    }
}
