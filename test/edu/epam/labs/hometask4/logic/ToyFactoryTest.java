package edu.epam.labs.hometask4.logic;

import edu.epam.labs.hometask4.entity.AgeGroup;
import edu.epam.labs.hometask4.entity.Car;
import edu.epam.labs.hometask4.entity.Toy;
import edu.epam.labs.hometask4.entity.ToySize;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ToyFactoryTest {

    @Test
    public void testCreateToy() {
        String toyLine = "Car, red, medium, third, metal, 100, teslaP100D, 1.30";
        ToyFactory toyFactory = new ToyFactory();
        Toy toy = toyFactory.createToy(toyLine);
        Car car = new Car("red", ToySize.MEDIUM, AgeGroup.THIRD, "metal",
                100, "teslaP100D", 1.30);
        assertEquals(toy, car);

    }
}