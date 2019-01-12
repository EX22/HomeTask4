package edu.epam.labs.hometask4.main;

import edu.epam.labs.hometask4.entity.Toy;
import edu.epam.labs.hometask4.logic.ToyFactory;
import edu.epam.labs.hometask4.reader.DataReader;

import java.io.InputStream;
import java.util.ArrayList;

public class Main {

    public static final String FILE_PATH = "/CreatingGameRoomInfo.txt";

    public static void main(String[] args) {
        try {

            DataReader dataReader = new DataReader();
            InputStream inputStream = Main.class.getResourceAsStream(FILE_PATH);
            ArrayList<String> arrayList = dataReader.read(inputStream);

            for (String s : arrayList) {
                System.out.println(s);
            }

            /*ToyFactory toyFactory = new ToyFactory();
            Toy toy = toyFactory.createToy("doll, white, LARGE, fiRSt, eco-plastic, 44.4, no_Voice, MALE, Ken, 34");
            System.out.println(toy.toString());*/

            /*String toyLine = "Car, red, medium, third, metal, 100, teslaP100D, 1.30";
            String[] props = toyLine.split(",");
            for (String s: props){
                System.out.println(s);
            }*/

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
