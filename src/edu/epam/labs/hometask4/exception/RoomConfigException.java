package edu.epam.labs.hometask4.exception;

/**
 * Exception thrown in case if room's configuration parameters are not valid for room creation.
 */
public class RoomConfigException extends Exception {

    /**
     * @param message passed to parent constructor.
     */
    public RoomConfigException(String message) {
        super(message);
    }

}
