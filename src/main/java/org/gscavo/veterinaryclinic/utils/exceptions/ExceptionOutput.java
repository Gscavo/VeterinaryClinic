package org.gscavo.veterinaryclinic.utils.exceptions;

public class ExceptionOutput {

    public static void showExceptionErr(Exception e) {
        System.err.println("!ERROR!");
        System.err.println("Message: " + e.getLocalizedMessage());
        System.err.println("Cause: " + e.getCause().getMessage());


        System.err.println("Where: " + e.getStackTrace()[0].getClassName() + "." + e.getStackTrace()[0].getMethodName() + "." + e.getStackTrace()[0].getLineNumber());
        for (StackTraceElement ste : e.getStackTrace()) {
            System.err.println( ste.getClassName() + "." + ste.getMethodName() + "." + ste.getLineNumber());

        }
    }
}
