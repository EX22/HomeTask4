package edu.epam.labs.hometask4.comparator;

import edu.epam.labs.hometask4.entity.Toy;

import java.util.Comparator;

public class ToyByPrice implements Comparator<Toy> {

    @Override
    public int compare(Toy o1, Toy o2) {
        if (o1 != null && o2 != null) {
            return Double.compare(o1.getPrice(), o2.getPrice());
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
