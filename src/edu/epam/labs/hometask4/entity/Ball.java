package edu.epam.labs.hometask4.entity;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;
        if (!super.equals(o)) return false;
        Ball ball = (Ball) o;
        return Double.compare(ball.getDiameter(), getDiameter()) == 0 &&
                Double.compare(ball.getResilience(), getResilience()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDiameter(), getResilience());
    }

    @Override
    public String toString() {
        return "Ball{" +
                "diameter=" + diameter +
                ", resilience=" + resilience +
                "} " + super.toString();
    }
}
