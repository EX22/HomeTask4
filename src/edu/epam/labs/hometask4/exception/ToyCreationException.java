package edu.epam.labs.hometask4.exception;

/**
 * Exception thrown in case of invalid parameters for toy's creation.
 */
public class ToyCreationException extends Exception {

    /**
     * @param message passed to parent constructor.
     */
    public ToyCreationException(String message) {
        super(message);
    }

    /**
     * @param message passed to parent constructor.
     * @param cause   passed to parent constructor.
     */
    public ToyCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
