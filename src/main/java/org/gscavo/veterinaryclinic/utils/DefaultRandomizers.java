package org.gscavo.veterinaryclinic.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

import static org.gscavo.veterinaryclinic.model.abstractions.RandomizedAttributes.*;

@SuppressWarnings("deprecation")
public class DefaultRandomizers {
    public static String getRandomString( Integer length) {
        int stringSize = length != null ? length : RANDOM_STRING_LENGTH ;
        return RandomStringUtils.random(stringSize, USE_LETTERS, USE_NUMBERS);
    }

    public static String getRandomNumericalString( Integer length ) {
        int stringSize = length != null ? length : RANDOM_STRING_LENGTH ;
        return RandomStringUtils.random(stringSize, false, true);
    }

    public static Integer getRandomNumber() {
        Random randomizer = new Random();
        return randomizer.nextInt(10000);
    }
}
