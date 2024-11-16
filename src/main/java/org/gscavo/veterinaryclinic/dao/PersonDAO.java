package org.gscavo.veterinaryclinic.dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.abstractions.Person;
import org.gscavo.veterinaryclinic.utils.enums.PersonType;

import java.util.ArrayList;

import static org.gscavo.veterinaryclinic.utils.ConversionUtils.documentToType;
import static org.gscavo.veterinaryclinic.utils.ConversionUtils.documentsListToTypeList;

public abstract class PersonDAO<T extends Person> extends BaseDAO<T> {

    public PersonDAO(Class<T> classType) {
        super("person", classType);
    }

    public T findByEmailAndPassword(String email, String password) {
        Bson filter = Filters.and(Filters.eq("email", email), Filters.eq("password", password)).toBsonDocument();
        return documentToType(
                collection.find(filter).first(),
                this.classType
        );
    }

    public DeleteResult deleteByCpf(String cpf) {
        return collection.deleteOne(Filters.eq("cpf", cpf));
    }

    @Override
    public ArrayList<T> findAll() {
        return documentsListToTypeList(
                collection.find(),
                classType
        );
    }
}
