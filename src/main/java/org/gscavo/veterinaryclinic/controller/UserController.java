package org.gscavo.veterinaryclinic.controller;

import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;

import lombok.Getter;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.controller.abstractions.BaseController;
import org.gscavo.veterinaryclinic.dao.*;
import org.gscavo.veterinaryclinic.model.*;
import org.gscavo.veterinaryclinic.model.abstractions.Person;
import org.gscavo.veterinaryclinic.utils.ConversionUtils;
import org.gscavo.veterinaryclinic.utils.StringUtils;
import org.gscavo.veterinaryclinic.utils.enums.Controllers;
import org.gscavo.veterinaryclinic.utils.information.SystemOperationResult;
import org.gscavo.veterinaryclinic.utils.enums.StatusCode;
import org.gscavo.veterinaryclinic.utils.security.Permissions;

import static org.gscavo.veterinaryclinic.utils.UserUtils.canUserDoAction;
import static org.gscavo.veterinaryclinic.utils.information.SystemOperationResult.*;

public class UserController extends BaseController<User>  {
    @Getter
    private static final UsersDAO USERS_DAO = DAOController.getDaoByClass(User.class);

    @Getter
    private static final ClientDAO CLIENT_DAO = DAOController.getDaoByClass(Client.class);

    @Getter
    private static final VeterinarianDAO VETERINARIAN_DAO = DAOController.getDaoByClass(Veterinarian.class);

    @Getter
    private static final SecretaryDAO SECRETARY_DAO = DAOController.getDaoByClass(Secretary.class);

    @Getter
    private static final AdminDAO ADMIN_DAO = DAOController.getDaoByClass(Admin.class);

    @Getter
    private static Person currentUser = null;

    @Getter
    private static Client currentClient = null;

    public UserController() {
        super(User.class);
    }
    
    @Override
    public SystemOperationResult<?> register(User person) {
        InsertOneResult result = getDAOByUseCase(person).insertOne(person);

        if (result == null || !result.wasAcknowledged() || result.getInsertedId() == null) {
            return failedToInsertResourceSOR(Person.class);
        }

        return new SystemOperationResult<>(
                StatusCode.SUCCESS,
                ConversionUtils.bsonValueToObjectId(result.getInsertedId())
        );
    }
    
    public static SystemOperationResult login(String email, String password) {
        if (StringUtils.isEmpty(email) || StringUtils.isEmpty(password)) {
            return new SystemOperationResult(StatusCode.FAILED, "Either email or password is empty.");
        }

        Person user = USERS_DAO.findByEmailAndPassword(email, password);

        if (user == null) {
            return new SystemOperationResult(StatusCode.FAILED, "User not found.");
        }

        currentUser = user;

        return new SystemOperationResult(StatusCode.SUCCESS);
    }

    public static <T extends Person> SystemOperationResult registerEmployee(T employee) {
        if (!canUserDoAction(Permissions::canRegisterEmployees)) {
            return notAuthenticatedOrAllowedActionSOR();
        }

        InsertOneResult result = switch (employee.getType()) {
            case VETERINARIAN -> VETERINARIAN_DAO.insertOne((Veterinarian) employee);
            case SECRETARY -> SECRETARY_DAO.insertOne((Secretary) employee);
            default -> null;
        };

        if (result == null || !result.wasAcknowledged() ) {
            return failedToInsertResourceSOR(employee.getClass());
        }

        return new SystemOperationResult(StatusCode.SUCCESS);
    }

    public static SystemOperationResult registerClient(Client client) {

        if (!canUserDoAction(Permissions::canRegister)) {
            return notAuthenticatedOrAllowedActionSOR();
        }

        InsertOneResult result = CLIENT_DAO.insertOne(client);

        if (result == null || !result.wasAcknowledged() ) {
            return failedToInsertResourceSOR(Client.class);
        }

        currentClient = client;

        return new SystemOperationResult(StatusCode.SUCCESS);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Person> SystemOperationResult<ObjectId> updateUser(T person) {
        if (!canUserDoAction(Permissions::any)) {
            return notAuthenticatedOrAllowedActionSOR();
        }

        UpdateResult result = null;

        try {
            result = getDAOByUseCase(person).updateById(person.getId(), person);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        if (result == null || !result.wasAcknowledged()) {
            return failedToUpdateResourceSOR(person.getClass());
        }

        return new SystemOperationResult<ObjectId>(StatusCode.SUCCESS, person.getId());
    }

    @SuppressWarnings("rawtypes")
    private static PersonDAO getDAOByUseCase(Person person) {
        return switch (person.getType()) {
            case ADMIN -> ADMIN_DAO;
            case SECRETARY -> SECRETARY_DAO;
            case VETERINARIAN -> VETERINARIAN_DAO;
            case CLIENT -> CLIENT_DAO;
            default -> throw new NullPointerException("No personType specified!");
        };
    }

    public static boolean isUserLoggedIn() {
        return currentUser != null;
    }

    
    public static <T extends Person> T getUser(ObjectId clientId) {
        return (T) USERS_DAO.findById(clientId);
    }

    public static Client getClient(ObjectId id) {
        return CLIENT_DAO.findById(id);
    }
    
    public static ArrayList<Client> getAllClients() {
        return CLIENT_DAO.findAll();
    }

    public static <T extends Person> SystemOperationResult appendAppointmentToUser(ObjectId appointmentId, ObjectId userId) {
        T databaseUser = UserController.getUser(userId);

        if (databaseUser == null) {
            return SystemOperationResult.objectNotFound();
        }

         switch (databaseUser.getType()) {
             case VETERINARIAN:
                 ((Veterinarian) databaseUser).getAppointmentList().add(appointmentId);
                 break;
            default:
                 return SystemOperationResult.objectNotFound();
        }

        return updateUser(databaseUser);
    }
}