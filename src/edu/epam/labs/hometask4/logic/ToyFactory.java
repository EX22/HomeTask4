package edu.epam.labs.hometask4.logic;

//Creating toys or generating toys according to budget.

import edu.epam.labs.hometask4.entity.*;

public class ToyFactory {


    public Toy createToy(String toyLine) {

        String[] props = toyLine.replaceAll("\\s+", "").split(",");
        switch (props[0].toUpperCase()) {
            case "BALL":
                return new Ball(props[1], ToySize.valueOf(props[2].toUpperCase()),
                        AgeGroup.valueOf(props[3].toUpperCase()), props[4],
                        Double.parseDouble(props[5]), Double.parseDouble(props[6]),
                        Double.parseDouble(props[7]));
            //String color, ToySize toySize, AgeGroup ageGroup, String material,
            //                double price, double diameter, double resilience

            case "CAR":
                return new Car(props[1], ToySize.valueOf(props[2].toUpperCase()),
                        AgeGroup.valueOf(props[3].toUpperCase()), props[4],
                        Double.parseDouble(props[5]), props[6], Double.parseDouble(props[7]));
            //String color, ToySize toySize, AgeGroup ageGroup, String material,
            //               double price, String model, double scale

            case "CUBE":
                return new Cube(props[1], ToySize.valueOf(props[2].toUpperCase()),
                        AgeGroup.valueOf(props[3].toUpperCase()), props[4],
                        Double.parseDouble(props[5]), Integer.parseInt(props[6]),
                        Integer.parseInt(props[7]), Integer.parseInt(props[8]),
                        Double.parseDouble(props[9]));
            //String color, ToySize toySize, AgeGroup ageGroup, String material,
            //                double price, int length, int width, int height, double weight

            case "DOLL":
                return new Doll(props[1], ToySize.valueOf(props[2].toUpperCase()),
                        AgeGroup.valueOf(props[3].toUpperCase()), props[4],
                        Double.parseDouble(props[5]), DollVoice.valueOf(props[6].toUpperCase()),
                        Gender.valueOf(props[7].toUpperCase()), props[8]);
            //String color, ToySize toySize, AgeGroup ageGroup, String material,
            //                double price, boolean voice, Gender gender, String name

            default:
                return null;

        }
    }

}
