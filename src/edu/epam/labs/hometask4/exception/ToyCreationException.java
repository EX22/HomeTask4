package edu.epam.labs.hometask4.exception;

public class ToyCreationException extends Exception {

    public ToyCreationException(String message){
        super(message);
    }

    public ToyCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
