package edu.epam.labs.hometask4.reader;

import edu.epam.labs.hometask4.exception.DataReaderException;

import java.io.*;
import java.util.ArrayList;

public class DataReader {

    public ArrayList<String> read(InputStream inputStream) throws DataReaderException {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            if (inputStream == null) {
                throw new DataReaderException("Input stream is null.");
            }
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = fileReader.readLine()) != null) {
                arrayList.add(line);
            }
            fileReader.close();


        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("During the source for array reading an exception occurred");
        }
        return arrayList;
    }

}
