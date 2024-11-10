package org.gscavo.veterinaryclinic.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertManyResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import lombok.Getter;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.utils.connection.MongoDBConnection;
import org.gscavo.veterinaryclinic.utils.exceptions.DeleteDocumentException;
import org.gscavo.veterinaryclinic.utils.exceptions.InsertOnDatabaseException;
import org.gscavo.veterinaryclinic.utils.exceptions.UpdateDocumentException;

import java.util.ArrayList;
import java.util.Collection;
import java.lang.reflect.Field;

@Getter
public abstract class BaseDAO<T> {

    final protected String collectionName;
    final protected MongoCollection<T> collection;
    final protected Class<T> classType;

    public BaseDAO(String collectionName, Class<T> classType) {
        this.collectionName = collectionName;

        if (MongoDBConnection.mongoDatabase == null) {
            MongoDBConnection.startConnection(false);
        }

        this.collection = MongoDBConnection.mongoDatabase.getCollection(this.collectionName, classType);
        this.classType = classType;

        System.out.printf("Initializing %s collection!\n",  collectionName);
    }

    public T findById(ObjectId id) {
        Bson objectIdFilter = Filters.eq("_id", id).toBsonDocument();
        return this.collection.find(objectIdFilter).first();
    }

    public T findById(String id) {
        Bson objectIdFilter = Filters.eq("_id", new ObjectId(id)).toBsonDocument();
        return this.collection.find(objectIdFilter).first();
    }

    public ArrayList<T> findAll() {
        ArrayList<T> returnedList = new ArrayList<>();

        collection.find().into(new ArrayList<>());

        return returnedList;
    }

    public InsertOneResult insertOne(T item) throws InsertOnDatabaseException {
        try {
            return collection.insertOne(item);
        } catch (Exception e) {
            throw new InsertOnDatabaseException(e);
        }
    }

    public InsertManyResult insertMany(Collection<T> items) throws InsertOnDatabaseException {
        try {
            return collection.insertMany(items.stream().toList());
        } catch (Exception e) {
            throw new InsertOnDatabaseException(e);
        }
    }

    public UpdateResult updateById(ObjectId id, T item) throws UpdateDocumentException, IllegalAccessException {
        T upstreamDocument = this.findById(id);
        Class<?> itemClass = item.getClass();

        Field[] fields = itemClass.getDeclaredFields();

        try {
            for (Field field : fields) {
                field.setAccessible(true);


                if (field.get(item) == null || field.get(item).toString().isEmpty()) {
                    Object nonNullValue = field.get(upstreamDocument);

                    field.set(item, nonNullValue);
                }
            }

            return this.collection.replaceOne(Filters.eq("_id", id), item);
        } catch (IllegalAccessException e) {
            throw new IllegalAccessException(e.getMessage());
        } catch (Exception e) {
            throw new UpdateDocumentException(e.getMessage());
        }
    }

    public DeleteResult deleteById(ObjectId id) throws DeleteDocumentException {
        try {
            Bson objectIdFilter = Filters.eq("_id", id).toBsonDocument();
            return this.collection.deleteOne(objectIdFilter);
        } catch (Exception e) {
            throw new DeleteDocumentException(e);
        }
    }

    public DeleteResult deleteById(String id) throws DeleteDocumentException {
        try {
            Bson objectIdFilter = Filters.eq("_id", new ObjectId(id)).toBsonDocument();
            return this.collection.deleteOne(objectIdFilter);
        } catch (Exception e) {
            throw new DeleteDocumentException(e);
        }
    }

    public void dropCollection() {
        collection.drop();
    }

    public abstract T getFullFilledObject();
}
