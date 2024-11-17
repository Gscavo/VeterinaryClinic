package org.gscavo.veterinaryclinic.utils.information;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.gscavo.veterinaryclinic.utils.enums.StatusCode;

@Getter
@AllArgsConstructor
public class SystemOperationResult<T> {

    private final StatusCode status;
    private final String message;
    private final T value;

    public String getMessage() {
        if (this.message == null) {
            return "" + status.getStatus();
        }
        
        return this.message;
    }
    
    public SystemOperationResult(StatusCode status, String message) {
        this.status = status;
        this.message = message;
        this.value = null;
    }

    public SystemOperationResult(StatusCode status) {
        this.status = status;
        this.message = null;
        this.value = null;
    }
    
    public SystemOperationResult(StatusCode status, T value) {
        this.status = status;
        this.message = null;
        this.value = value;
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

    public Boolean isSuccess() {
        return status.isSuccess();
    }
}
