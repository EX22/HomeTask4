package edu.epam.labs.hometask4.logic;

import edu.epam.labs.hometask4.entity.AgeGroup;
import edu.epam.labs.hometask4.entity.Toy;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.*;

public class RoomServiceTest {

    enum AgeGroup {FIRST, SECOND, THIRD}

    @Test
    public void testGenerateToys() {
        ArrayList<Toy > toysInStock = new ArrayList<>();
        Set<AgeGroup> set = new HashSet<>();
        //set.add(edu.epam.labs.hometask4.entity.AgeGroup.FIRST);
        set.add(AgeGroup.SECOND);
        RoomService roomService = new RoomService();
        //roomService.generateToys(set, 585.5, toysInStock);

    }

    @Test
    public void testSortToys() {
    }

    @Test
    public void testSearchToys() {
    }

    @Test
    public void testSearchToys1() {
    }
}