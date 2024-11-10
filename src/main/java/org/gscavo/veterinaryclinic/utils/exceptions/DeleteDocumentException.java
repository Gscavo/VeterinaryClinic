package org.gscavo.veterinaryclinic.utils.exceptions;

public class DeleteDocumentException extends RuntimeException {
    public DeleteDocumentException(String message) {
        super(message);
    }

    public DeleteDocumentException(Exception e) { super(e); }
}
