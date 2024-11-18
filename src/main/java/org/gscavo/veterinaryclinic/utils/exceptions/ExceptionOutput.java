package org.gscavo.veterinaryclinic.utils.exceptions;

public class ExceptionOutput {

    public static void showExceptionErr(Exception e) {
        System.err.println("!ERROR!");
        System.err.println("Message: " + e.getLocalizedMessage());
        System.err.println("Cause: " + e.getCause().getMessage());
        StackTraceElement ste = e.getStackTrace()[0];
        System.err.println("Where: " + ste.getClassName() + "." + ste.getMethodName() + "." + ste.getLineNumber());
    }
}
