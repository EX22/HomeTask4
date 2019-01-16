package edu.epam.labs.hometask4.entity;

import java.util.Objects;

/**
 * Entity for storing doll toy with parameters.
 */
public class Doll extends Toy {

    private DollVoice voice;
    private Gender gender;
    private String name;

    public Doll(String color, ToySize toySize, AgeGroup ageGroup, String material, double price) {

        super(color, toySize, ageGroup, material, price);
        voice = DollVoice.NO_VOICE;
        gender = Gender.FEMALE;
        name = "Barbie";

    }

    public Doll(String color, ToySize toySize, AgeGroup ageGroup, String material,
                double price, DollVoice voice, Gender gender, String name) {

        super(color, toySize, ageGroup, material, price);
        this.voice = voice;
        this.gender = gender;
        this.name = name;
    }

    public DollVoice getVoice() {
        return voice;
    }

    public void setVoice(DollVoice voice) {
        this.voice = voice;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doll)) return false;
        if (!super.equals(o)) return false;
        Doll doll = (Doll) o;
        return voice == doll.voice &&
                getGender() == doll.getGender() &&
                getName().equals(doll.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), voice, getGender(), getName());
    }

    @Override
    public String toString() {
        return "Doll{" +
                "voice=" + voice +
                ", gender=" + gender +
                ", name='" + name + '\'' +
                "} " + super.toString();
    }
}
