package edu.epam.labs.hometask4.entity;

import java.util.Set;

/**
 * Contains age groups and common budget parameters for game room creation.
 */
public class RoomConfig {

    private Set<AgeGroup> ageGroups;
    private double commonBudget;

    public RoomConfig(Set<AgeGroup> ageGroups, double commonBudget) {

        this.ageGroups = ageGroups;
        this.commonBudget = commonBudget;
    }

    public Set<AgeGroup> getAgeGroups() {
        return ageGroups;
    }

    public double getCommonBudget() {
        return commonBudget;
    }

    @Override
    public String toString() {
        return "RoomConfig{" +
                "ageGroups=" + ageGroups +
                ", commonBudget=" + commonBudget +
                '}';
    }
}
