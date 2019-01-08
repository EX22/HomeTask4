package edu.epam.labs.hometask4.entity;

public class Doll extends Toy {

    private boolean voice; // use enum for voice.
    private String gender; // use enum for gender.
    private String name;

    public Doll(String color, ToySize toySize, AgeGroup ageGroup, String material, double price){

        super(color, toySize, ageGroup, material, price);
        voice = false;
        gender = "female";
        name = "Barbie";

    }

    public Doll(String color, ToySize toySize, AgeGroup ageGroup, String material,
                double price, boolean voice, String gender, String name) {

        super(color, toySize, ageGroup, material, price);
        this.voice = voice;
        this.gender = gender;
        this.name = name;
    }

    private String saySomething(){
        return "Say something";
    }

    public boolean isVoice() {
        return voice;
    }

    public void setVoice(boolean voice) {
        this.voice = voice;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
