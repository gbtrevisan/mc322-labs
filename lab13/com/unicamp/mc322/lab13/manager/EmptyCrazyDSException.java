package com.unicamp.mc322.lab13.manager;

public class EmptyCrazyDSException extends Exception {

    public EmptyCrazyDSException() {
        super();
    }

    public EmptyCrazyDSException(String message) {
        super(message);
    }

    public EmptyCrazyDSException(Throwable cause) {
        super(cause);
    }

    public EmptyCrazyDSException(String message, Throwable cause) {
        super(message, cause);
    }

}
