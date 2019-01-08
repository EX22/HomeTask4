package edu.epam.labs.hometask4.entity;

public class Car extends Toy {

    private String model;
    private double scale;

    public Car(String color, ToySize toySize, AgeGroup ageGroup, String material, double price){

        super(color, toySize, ageGroup, material, price);
        model = "Ferrari";
        scale = 1.0;

    }


    public Car(String color, ToySize toySize, AgeGroup ageGroup, String material,
               double price, String model, double scale) {

        super(color, toySize, ageGroup, material, price);
        this.model = model;
        this.scale = scale;
    }

    private void toRide(){

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }
}
