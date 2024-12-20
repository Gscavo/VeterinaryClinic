package org.gscavo.veterinaryclinic.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ObjectUtils {
    public static <T> ArrayList<Field> getAllFieldsFromClass(Class<T> classType) {
        Set<Field> fields = new HashSet<>();
        Class<?> currentClass = classType;
        while (currentClass != null && currentClass != Object.class) {
            Field[] currentClassFields = currentClass.getDeclaredFields();

            for (Field field : currentClassFields) {
                field.setAccessible(true);

                fields.add(field);
            }

            currentClass = currentClass.getSuperclass();
        }
        return new ArrayList<>(fields);
    }
    
    public static <T> void updateAttribute(T object, T value) {
        if (object != null && value != null) {
            object = value;
        }
    }
}
