package edu.epam.labs.hometask4.logic;

//Creating toys or generating toys according to budget.

import edu.epam.labs.hometask4.entity.*;

public class ToyFactory {

    public Toy getToy(String toyType, String color, ToySize toySize, AgeGroup ageGroup, String material,
                      double price){

        if (toyType == null){
            return null;
        }
        if (toyType.equalsIgnoreCase("BALL")){
            return new Ball(color, toySize, ageGroup, material, price);
        } else  if(toyType.equalsIgnoreCase("CAR")){
            return new Car(color, toySize, ageGroup, material, price);
        } else  if(toyType.equalsIgnoreCase("CUBE")){
            return new Cube(color, toySize, ageGroup, material, price);
        } else  if(toyType.equalsIgnoreCase("DOLL")){
            return new Doll(color, toySize, ageGroup, material, price);
        }

        return null;
    }

}
