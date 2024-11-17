package org.gscavo.veterinaryclinic.model.abstractions;

import org.bson.types.ObjectId;

public interface BaseModel<T> extends RandomizedAttributes<T> {
    public ObjectId getId();
}
