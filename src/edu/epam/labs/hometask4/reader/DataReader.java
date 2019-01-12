package edu.epam.labs.hometask4.reader;

import edu.epam.labs.hometask4.exception.DataReaderException;
import org.apache.log4j.Logger;


import java.io.*;
import java.util.ArrayList;


public class DataReader {

    public static final Logger logger = Logger.getLogger(DataReader.class);

    public ArrayList<String> read(InputStream inputStream) throws DataReaderException {

        ArrayList<String> arrayList = new ArrayList<>();
        BufferedReader fileReader = null;
        try {
            if (inputStream == null) {
                throw new DataReaderException("Input stream is null.");
            }
            fileReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = fileReader.readLine()) != null) {
                arrayList.add(line);
            }

        } catch (FileNotFoundException e) {
            logger.warn("The source for list is not found! ", e);
        } catch (IOException e) {
            logger.warn("During the source for list reading an exception occurred", e);
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                logger.warn("During closing the stream an exception occurred", e);
            }
        }
        return arrayList;
    }

}
