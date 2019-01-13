package edu.epam.labs.hometask4.logic;

//Creating game rooms.

import edu.epam.labs.hometask4.entity.Room;
import edu.epam.labs.hometask4.entity.RoomConfig;
import edu.epam.labs.hometask4.entity.Toy;
import edu.epam.labs.hometask4.exception.RoomFactoryException;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class RoomFactory {

    private static final Logger logger = Logger.getLogger(RoomFactory.class);

    private ArrayList<Toy> toysInStock;

    public RoomFactory(ArrayList<Toy> toysInStock) throws RoomFactoryException {
        if (toysInStock.size() == 0) {
            String message = " There are no toys in stock. ";
            logger.warn(message);
            throw new RoomFactoryException(message);
        }
        this.toysInStock = toysInStock;
    }

    public ArrayList<Toy> getToysInStock() {
        return toysInStock;
    }


    public Room createRoom(RoomConfig roomConfig) {

        //1. Get list of toys in stock(defined in constructor)
        //2. Generate list of toys
        RoomService roomService = new RoomService();
        ArrayList<Toy> createdToys = roomService.generateToys(roomConfig, toysInStock);
        //3. Instantiate room object
        return new Room(roomConfig, createdToys);
    }
}
