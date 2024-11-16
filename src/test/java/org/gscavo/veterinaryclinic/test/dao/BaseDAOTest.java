package org.gscavo.veterinaryclinic.test.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertManyResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.dao.*;
import org.gscavo.veterinaryclinic.model.abstractions.BaseModel;
import org.gscavo.veterinaryclinic.utils.connection.MongoDBConnection;
import org.gscavo.veterinaryclinic.utils.exceptions.DeleteDocumentException;
import org.gscavo.veterinaryclinic.utils.exceptions.InsertOnDatabaseException;
import org.gscavo.veterinaryclinic.utils.exceptions.UpdateDocumentException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.*;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;

public class BaseDAOTest {

    private static ArrayList<? extends BaseDAO<?>> daos;

    @BeforeAll
    public static void setUpClass() {
        MongoDBConnection.startConnection(true);

        daos = new ArrayList<>(
                Arrays.asList(
                    new AddressDAO(),
                    new AdminDAO(),
                    new AnimalDAO(),
                    new AppointmentDAO(),
                    new CalendarDateDAO(),
                    new ClientDAO(),
                    new ProcedureDAO(),
                    new SecretaryDAO(),
                    new SpeciesDAO(),
                    new SymptomDAO(),
                    new VeterinarianDAO()
        ));
    }

    @ParameterizedTest
    @MethodSource("provideDAOs")
    public void fillDatabaseWithInsertOneTest(BaseDAO<Object> dao) {
        Object obj = dao.getFullFilledObject();

        InsertOneResult insertionResult = dao.insertOne(obj);

        ObjectId objIdInDatabase = Objects.requireNonNull(insertionResult.getInsertedId()).asObjectId().getValue();

        Object objectInDatabase = dao.findById(objIdInDatabase);

        Assertions.assertTrue(insertionResult.wasAcknowledged());
        Assertions.assertNotNull(objectInDatabase);
        Assertions.assertNotNull(objectInDatabase);

        System.out.printf("Successfully inserted one object in %s collection\n\n ", dao.getCollectionName());

    }

    @ParameterizedTest
    @MethodSource("provideDAOs")
    public void fillDatabaseWithInsertManyTest(BaseDAO<Object> dao) {
        List<Object> listObject = Arrays.asList(
          dao.getFullFilledObject(),
          dao.getFullFilledObject(),
          dao.getFullFilledObject()
        );

        InsertManyResult insertionResult = dao.insertMany(listObject);

        Assertions.assertTrue(insertionResult.wasAcknowledged());
        Assertions.assertNotNull(insertionResult.getInsertedIds());
        Assertions.assertEquals(listObject.size(), insertionResult.getInsertedIds().size());

        System.out.printf("Successfully inserted many objects in %s collection\n\n ", dao.getCollectionName());
    }

    @ParameterizedTest
    @MethodSource("provideDAOs")
    public void insertionsExceptionTest(BaseDAO<Object> dao) {
        MongoCollection<?> mockCollection = Mockito.mock();

        doThrow(InsertOnDatabaseException.class).when(mockCollection).insertOne(any());
        doThrow(InsertOnDatabaseException.class).when(mockCollection).insertMany(any());

        Assertions.assertThrows(InsertOnDatabaseException.class, () -> mockCollection.insertOne(any()));
        Assertions.assertThrows(InsertOnDatabaseException.class, () -> mockCollection.insertMany(any()));

        System.out.printf("Successfully threw Exception on insertion of data in %s collection\n\n ", dao.getCollectionName());
    }

    @ParameterizedTest
    @MethodSource("provideDAOs")
    public void updateByIdTest(BaseDAO<BaseModel<?>> dao) throws IllegalAccessException {
        BaseModel<?> filledObject = dao.getFullFilledObject();

        Object randomizedObject = filledObject.randomizeAttributes();

        InsertOneResult insertionResult = dao.insertOne(filledObject);

        UpdateResult updateResult = dao.updateById(
                Objects.requireNonNull(insertionResult.getInsertedId()).asObjectId().getValue(),
                (BaseModel<?>) randomizedObject
            );

        Assertions.assertTrue(updateResult.wasAcknowledged());
        Assertions.assertEquals(1, updateResult.getModifiedCount());

        System.out.printf("Successfully updated data in %s collection\n\n ", dao.getCollectionName());
    }

    @ParameterizedTest
    @MethodSource("provideDAOs")
    public void updateByIdExceptionTest(BaseDAO<Object> dao) throws IllegalAccessException {
        BaseDAO<Object> mockDao = Mockito.mock();
        Object filledObject = dao.getFullFilledObject();

        doThrow(UpdateDocumentException.class).when(mockDao).updateById(any(), any());

        Assertions.assertThrows(UpdateDocumentException.class, () -> mockDao.updateById(new ObjectId(), filledObject));

        System.out.printf("Successfully threw Exception on update of data in %s collection\n\n ", dao.getCollectionName());
    }

    @ParameterizedTest
    @MethodSource("provideDAOs")
    public void deleteByIdTest(BaseDAO<BaseModel<?>> dao) throws IllegalAccessException {
        InsertManyResult insertionResult = dao.insertMany(
                Arrays.asList(
                    dao.getFullFilledObject(),
                    dao.getFullFilledObject()
        ));

        DeleteResult deleteWithObjectIdResult = dao.deleteById(
                Objects.requireNonNull(insertionResult.getInsertedIds().get(0)).asObjectId().getValue()
        );

        DeleteResult deleteWithStringResult = dao.deleteById(
                Objects.requireNonNull(insertionResult.getInsertedIds().get(1)).asObjectId().getValue().toString()
        );


        Assertions.assertTrue(deleteWithObjectIdResult.wasAcknowledged());
        Assertions.assertEquals(1, deleteWithObjectIdResult.getDeletedCount());

        Assertions.assertTrue(deleteWithStringResult.wasAcknowledged());
        Assertions.assertEquals(1, deleteWithStringResult.getDeletedCount());

        System.out.printf("Successfully deleted data in %s collection\n\n ", dao.getCollectionName());
    }

    @ParameterizedTest
    @MethodSource("provideDAOs")
    public void deleteByIdExceptionTest(BaseDAO<Object> dao) throws IllegalAccessException {
        BaseDAO<Object> mockDao = Mockito.mock();
        Object filledObject = dao.getFullFilledObject();

        doThrow(DeleteDocumentException.class).when(mockDao).updateById(any(), any());

        Assertions.assertThrows(DeleteDocumentException.class, () -> mockDao.updateById(new ObjectId(), filledObject));

        System.out.printf("Successfully threw Exception on update of data in %s collection\n\n ", dao.getCollectionName());
    }

    private static Stream<?> provideDAOs() {
        return daos.stream();
    }

}
