package edu.epam.labs.hometask4.exception;

/**
 * Exception thrown in case if there are no toys in stock.
 */
public class RoomFactoryException extends Exception {

    /**
     * @param message passed to parent constructor.
     */
    public RoomFactoryException(String message) {
        super(message);
    }

}
