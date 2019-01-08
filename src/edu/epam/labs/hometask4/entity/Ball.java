package edu.epam.labs.hometask4.entity;

public class Ball extends Toy {

    private double diameter;
    private double resilience;

    public Ball(String color, ToySize toySize, AgeGroup ageGroup, String material, double price){

        super(color, toySize, ageGroup, material, price);
        diameter = 1.0;
        resilience = 0.1;

    }

    public Ball(String color, ToySize toySize, AgeGroup ageGroup, String material,
                double price, double diameter, double resilience) {

        super(color, toySize, ageGroup, material, price);
        this.diameter = diameter;
        this.resilience = resilience;
    }



    private void toRoll(){
        //should be given some impulse to that logic
    }

    private void toBounce(){
        //should be given some impulse to that logic
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getResilience() {
        return resilience;
    }

    public void setResilience(double resilience) {
        this.resilience = resilience;
    }
}
