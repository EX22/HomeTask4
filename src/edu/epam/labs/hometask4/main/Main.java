package edu.epam.labs.hometask4.main;

import edu.epam.labs.hometask4.comparator.ToyByAgeGroup;
import edu.epam.labs.hometask4.comparator.ToyByPrice;
import edu.epam.labs.hometask4.entity.*;
import edu.epam.labs.hometask4.logic.RoomFactory;
import edu.epam.labs.hometask4.logic.RoomService;
import edu.epam.labs.hometask4.logic.ToyFactory;
import edu.epam.labs.hometask4.reader.DataReader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static final String FILE_PATH = "/CreatingGameRoomInfo.txt";
    public static final String NON_EXISTING_FILE = "/NonExistingFile";
    public static final String EMPTY_FILE = "/TestGameRoomInfo.txt";
    public static final String MIXED_DATA_FILE = "/IncomingDataPattern.txt";

    public static void main(String[] args) {
        try {

            //Data reader test test
            /*DataReader dataReader = new DataReader();
            InputStream inputStream = Main.class.getResourceAsStream(EMPTY_FILE);
            ArrayList<String> arrayList = dataReader.read(inputStream);

            for (String s : arrayList) {
                System.out.println(s);
            }*/

            //Room factory test test
            DataReader dataReader = new DataReader();
            InputStream inputStream = DataReader.class.getResourceAsStream(EMPTY_FILE);
            ArrayList<String> list = dataReader.read(inputStream);
            ToyFactory toyFactory = new ToyFactory();
            ArrayList<Toy> toysInStock = new ArrayList<>();
            for (String s : list) {
                toysInStock.addAll(toyFactory.createToy(s));
            }
            for (Toy t: toysInStock) {
                System.out.println(t);
            }
            System.out.println(toysInStock.size());

            RoomFactory roomFactory = new RoomFactory(toysInStock);
            Set<AgeGroup> ageGroups = new HashSet<>();
            ageGroups.add(AgeGroup.THIRD);
            ageGroups.add(AgeGroup.SECOND);
            //ageGroups.add(AgeGroup.FIRST);
            RoomConfig roomConfig = new RoomConfig(ageGroups, 345.6);
            Room room = roomFactory.createRoom(roomConfig);
            ArrayList<Toy> testToys = room.getToyArrayList();
            double budgetTest = 0;
            for (Toy t : testToys) {
                budgetTest += t.getPrice();
            }
            System.out.println(budgetTest);
            for (Toy t : testToys) {
                System.out.println(t);
            }
            for (Toy t : testToys) {
                if (t.getAgeGroup().equals(AgeGroup.THIRD) || t.getAgeGroup().equals(AgeGroup.SECOND)) {
                    System.out.println("match");
                }
            }


            /*ArrayList<Toy > testToys = new ArrayList<>();

            testToys.add(new Ball("blue", ToySize.MEDIUM, AgeGroup.THIRD,
                    "plastic", 21.4, 12.3, 0.9));
            testToys.add(new Car("red", ToySize.MEDIUM, AgeGroup.THIRD,
                    "metal", 103, "teslaP100D", 1.30));
            testToys.add(new Cube("GREEN", ToySize.LARGE, AgeGroup.FIRST,
                    "rubber", 79.9, 50, 50, 50, 1.5));
            testToys.add(new Car("red", ToySize.MEDIUM, AgeGroup.SECOND,
                    "metal", 103, "teslaP100D", 1.30));
            testToys.add(new Ball("blue", ToySize.MEDIUM, AgeGroup.FIRST,
                    "plastic", 22.5, 12.3, 0.9));
            testToys.add(new Car("red", ToySize.MEDIUM, AgeGroup.FIRST,
                    "metal", 101, "teslaP100D", 1.30));
            testToys.add(new Cube("GREEN", ToySize.LARGE, AgeGroup.THIRD,
                    "rubber", 79.999, 50, 50, 50, 1.5));
            testToys.add(new Ball("blue", ToySize.MEDIUM, AgeGroup.SECOND,
                    "plastic", 44.444, 12.3, 0.9));
            testToys.add(new Doll("white", ToySize.LARGE, AgeGroup.FIRST,
                    "eco-plastic", 44.444, DollVoice.NO_VOICE, Gender.MALE, "Ken"));
            testToys.add(new Car("red", ToySize.MEDIUM, AgeGroup.SECOND,
                    "metal", 101, "teslaP100D", 1.30));
            testToys.add(new Ball("blue", ToySize.MEDIUM, AgeGroup.SECOND,
                    "plastic", 21.4, 12.3, 0.9));
            testToys.add(new Doll("white", ToySize.LARGE, AgeGroup.FIRST,
                    "eco-plastic", 44.44, DollVoice.NO_VOICE, Gender.MALE, "Ken"));*/

            /*RoomService roomService = new RoomService();
            ToyByPrice toyByPrice = new ToyByPrice();
            ToyByAgeGroup toyByAgeGroup = new ToyByAgeGroup();
            ArrayList<Toy> sortedToys = roomService.sortToys(testToys, toyByAgeGroup);*/

           /* Set<AgeGroup> ageGroups = new HashSet<>();
            ageGroups.add(AgeGroup.THIRD);
            //ageGroups.add(AgeGroup.SECOND);
            ageGroups.add(AgeGroup.FIRST);

            RoomService roomService = new RoomService();
            ArrayList<Toy> foundToys = roomService.searchToys(testToys, ageGroups);*/
            /*RoomService roomService = new RoomService();
            ArrayList<Toy> sortedToys = roomService.sortToys(testToys, new ToyByPrice().thenComparing(new ToyByAgeGroup()));

            for (Toy t: sortedToys) {
                System.out.println(t);
            }*/

            //Room service generate toys test test
            /*RoomService roomService = new RoomService();
            Set<AgeGroup> ageGroups = new HashSet<>();
            ageGroups.add(AgeGroup.THIRD);
            ageGroups.add(AgeGroup.SECOND);
            ageGroups.add(AgeGroup.FIRST);
            ArrayList<Toy > toysInStock = new ArrayList<>();
            toysInStock.add(new Ball("blue", ToySize.MEDIUM, AgeGroup.SECOND,
                    "plastic", 20.4, 12.3, 0.9));
            toysInStock.add(new Car("red", ToySize.MEDIUM, AgeGroup.THIRD,
                    "metal", 100, "teslaP100D", 1.30));
            toysInStock.add(new Cube("GREEN", ToySize.LARGE, AgeGroup.THIRD,
                    "rubber", 79.9, 50, 50, 50, 1.5));
            toysInStock.add(new Doll("white", ToySize.LARGE, AgeGroup.FIRST,
                    "eco-plastic", 44.4, DollVoice.NO_VOICE, Gender.MALE, "Ken"));
            toysInStock.add(new Ball("blue", ToySize.MEDIUM, AgeGroup.SECOND,
                    "plastic", 20.4, 12.3, 0.9));
            toysInStock.add(new Car("red", ToySize.MEDIUM, AgeGroup.THIRD,
                    "metal", 100, "teslaP100D", 1.30));
            toysInStock.add(new Cube("GREEN", ToySize.LARGE, AgeGroup.THIRD,
                    "rubber", 79.9, 50, 50, 50, 1.5));
            toysInStock.add(new Doll("white", ToySize.LARGE, AgeGroup.FIRST,
                    "eco-plastic", 44.4, DollVoice.NO_VOICE, Gender.MALE, "Ken"));
            toysInStock.add(new Ball("blue", ToySize.MEDIUM, AgeGroup.SECOND,
                    "plastic", 20.4, 12.3, 0.9));
            toysInStock.add(new Car("red", ToySize.MEDIUM, AgeGroup.THIRD,
                    "metal", 100, "teslaP100D", 1.30));
            toysInStock.add(new Cube("GREEN", ToySize.LARGE, AgeGroup.THIRD,
                    "rubber", 79.9, 50, 50, 50, 1.5));
            toysInStock.add(new Doll("white", ToySize.LARGE, AgeGroup.FIRST,
                    "eco-plastic", 44.4, DollVoice.NO_VOICE, Gender.MALE, "Ken"));
            ArrayList<Toy> testToys = roomService.generateToys(ageGroups, 438.5, toysInStock);
            for (Toy t: testToys) {
                System.out.println(t);
            }
            System.out.println(testToys.size());*/


            //Toy factory test test
            /*ToyFactory toyFactory = new ToyFactory();
            ArrayList<Toy> createdToys = toyFactory.createToy("Car, 56, red," +
                    " medium, third, metal, 100, teslaP100D, 1.30");
            System.out.println(createdToys.size());
            for (Toy t : createdToys) {
                System.out.println(t);
            }*/

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
