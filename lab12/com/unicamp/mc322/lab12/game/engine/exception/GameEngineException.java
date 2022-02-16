package com.unicamp.mc322.lab12.game.engine.exception;

public class GameEngineException extends RuntimeException {

    public GameEngineException() {
        super();
    }

    public GameEngineException(String message) {
        super(message);
    }

    public GameEngineException(Throwable cause) {
        super(cause);
    }

    public GameEngineException(String message, Throwable cause) {
        super(message, cause);
    }

}
