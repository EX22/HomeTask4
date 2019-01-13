package edu.epam.labs.hometask4.logic;

//Creating game rooms.

import edu.epam.labs.hometask4.entity.Room;
import edu.epam.labs.hometask4.entity.RoomConfig;
import edu.epam.labs.hometask4.entity.Toy;

import java.util.ArrayList;

public class RoomFactory {

    private ArrayList<Toy> toysInStock;

    public RoomFactory(ArrayList<Toy> toysInStock) {
        this.toysInStock = toysInStock;
    }

    public ArrayList<Toy> getToysInStock() {
        return toysInStock;
    }

    public void setToysInStock(ArrayList<Toy> toysInStock) {
        this.toysInStock = toysInStock;
    }


    public Room createRoom(RoomConfig roomConfig) {
        //1. Get list of toys in stock
        //2. Generate list of toys
        RoomService roomService = new RoomService();
        ArrayList<Toy> createdToys = roomService.generateToys(roomConfig.getAgeGroups(),
                roomConfig.getCommonBudget(), toysInStock);
        //3. Instantiate room object
        return new Room(roomConfig, createdToys);
    }
}
