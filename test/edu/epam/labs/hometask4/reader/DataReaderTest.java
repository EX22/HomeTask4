package edu.epam.labs.hometask4.reader;

import edu.epam.labs.hometask4.exception.DataReaderException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.ArrayList;

import static org.testng.Assert.*;

public class DataReaderTest {

    private static final Logger logger = LogManager.getLogger(DataReaderTest.class);

    public static final String FILE_PATH = "/CreatingGameRoomInfo.txt";
    public static final String WRONG_FILE_PATH = "/NonExistingFile.txt";

    @Test
    public void testRead() throws DataReaderException {
        logger.debug("Test started: ");
        DataReader dataReader = new DataReader();
        InputStream inputStream = DataReaderTest.class.getResourceAsStream(FILE_PATH);
        String expectedLine = "cUBE, 5, GREEN, Large, third, rubber, 79.9, 50, 50, 50, 1.5";
        ArrayList<String> actualList = dataReader.read(inputStream);
        assertEquals(actualList.get(2), expectedLine);
        logger.debug("File was successfully read with " + actualList.size() + " lines.");


    }

    @Test(expectedExceptions = DataReaderException.class)
    public void testRead1() throws DataReaderException {
        logger.debug("Test started: ");
        DataReader dataReader = new DataReader();
        InputStream inputStream = DataReaderTest.class.getResourceAsStream(WRONG_FILE_PATH);
        logger.debug("Input stream: " + inputStream);
        dataReader.read(inputStream);

    }


}