package com.unicamp.mc322.lab12.game.elements.exception;

public class LabyrinthSizeException extends IllegalArgumentException {

    public LabyrinthSizeException() {
        super();
    }

    public LabyrinthSizeException(String message) {
        super(message);
    }

    public LabyrinthSizeException(Throwable cause) {
        super(cause);
    }

    public LabyrinthSizeException(String message, Throwable cause) {
        super(message, cause);
    }

}
