package edu.epam.labs.hometask4.exception;

/**
 * Exception thrown in case if there are no budget or toys in stock.
 */
public class RoomServiceException extends Exception {

    /**
     * @param message passed to parent constructor.
     */
    public RoomServiceException(String message) {
        super(message);
    }

    /**
     * @param message passed to parent constructor.
     * @param cause   passed to parent constructor.
     */
    public RoomServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
