package edu.epam.labs.hometask4.reader;

import edu.epam.labs.hometask4.exception.DataReaderException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.*;
import java.util.ArrayList;


public class DataReader {

    private static final Logger logger = LogManager.getLogger(DataReader.class);

    public ArrayList<String> read(InputStream inputStream) throws DataReaderException {

        ArrayList<String> arrayList = new ArrayList<>();
        BufferedReader fileReader = null;
        try {
            if (inputStream == null) {
                String message = "Input stream is null.";
                logger.error(message);
                throw new DataReaderException(message);
            }
            fileReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = fileReader.readLine()) != null) {
                arrayList.add(line);
            }

        } catch (FileNotFoundException e) {
            String message = "The source for list is not found! ";
            logger.error(message, e);
            throw new DataReaderException(message, e);
        } catch (IOException e) {
            String message = "During the source for list reading an exception occurred";
            logger.error(message, e);
            throw new DataReaderException(message, e);
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                String message = "During closing the stream an exception occurred";
                logger.warn(message);
            }
        }
        return arrayList;
    }

}
