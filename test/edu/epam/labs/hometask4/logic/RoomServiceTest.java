package edu.epam.labs.hometask4.logic;

import edu.epam.labs.hometask4.comparator.ToyByAgeGroup;
import edu.epam.labs.hometask4.comparator.ToyByPrice;
import edu.epam.labs.hometask4.entity.*;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.*;

public class RoomServiceTest {

    @Test
    public void testGenerateToys() {
        RoomService roomService = new RoomService();
        Set<AgeGroup> ageGroups = new HashSet<>();
        ageGroups.add(AgeGroup.THIRD);
        ageGroups.add(AgeGroup.SECOND);
        ageGroups.add(AgeGroup.FIRST);
        ArrayList<Toy> toysInStock = new ArrayList<>();

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
        assertFalse(testToys.isEmpty());
        double budgetTest = 0;
        for (Toy t : testToys) {
            budgetTest += t.getPrice();
        }
        assertTrue(438.5 > budgetTest);
        for (Toy t : testToys) {
            assertTrue(t.getAgeGroup().equals(AgeGroup.FIRST) ||
                    t.getAgeGroup().equals(AgeGroup.SECOND) || t.getAgeGroup().equals(AgeGroup.THIRD));
        }
    }

    @Test
    public void testSortToys() {
        ArrayList<Toy> testToys = new ArrayList<>();

        testToys.add(new Ball("blue", ToySize.MEDIUM, AgeGroup.SECOND,
                "plastic", 21.4, 12.3, 0.9));
        testToys.add(new Car("red", ToySize.MEDIUM, AgeGroup.THIRD,
                "metal", 103, "teslaP100D", 1.30));
        testToys.add(new Cube("GREEN", ToySize.LARGE, AgeGroup.THIRD,
                "rubber", 79.9, 50, 50, 50, 1.5));
        testToys.add(new Doll("white", ToySize.LARGE, AgeGroup.FIRST,
                "eco-plastic", 44.4, DollVoice.NO_VOICE, Gender.MALE, "Ken"));
        testToys.add(new Ball("blue", ToySize.MEDIUM, AgeGroup.SECOND,
                "plastic", 22.5, 12.3, 0.9));
        testToys.add(new Car("red", ToySize.MEDIUM, AgeGroup.THIRD,
                "metal", 102, "teslaP100D", 1.30));
        testToys.add(new Cube("GREEN", ToySize.LARGE, AgeGroup.THIRD,
                "rubber", 79.999, 50, 50, 50, 1.5));
        testToys.add(new Doll("white", ToySize.LARGE, AgeGroup.FIRST,
                "eco-plastic", 44.444, DollVoice.NO_VOICE, Gender.MALE, "Ken"));
        testToys.add(new Ball("blue", ToySize.MEDIUM, AgeGroup.SECOND,
                "plastic", 23.6, 12.3, 0.9));
        testToys.add(new Car("red", ToySize.MEDIUM, AgeGroup.THIRD,
                "metal", 101, "teslaP100D", 1.30));
        testToys.add(new Cube("GREEN", ToySize.LARGE, AgeGroup.THIRD,
                "rubber", 79.99, 50, 50, 50, 1.5));
        testToys.add(new Doll("white", ToySize.LARGE, AgeGroup.FIRST,
                "eco-plastic", 44.44, DollVoice.NO_VOICE, Gender.MALE, "Ken"));

        RoomService roomService = new RoomService();
        ArrayList<Toy> sortedToys = roomService.sortToys(testToys, new ToyByPrice());
        for (int i = 0; i < sortedToys.size() - 1; i++) {
            assertTrue(sortedToys.get(i).getPrice() <= sortedToys.get(i + 1).getPrice());
        }
    }

    @Test
    public void testSortToys1() {
        ArrayList<Toy> testToys = new ArrayList<>();

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
        testToys.add(new Ball("blue", ToySize.MEDIUM, AgeGroup.FIRST,
                "plastic", 21.4, 12.3, 0.9));
        testToys.add(new Doll("white", ToySize.LARGE, AgeGroup.FIRST,
                "eco-plastic", 44.444, DollVoice.NO_VOICE, Gender.MALE, "Ken"));
        testToys.add(new Car("red", ToySize.MEDIUM, AgeGroup.SECOND,
                "metal", 101, "teslaP100D", 1.30));
        testToys.add(new Ball("blue", ToySize.MEDIUM, AgeGroup.SECOND,
                "plastic", 21.4, 12.3, 0.9));
        testToys.add(new Doll("white", ToySize.LARGE, AgeGroup.FIRST,
                "eco-plastic", 44.44, DollVoice.NO_VOICE, Gender.MALE, "Ken"));

        RoomService roomService = new RoomService();
        ArrayList<Toy> sortedToys = roomService.sortToys(testToys,
                new ToyByPrice().thenComparing(new ToyByAgeGroup()));
        for (int i = 0; i < sortedToys.size() - 1; i++) {
            assertTrue(sortedToys.get(i).getPrice() <= sortedToys.get(i + 1).getPrice());
            if (sortedToys.get(i).getPrice() == sortedToys.get(i + 1).getPrice()) {
                assertTrue(sortedToys.get(i).getAgeGroup()
                        .ordinal() < sortedToys.get(i + 1)
                        .getAgeGroup().ordinal());

            }
        }


    }

