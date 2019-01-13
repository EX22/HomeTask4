package edu.epam.labs.hometask4.logic;

import edu.epam.labs.hometask4.entity.AgeGroup;
import edu.epam.labs.hometask4.entity.Car;
import edu.epam.labs.hometask4.entity.Toy;
import edu.epam.labs.hometask4.entity.ToySize;
import edu.epam.labs.hometask4.exception.ToyCreationException;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class ToyFactoryTest {

    @Test
    public void testCreateToy() throws ToyCreationException {
        String toyLine = "Car, 56, red, medium, third, metal, 100, teslaP100D, 1.30";
        ToyFactory toyFactory = new ToyFactory();
        ArrayList<Toy> toys = toyFactory.createToy(toyLine);
        Car car = new Car("red", ToySize.MEDIUM, AgeGroup.THIRD, "metal",
                100, "teslaP100D", 1.30);
        assertEquals(toys.get(0), car);
        assertEquals(toys.size(), 56);

    }
}