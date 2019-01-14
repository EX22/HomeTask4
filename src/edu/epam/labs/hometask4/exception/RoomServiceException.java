package edu.epam.labs.hometask4.exception;

public class RoomServiceException extends Exception {

    public RoomServiceException(String message) {
        super(message);
    }

    public RoomServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
