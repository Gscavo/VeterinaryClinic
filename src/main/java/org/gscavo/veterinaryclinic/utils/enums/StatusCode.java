package org.gscavo.veterinaryclinic.utils.enums;

import lombok.Getter;

@Getter
public enum StatusCode {
    SUCCESS(Status.SUCCESS, true),
    FAILED(Status.ERROR, false);

    private final Status status;

    private final boolean isSuccess;

    StatusCode(Status status, boolean isSuccess) {
        this.status = status;
        this.isSuccess = isSuccess;
    }

    private enum Status {
        SUCCESS,
        ERROR
    }
}
