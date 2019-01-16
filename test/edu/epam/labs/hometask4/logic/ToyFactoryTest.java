package edu.epam.labs.hometask4.logic;

import edu.epam.labs.hometask4.entity.*;
import edu.epam.labs.hometask4.exception.ToyCreationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class ToyFactoryTest {

    private static final Logger logger = LogManager.getLogger(ToyFactoryTest.class);

    @Test
    public void testCreateToy() throws ToyCreationException {
        logger.debug("Test started: ");
        String toyLine = "Car, 56, red, medium, third, metal, 100, teslaP100D, 1.30";
        ToyFactory toyFactory = new ToyFactory();
        ArrayList<Toy> toys = toyFactory.createToy(toyLine);
        Car car = new Car("red", ToySize.MEDIUM, AgeGroup.THIRD, "metal",
                100, "teslaP100D", 1.30);
        assertEquals(toys.get(0), car);
        assertEquals(toys.size(), 56);

        logger.debug("List of corresponding toys was successfully created.");

    }

    @Test
    public void testCreateToysList() {
        logger.debug("Test started: ");
        ArrayList<String> testToysList = new ArrayList<>();
        testToysList.add("Car, 4, red, medium, third, metal, 100, teslaP100D, 1.30");
        testToysList.add("First two parameters mean correspondingly, title and amount in stock");
        testToysList.add("Doll, 2, white, LARGE, fiRSt, eco-plastic, 44.4, no_Voice, MALE, Ken");
        testToysList.add("(String color, ToySize toySize, AgeGroup ageGroup, String material,");
        testToysList.add("BALL, 3, blue, small, second, plastic, 20.4, 12.3, 0.9");
        Toy ball = new Ball("blue", ToySize.SMALL, AgeGroup.SECOND,
                "plastic", 20.4, 12.3, 0.9);
        ToyFactory toyFactory = new ToyFactory();
        ArrayList<Toy> testToys = toyFactory.createToysList(testToysList);
        assertEquals(testToys.size(), 9);
        assertEquals(testToys.get(8), ball);

        logger.debug("List of toys according to given parameters was successfully created.");
    }
}