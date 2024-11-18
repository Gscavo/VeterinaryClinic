package org.gscavo.veterinaryclinic.test.controller;

import com.mongodb.assertions.Assertions;
import org.gscavo.veterinaryclinic.controller.AnimalController;
import org.gscavo.veterinaryclinic.controller.UserController;
import org.gscavo.veterinaryclinic.dao.ClientDAO;
import org.gscavo.veterinaryclinic.model.Animal;
import org.gscavo.veterinaryclinic.model.Client;
import org.gscavo.veterinaryclinic.utils.UserUtils;
import org.gscavo.veterinaryclinic.utils.information.SystemOperationResult;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;

class AnimalControllerTest {

    private static final MockedStatic<UserController> userControllerMocked = Mockito.mockStatic(UserController.class);

    private static final MockedStatic<UserUtils> userUtilsMocked = Mockito.mockStatic(UserUtils.class);

    private final Client CURRENT_CLIENT_TEST = new ClientDAO().getFullFilledObject();

    @BeforeEach
    public void setUp() {
        userUtilsMocked.when(() -> UserUtils.canUserDoAction(any())).thenReturn(true);
        userControllerMocked.when(UserController::getCurrentClient).thenReturn(CURRENT_CLIENT_TEST);
    }

//    @Test
//    public void registerAnimalSuccessTest() {
//        SystemOperationResult operationResult = AnimalController.registerAnimal(new Animal());
//
//        Assertions.assertTrue(operationResult.getStatus().isSuccess());
//    }


}
