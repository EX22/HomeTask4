package edu.epam.labs.hometask4.entity;

public class Cube extends Toy {

    private int length;
    private int width;
    private int height;
    private double weight;

    public Cube(String color, ToySize toySize, AgeGroup ageGroup, String material, double price){

        super(color, toySize, ageGroup, material, price);
        length = 1;
        width = 1;
        height = 1;
        weight = 1;

    }

    public Cube(String color, ToySize toySize, AgeGroup ageGroup, String material,
                double price, int length, int width, int height, double weight) {

        super(color, toySize, ageGroup, material, price);
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }


    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
