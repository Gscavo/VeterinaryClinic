package org.gscavo.veterinaryclinic.model.abstractions;

public interface RandomizedAttributes<T> {

    int RANDOM_STRING_LENGTH = 10;

    Boolean USE_LETTERS = true;
    Boolean USE_NUMBERS = false;

    public T randomizeAttributes();
}
