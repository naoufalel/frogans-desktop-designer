package com.frogans.designer.model;

/**
 * Created by naouf on 5/15/2016.
 */
public class ToolException extends Exception {
    private static final long serialVersionUID = 1L;

    public ToolException() {
    }

    public ToolException(String message) {
        super(message);
    }

    public ToolException(Throwable cause) {
        super(cause);
    }

    public ToolException(String message, Throwable cause) {
        super(message, cause);
    }

    public ToolException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        /* in order to ensure Java 1.6 compatibility, super(message, cause, enableSuppression, writableStackTrace) has been replaced by super() */
        super();
    }
}
