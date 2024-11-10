package org.gscavo.veterinaryclinic.utils.information;

import lombok.Getter;
import org.gscavo.veterinaryclinic.utils.enums.StatusCode;

@Getter
public class SystemOperationResult {

    private final StatusCode status;
    private final String message;

    public SystemOperationResult(StatusCode status, String message) {
        this.status = status;
        this.message = message;
    }

    public SystemOperationResult(StatusCode status) {
        this.status = status;
        this.message = null;
    }

    public static SystemOperationResult notAuthenticatedOrAllowedActionSOR() {
        return new SystemOperationResult(StatusCode.FAILED, "User is not logged in or cannot to this action");
    }

    public static SystemOperationResult failedToInsertResourceSOR(Class<?> type) {
        String resourceType = type.getSimpleName();
        return new SystemOperationResult(StatusCode.FAILED, "Error while registering new " + resourceType);
    }

    public static SystemOperationResult failedToUpdateResourceSOR(Class<?> type) {
        String resourceType = type.getSimpleName();
        return new SystemOperationResult(StatusCode.FAILED, "Error while updating object from collection: " + resourceType);
    }

    public static SystemOperationResult objectNotFound() {
        return new SystemOperationResult(StatusCode.FAILED, "Object not found");
    }
}
