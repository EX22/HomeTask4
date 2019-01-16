package edu.epam.labs.hometask4.exception;

/**
 * Exception thrown during the file reading.
 */
public class DataReaderException extends Exception {

    /**
     * @param message passed to parent constructor.
     */
    public DataReaderException(String message) {
        super(message);
    }

    /**
     * @param message passed to parent constructor.
     * @param cause   passed to parent constructor.
     */
    public DataReaderException(String message, Throwable cause) {
        super(message, cause);
    }
}
