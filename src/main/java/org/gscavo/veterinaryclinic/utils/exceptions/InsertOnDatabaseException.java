package org.gscavo.veterinaryclinic.utils.exceptions;

public class InsertOnDatabaseException extends RuntimeException {
    public InsertOnDatabaseException(String message) {
        super(message);
    }

    public InsertOnDatabaseException(Exception e) { super(e); }
}
