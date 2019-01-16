package edu.epam.labs.hometask4.logic;

import edu.epam.labs.hometask4.entity.*;
import edu.epam.labs.hometask4.exception.ToyCreationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

/**
 * Toys creation according to parameters read from file.
 */
public class ToyFactory {

    private static final Logger logger = LogManager.getLogger(ToyFactory.class);

    /**
     * Search lines with parameters for toy's creation and creates stock of toys.
     *
     * @param toyLines list of lines read from file
     * @return list of toys in stock.
     */
    public ArrayList<Toy> createToysList(ArrayList<String> toyLines) {

        ArrayList<Toy> toysList = new ArrayList<>();
        for (String s : toyLines) {
            try {
                toysList.addAll(createToy(s));
            } catch (ToyCreationException e) {
                logger.warn("Ignoring line " + s);
            }

        }
        return toysList;
    }

    /**
     * Creates toys of same type according to given parameters.
     *
     * @param toyLine line with toy's parameters such as title, amount, color etc.
     * @return list of toys created using given parameters.
     * @throws ToyCreationException - in case of invalid parameters for toy's creation.
     */
    public ArrayList<Toy> createToy(String toyLine) throws ToyCreationException {

        ArrayList<Toy> createdToys = new ArrayList<>();
        try {

            String[] props = toyLine.split(",");
            for (int j = 0; j < props.length; j++) {
                props[j] = props[j].trim();
            }
            if (props.length < 2) {
                String message = "Less than two properties in line for toy creation: " + toyLine;
                logger.warn(message);
                throw new ToyCreationException(message);
            }
            for (int i = 0; i < Integer.parseInt(props[1]); i++) {
                switch (props[0].toUpperCase()) {
                    case "BALL":
                        if (props.length < 9) {
                            String message = notEnoughParamMsg(props[0].toUpperCase(), toyLine);
                            logger.warn(message);
                            throw new ToyCreationException(message);
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
                            String message = notEnoughParamMsg(props[0].toUpperCase(), toyLine);
                            logger.warn(message);
                            throw new ToyCreationException(message);
                        }
                        createdToys.add(new Car(props[2], ToySize.valueOf(props[3].toUpperCase()),
                                AgeGroup.valueOf(props[4].toUpperCase()), props[5],
                                Double.parseDouble(props[6]), props[7], Double.parseDouble(props[8])));
                        break;
                    //String color, ToySize toySize, AgeGroup ageGroup, String material,
                    //               double price, String model, double scale

                    case "CUBE":
                        if (props.length < 11) {
                            String message = notEnoughParamMsg(props[0].toUpperCase(), toyLine);
                            logger.warn(message);
                            throw new ToyCreationException(message);
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
                            String message = notEnoughParamMsg(props[0].toUpperCase(), toyLine);
                            logger.warn(message);
                            throw new ToyCreationException(message);
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
            String message = "During toys creation an exception occurred " + toyLine;
            logger.warn(message, e);
            throw new ToyCreationException(message, e);
        }
        if (createdToys.size() == 0) {
            String message = "There were not created any toys" +
                    " because of invalid characteristics: " + toyLine;
            logger.warn(message);
            throw new ToyCreationException(message);

        }
        logger.debug(createdToys.size() + " toys were produced.");
        return createdToys;
    }

    public String notEnoughParamMsg(String toyType, String toyLine){
        return "There are not enough elements " +
                "in the line for " + toyType + " creation: " + toyLine;
    }

}
