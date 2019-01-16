package edu.epam.labs.hometask4.logic;

import edu.epam.labs.hometask4.entity.AgeGroup;
import edu.epam.labs.hometask4.entity.Room;
import edu.epam.labs.hometask4.entity.RoomConfig;
import edu.epam.labs.hometask4.entity.Toy;
import edu.epam.labs.hometask4.exception.*;
import edu.epam.labs.hometask4.reader.DataReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.*;

public class RoomFactoryTest {

    private static final Logger logger = LogManager.getLogger(RoomFactoryTest.class);

    public static final String FILE_PATH = "/CreatingGameRoomInfo.txt";

    @Test
    public void testCreateRoom() throws DataReaderException, RoomServiceException,
            RoomFactoryException, RoomConfigException {
        logger.debug("Test started: ");
        DataReader dataReader = new DataReader();
        InputStream inputStream = DataReader.class.getResourceAsStream(FILE_PATH);
        ArrayList<String> list = dataReader.read(inputStream);
        ToyFactory toyFactory = new ToyFactory();
        ArrayList<Toy> toysInStock = toyFactory.createToysList(list);
        logger.debug("Loaded toys in stock in amount of: " + toysInStock.size() + "\n" + toysInStock);
        RoomFactory roomFactory = new RoomFactory(toysInStock);
        Set<AgeGroup> ageGroups = new HashSet<>();
        ageGroups.add(AgeGroup.SECOND);
        ageGroups.add(AgeGroup.THIRD);
        RoomConfig roomConfig = new RoomConfig(ageGroups, 357.7);
        logger.debug("Creating room with config: " + roomConfig);
        Room room = roomFactory.createRoom(roomConfig);
        ArrayList<Toy> testToys = room.getToyArrayList();
        logger.debug("Room was created with amount of toys: " + testToys.size() + "\n" + testToys);
        double budgetTest = 0;
        for (Toy t : testToys) {
            budgetTest += t.getPrice();
        }
        logger.debug("Generated room budget: " + budgetTest);
        assertTrue(roomConfig.getCommonBudget() > budgetTest);
        for (Toy t : testToys) {
            assertTrue(t.getAgeGroup().equals(AgeGroup.THIRD) || t.getAgeGroup().equals(AgeGroup.SECOND));
        }
        logger.debug("Game room was successfully created.");


    }
}