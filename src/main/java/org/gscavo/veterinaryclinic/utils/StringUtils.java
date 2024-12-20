package org.gscavo.veterinaryclinic.utils;

import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.abstractions.BaseModel;

public class StringUtils {

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
    
    public static String formatToSelection(Object id, Object str) {
        return id + " " + str;
    }
}
