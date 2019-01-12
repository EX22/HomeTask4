package edu.epam.labs.hometask4.reader;

import edu.epam.labs.hometask4.exception.DataReaderException;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.ArrayList;

import static org.testng.Assert.*;

public class DataReaderTest {

    public static final String FILE_PATH = "/CreatingGameRoomInfo.txt";
    public static final String WRONG_FILE_PATH = "/NonExistingFile.txt";

    @Test
    public void testRead() throws DataReaderException {

        DataReader dataReader = new DataReader();
        InputStream inputStream = DataReaderTest.class.getResourceAsStream(FILE_PATH);
        String expectedLine = "cUBE, GREEN, Large, third, rubber, 79.9, 50, 50, 50, 1.5, 350";
        ArrayList<String> actualList = dataReader.read(inputStream);
        assertEquals(actualList.get(2), expectedLine);

    }

    @Test(expectedExceptions = DataReaderException.class)
    public void testRead1() throws DataReaderException {
        DataReader dataReader = new DataReader();
        InputStream inputStream =DataReaderTest.class.getResourceAsStream(WRONG_FILE_PATH);
        dataReader.read(inputStream);
    }
}