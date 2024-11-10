package org.gscavo.veterinaryclinic.dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.abstractions.Person;
import org.gscavo.veterinaryclinic.utils.enums.PersonType;

import java.util.ArrayList;

public abstract class PersonDAO<T extends Person> extends BaseDAO<T> {

    public PersonDAO(Class<T> classType) {
        super("person", classType);
    }

    public T findByEmailAndPassword(String email, String password) {
        Bson filter = Filters.and(Filters.eq("email", email), Filters.eq("password", password)).toBsonDocument();
        return collection.find(filter).first();
    }

    public UpdateResult updateByCpf(T updatedPerson) {
        return collection.replaceOne(Filters.eq("cpf"), updatedPerson);
    }

    public DeleteResult deleteByCpf(String cpf) {
        return collection.deleteOne(Filters.eq("cpf", cpf));
    }

    @Override
    public ArrayList<T> findAll() {
        FindIterable<T> findIterable = collection.find(Filters.eq("type", PersonType.getByClassType(this.classType)));
        ArrayList<T> res = new ArrayList<>();

        try (MongoCursor<T> cursor = findIterable.iterator()) {
            while (cursor.hasNext()) {
                res.add(cursor.next());
            }
        }

        return res;
    }

    @Override
    public T findById(ObjectId id) {
        Bson objectIdFilter = Filters.eq("_id", id).toBsonDocument();
        return this.collection.find(objectIdFilter).first();
    }

}
