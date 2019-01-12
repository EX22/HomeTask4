package edu.epam.labs.hometask4.entity;

//Age groups, common budget
//Probably this class should be in other package

public class RoomConfig {

    private AgeGroup configAgeGroup;
    private double commonBudget;

    public RoomConfig(AgeGroup configAgeGroup, double commonBudget) {
        this.configAgeGroup = configAgeGroup;
        this.commonBudget = commonBudget;
    }

    public AgeGroup getConfigAgeGroup() {
        return configAgeGroup;
    }

    public void setConfigAgeGroup(AgeGroup configAgeGroup) {
        this.configAgeGroup = configAgeGroup;
    }

    public double getCommonBudget() {
        return commonBudget;
    }

    public void setCommonBudget(double commonBudget) {
        this.commonBudget = commonBudget;
    }
}
