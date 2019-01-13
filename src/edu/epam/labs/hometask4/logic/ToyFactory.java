package edu.epam.labs.hometask4.logic;

//Creating toys or generating toys according to budget.

import edu.epam.labs.hometask4.entity.*;
import edu.epam.labs.hometask4.exception.ToyCreationException;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class ToyFactory {

    public static final Logger logger = Logger.getLogger(ToyFactory.class);

    public ArrayList<Toy> createToy(String toyLine) throws ToyCreationException {

        ArrayList<Toy> createdToys = new ArrayList<>();
        try {

            String[] props = toyLine.split(",");
            for (int j = 0; j < props.length; j++) {
                props[j] = props[j].trim();
            }
            if (props.length < 2) {
                throw new ToyCreationException("Les than two properties in line for toy creation: " + toyLine);
            }
            for (int i = 0; i < Integer.parseInt(props[1]); i++) {
                switch (props[0].toUpperCase()) {
                    case "BALL":
                        if (props.length < 9) {
                            throw new ToyCreationException("There is not enough elements " +
                                    "in the line for ball creation: " + toyLine);
                        }
                        createdToys.add(new Ball(props[2], ToySize.valueOf(props[3].toUpperCase()),
                                AgeGroup.valueOf(props[4].toUpperCase()), props[5],
                                Double.parseDouble(props[6]), Double.parseDouble(props[7]),
                                Double.parseDouble(props[8])));
                        break;
                    //String color, ToySize toySize, AgeGroup ageGroup, String material,
                    //                double price, double diameter, double resilience

                    case "CAR":
                        if (props.length < 9) {
                            throw new ToyCreationException("There is not enough elements " +
                                    "in the line for car creation: " + toyLine);
                        }
                        createdToys.add(new Car(props[2], ToySize.valueOf(props[3].toUpperCase()),
                                AgeGroup.valueOf(props[4].toUpperCase()), props[5],
                                Double.parseDouble(props[6]), props[7], Double.parseDouble(props[8])));
                        break;
                    //String color, ToySize toySize, AgeGroup ageGroup, String material,
                    //               double price, String model, double scale

                    case "CUBE":
                        if (props.length < 11) {
                            throw new ToyCreationException("There is not enough elements " +
                                    "in the line for cube creation: " + toyLine);
                        }
                        createdToys.add(new Cube(props[2], ToySize.valueOf(props[3].toUpperCase()),
                                AgeGroup.valueOf(props[4].toUpperCase()), props[5],
                                Double.parseDouble(props[6]), Integer.parseInt(props[7]),
                                Integer.parseInt(props[8]), Integer.parseInt(props[9]),
                                Double.parseDouble(props[10])));
                        break;
                    //String color, ToySize toySize, AgeGroup ageGroup, String material,
                    //                double price, int length, int width, int height, double weight

                    case "DOLL":
                        if (props.length < 10) {
                            throw new ToyCreationException("There is not enough elements " +
                                    "in the line for doll creation: " + toyLine);
                        }
                        createdToys.add(new Doll(props[2], ToySize.valueOf(props[3].toUpperCase()),
                                AgeGroup.valueOf(props[4].toUpperCase()), props[5],
                                Double.parseDouble(props[6]), DollVoice.valueOf(props[7].toUpperCase()),
                                Gender.valueOf(props[8].toUpperCase()), props[9]));
                        break;
                    //String color, ToySize toySize, AgeGroup ageGroup, String material,
                    //                double price, boolean voice, Gender gender, String name

                    default:
                        throw new ToyCreationException("There is no toy with " +
                                "corresponding characteristics: " + toyLine);

                }
            }
        } catch (NumberFormatException e) {
            logger.warn("During toys creation an exception occurred ", e);
        }
        if (createdToys.size() == 0) {
            throw new ToyCreationException("There was not created any toys" +
                    " because of invalid characteristics: " + toyLine);
        }
        return createdToys;
    }

}
