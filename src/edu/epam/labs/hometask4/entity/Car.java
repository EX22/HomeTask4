package edu.epam.labs.hometask4.entity;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return Double.compare(car.getScale(), getScale()) == 0 &&
                getModel().equals(car.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getModel(), getScale());
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", scale=" + scale +
                "} " + super.toString();
    }
}
