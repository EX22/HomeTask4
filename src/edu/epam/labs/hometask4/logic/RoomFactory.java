package edu.epam.labs.hometask4.logic;

import edu.epam.labs.hometask4.entity.Room;
import edu.epam.labs.hometask4.entity.RoomConfig;
import edu.epam.labs.hometask4.entity.Toy;
import edu.epam.labs.hometask4.exception.RoomConfigException;
import edu.epam.labs.hometask4.exception.RoomFactoryException;
import edu.epam.labs.hometask4.exception.RoomServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

/**
 * Game room's creation.
 */
public class RoomFactory {

    private static final Logger logger = LogManager.getLogger(RoomFactory.class);

    private ArrayList<Toy> toysInStock;

    public RoomFactory(ArrayList<Toy> toysInStock) {

        this.toysInStock = toysInStock;
    }

    public ArrayList<Toy> getToysInStock() {
        return toysInStock;
    }


    /**
     * Creates game room with toys.
     *
     * @param roomConfig contains such parameters for game room's creation as age groups and common budget
     * @return game room's object with list of toys
     * @throws RoomConfigException  - in case if room configuration's parameters are not valid for room creation.
     * @throws RoomServiceException - in case if there are no budget or toys in stock.
     */
    public Room createRoom(RoomConfig roomConfig) throws RoomConfigException, RoomServiceException {
        if (toysInStock == null) {
            String message = " toysInStock is null.";
            logger.warn(message);
            throw new RoomConfigException(message);
        }
        if (toysInStock.size() == 0) {

            logger.warn(" There are no toys in stock. ");
        }

        //1. Get list of toys in stock(defined in constructor)
        //2. Generate list of toys
        RoomService roomService = new RoomService();
        ArrayList<Toy> createdToys = roomService.generateToys(roomConfig, toysInStock);
        //3. Instantiate room object
        return new Room(roomConfig, createdToys);
    }
}
