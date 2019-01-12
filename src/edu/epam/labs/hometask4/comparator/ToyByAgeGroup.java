package edu.epam.labs.hometask4.comparator;


import edu.epam.labs.hometask4.entity.Toy;

import java.util.Comparator;

public class ToyByAgeGroup implements Comparator<Toy> {

    @Override
    public int compare(Toy o1, Toy o2) {
        if (o1 != null && o2 != null) {
            return o1.getAgeGroup().compareTo(o2.getAgeGroup());
        }
        if (o1 == null && o2 == null) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        } else {
            return 1;
        }
    }
}
