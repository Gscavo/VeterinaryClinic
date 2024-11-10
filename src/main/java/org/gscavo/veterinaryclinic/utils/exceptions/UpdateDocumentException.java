package org.gscavo.veterinaryclinic.utils.exceptions;

public class UpdateDocumentException extends RuntimeException {
    public UpdateDocumentException(String message) {
        super(message);
    }

    public UpdateDocumentException(Exception e) { super(e); }
}
