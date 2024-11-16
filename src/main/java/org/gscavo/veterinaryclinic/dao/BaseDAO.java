package org.gscavo.veterinaryclinic.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertManyResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import lombok.Getter;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.utils.connection.MongoDBConnection;
import org.gscavo.veterinaryclinic.utils.exceptions.DeleteDocumentException;
import org.gscavo.veterinaryclinic.utils.exceptions.InsertOnDatabaseException;
import org.gscavo.veterinaryclinic.utils.exceptions.UpdateDocumentException;

import javax.print.Doc;
import java.io.DataInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

import static org.gscavo.veterinaryclinic.utils.ConversionUtils.documentToType;
import static org.gscavo.veterinaryclinic.utils.ConversionUtils.objectToDocument;

@Getter
public abstract class BaseDAO<T> {

    final protected String collectionName;
    final protected MongoCollection<Document> collection;
    final protected Class<T> classType;

    public BaseDAO(String collectionName, Class<T> classType) {
        this.collectionName = collectionName;

        if (MongoDBConnection.mongoDatabase == null) {
            MongoDBConnection.startConnection(false);
        }

        this.collection = MongoDBConnection.mongoDatabase.getCollection(this.collectionName);
        this.classType = classType;

        System.out.printf("Initializing %s collection!\n",  collectionName);
    }

    public T findById(ObjectId id) {
        Bson objectIdFilter = Filters.eq("_id", id).toBsonDocument();
        return documentToType(this.collection.find(objectIdFilter).first(), this.classType);
    }

    public T findById(String id) {
        Bson objectIdFilter = Filters.eq("_id", new ObjectId(id)).toBsonDocument();
        return documentToType(this.collection.find(objectIdFilter).first(), this.classType);
    }

    public ArrayList<T> findAll() {
        ArrayList<T> returnedList = new ArrayList<>();

        collection.find().into(new ArrayList<>());

        return returnedList;
    }

    public InsertOneResult insertOne(T item) throws InsertOnDatabaseException {
        try {
            Document document = objectToDocument(item);
            System.out.println(document.toJson());
            return collection.insertOne(Objects.requireNonNull(document));
        } catch (Exception e) {
            throw new InsertOnDatabaseException(e);
        }
    }

    public InsertManyResult insertMany(Collection<T> items) throws InsertOnDatabaseException {
        try {
            List<Document> documents = items.stream()
                    .map(item -> Objects.requireNonNull(objectToDocument(item)))
                    .toList();

            return collection.insertMany(documents);
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

            return this.collection.replaceOne(Filters.eq("_id", id), Objects.requireNonNull(objectToDocument(item)));
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
