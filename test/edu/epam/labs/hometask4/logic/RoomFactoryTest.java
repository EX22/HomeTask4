package edu.epam.labs.hometask4.logic;

import edu.epam.labs.hometask4.entity.AgeGroup;
import edu.epam.labs.hometask4.entity.Room;
import edu.epam.labs.hometask4.entity.RoomConfig;
import edu.epam.labs.hometask4.entity.Toy;
import edu.epam.labs.hometask4.exception.DataReaderException;
import edu.epam.labs.hometask4.exception.RoomConfigException;
import edu.epam.labs.hometask4.exception.RoomFactoryException;
import edu.epam.labs.hometask4.exception.ToyCreationException;
import edu.epam.labs.hometask4.reader.DataReader;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.*;

public class RoomFactoryTest {

    public static final String FILE_PATH = "/CreatingGameRoomInfo.txt";

    @Test
    public void testCreateRoom() throws DataReaderException, ToyCreationException,
            RoomFactoryException, RoomConfigException {
        DataReader dataReader = new DataReader();
        InputStream inputStream = DataReader.class.getResourceAsStream(FILE_PATH);
        ArrayList<String> list = dataReader.read(inputStream);
        ToyFactory toyFactory = new ToyFactory();
        ArrayList<Toy> toysInStock = toyFactory.createToysList(list);

        RoomFactory roomFactory = new RoomFactory(toysInStock);
        Set<AgeGroup> ageGroups = new HashSet<>();
        ageGroups.add(AgeGroup.SECOND);
        ageGroups.add(AgeGroup.THIRD);
        RoomConfig roomConfig = new RoomConfig(ageGroups, 357.7);
        Room room = roomFactory.createRoom(roomConfig);
        ArrayList<Toy> testToys = room.getToyArrayList();
        double budgetTest = 0;
        for (Toy t : testToys) {
            budgetTest += t.getPrice();
        }
        assertTrue(roomConfig.getCommonBudget() > budgetTest);
        for (Toy t : testToys) {
            assertTrue(t.getAgeGroup().equals(AgeGroup.THIRD) || t.getAgeGroup().equals(AgeGroup.SECOND));
        }


    }
}