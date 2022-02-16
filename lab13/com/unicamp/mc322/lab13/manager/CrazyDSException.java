package com.unicamp.mc322.lab13.manager;

public class CrazyDSException extends IllegalArgumentException {

    public CrazyDSException() {
        super();
    }

    public CrazyDSException(String message) {
        super(message);
    }

    public CrazyDSException(Throwable cause) {
        super(cause);
    }

    public CrazyDSException(String message, Throwable cause) {
        super(message, cause);
    }

}
