package org.gscavo.veterinaryclinic.utils;

import org.gscavo.veterinaryclinic.controller.UserController;
import org.gscavo.veterinaryclinic.model.abstractions.Person;

import java.util.function.Function;

import static org.gscavo.veterinaryclinic.controller.UserController.isUserLoggedIn;

public class UserUtils {
//    public static boolean canUserDoAction(Function<Person, Boolean> fn) {
//            Person person = UserController.getCurrentUser();
//            return isUserLoggedIn() && fn.apply(person);
//        }

    public static boolean canUserDoAction(Function<Person, Boolean> fn) {
        return true;
    }

}