    @Test
    public void testSearchToys() {
        ArrayList<Toy> testToys = new ArrayList<>();

        testToys.add(new Ball("blue", ToySize.MEDIUM, AgeGroup.SECOND,
                "plastic", 20.4, 12.3, 0.9));
        testToys.add(new Car("red", ToySize.MEDIUM, AgeGroup.THIRD,
                "metal", 100, "teslaP100D", 1.30));
        testToys.add(new Cube("GREEN", ToySize.LARGE, AgeGroup.THIRD,
                "rubber", 79.9, 50, 50, 50, 1.5));
        testToys.add(new Doll("white", ToySize.LARGE, AgeGroup.FIRST,
                "eco-plastic", 44.4, DollVoice.NO_VOICE, Gender.MALE, "Ken"));
        testToys.add(new Ball("blue", ToySize.MEDIUM, AgeGroup.SECOND,
                "plastic", 20.4, 12.3, 0.9));
        testToys.add(new Car("red", ToySize.MEDIUM, AgeGroup.THIRD,
                "metal", 100, "teslaP100D", 1.30));
        testToys.add(new Cube("GREEN", ToySize.LARGE, AgeGroup.THIRD,
                "rubber", 79.9, 50, 50, 50, 1.5));
        testToys.add(new Doll("white", ToySize.LARGE, AgeGroup.FIRST,
                "eco-plastic", 44.4, DollVoice.NO_VOICE, Gender.MALE, "Ken"));
        testToys.add(new Ball("blue", ToySize.MEDIUM, AgeGroup.SECOND,
                "plastic", 20.4, 12.3, 0.9));
        testToys.add(new Car("red", ToySize.MEDIUM, AgeGroup.THIRD,
                "metal", 100, "teslaP100D", 1.30));
        testToys.add(new Cube("GREEN", ToySize.LARGE, AgeGroup.THIRD,
                "rubber", 79.9, 50, 50, 50, 1.5));
        testToys.add(new Doll("white", ToySize.LARGE, AgeGroup.FIRST,
                "eco-plastic", 44.4, DollVoice.NO_VOICE, Gender.MALE, "Ken"));

        RoomService roomService = new RoomService();
        ArrayList<Toy> foundToys = roomService.searchToys(testToys, 45.4);
        for (Toy t : foundToys) {
            assertTrue(t.getPrice() <= 45.4);
        }

    }

    @Test
    public void testSearchToys1() {
        ArrayList<Toy> testToys = new ArrayList<>();

        testToys.add(new Ball("blue", ToySize.MEDIUM, AgeGroup.SECOND,
                "plastic", 20.4, 12.3, 0.9));
        testToys.add(new Car("red", ToySize.MEDIUM, AgeGroup.THIRD,
                "metal", 100, "teslaP100D", 1.30));
        testToys.add(new Cube("GREEN", ToySize.LARGE, AgeGroup.THIRD,
                "rubber", 79.9, 50, 50, 50, 1.5));
        testToys.add(new Doll("white", ToySize.LARGE, AgeGroup.FIRST,
                "eco-plastic", 44.4, DollVoice.NO_VOICE, Gender.MALE, "Ken"));
        testToys.add(new Ball("blue", ToySize.MEDIUM, AgeGroup.SECOND,
                "plastic", 20.4, 12.3, 0.9));
        testToys.add(new Car("red", ToySize.MEDIUM, AgeGroup.THIRD,
                "metal", 100, "teslaP100D", 1.30));
        testToys.add(new Cube("GREEN", ToySize.LARGE, AgeGroup.THIRD,
                "rubber", 79.9, 50, 50, 50, 1.5));
        testToys.add(new Doll("white", ToySize.LARGE, AgeGroup.FIRST,
                "eco-plastic", 44.4, DollVoice.NO_VOICE, Gender.MALE, "Ken"));
        testToys.add(new Ball("blue", ToySize.MEDIUM, AgeGroup.SECOND,
                "plastic", 20.4, 12.3, 0.9));
        testToys.add(new Car("red", ToySize.MEDIUM, AgeGroup.THIRD,
                "metal", 100, "teslaP100D", 1.30));
        testToys.add(new Cube("GREEN", ToySize.LARGE, AgeGroup.THIRD,
                "rubber", 79.9, 50, 50, 50, 1.5));
        testToys.add(new Doll("white", ToySize.LARGE, AgeGroup.FIRST,
                "eco-plastic", 44.4, DollVoice.NO_VOICE, Gender.MALE, "Ken"));

        Set<AgeGroup> ageGroups = new HashSet<>();
        ageGroups.add(AgeGroup.SECOND);
        ageGroups.add(AgeGroup.FIRST);
        RoomService roomService = new RoomService();
        ArrayList<Toy> foundToys = roomService.searchToys(testToys, ageGroups);
        for (Toy t : foundToys) {
            assertTrue(t.getAgeGroup().equals(AgeGroup.SECOND) || t.getAgeGroup().equals(AgeGroup.FIRST));
        }
    }

}