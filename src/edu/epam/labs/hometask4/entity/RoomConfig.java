package edu.epam.labs.hometask4.entity;

//Age groups, common budget

import edu.epam.labs.hometask4.exception.RoomConfigException;
import org.apache.log4j.Logger;

import java.util.Set;

public class RoomConfig {

    private static final Logger logger = Logger.getLogger(RoomConfig.class);

    private Set<AgeGroup> ageGroups;
    private double commonBudget;

    public RoomConfig(Set<AgeGroup> ageGroups, double commonBudget) throws RoomConfigException {
        if (ageGroups == null || ageGroups.isEmpty() || commonBudget <= 0){
            String message = "Invalid room config parameters";
            logger.warn(message);
            throw new RoomConfigException(message);
        }
        this.ageGroups = ageGroups;
        this.commonBudget = commonBudget;
    }

    public Set<AgeGroup> getAgeGroups() {
        return ageGroups;
    }

    public double getCommonBudget() {
        return commonBudget;
    }

}
