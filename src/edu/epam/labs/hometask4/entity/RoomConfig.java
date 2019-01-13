package edu.epam.labs.hometask4.entity;

//Age groups, common budget

import java.util.Set;

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

    public void setAgeGroups(Set<AgeGroup> ageGroups) {
        this.ageGroups = ageGroups;
    }

    public double getCommonBudget() {
        return commonBudget;
    }

    public void setCommonBudget(double commonBudget) {
        this.commonBudget = commonBudget;
    }
}
