package edu.epam.labs.hometask4.entity;

public abstract class Toy {

    private String color;
    private ToySize toySize;
    private AgeGroup ageGroup;
    private String material;
    private double price;


    public Toy(String color, ToySize toySize, AgeGroup ageGroup, String material, double price) {
        this.color = color;
        this.toySize = toySize;
        this.ageGroup = ageGroup;
        this.material = material;
        this.price = price;
    }



    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ToySize getToySize() {
        return toySize;
    }

    public void setToySize(ToySize toySize) {
        this.toySize = toySize;
    }

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(AgeGroup ageGroup) {
        this.ageGroup = ageGroup;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }


}
