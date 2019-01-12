package edu.epam.labs.hometask4.validator;

import edu.epam.labs.hometask4.exception.DataValidationException;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class DataValidator {

    public ArrayList<String> validateData(ArrayList<String> list) throws DataValidationException {
        if (list == null){
            throw new DataValidationException("List is null!");
        } else if(list.size() == 0){
            throw new DataValidationException("List is empty!");
        }
        ArrayList<String> validList = new ArrayList<>();
        for (String s: list){
            if (Pattern.matches("", s)){
                ///^[A-Z]{4}[,]{1} [a-z]{4}[,]{1} [a-z]{5}[,]{1}
                // [a-z]{6}[,]{1} [a-z]{7}[,]{1} [0-9]{2}[.]{1}[0-9]{1}[,]{1}
                // [0-9]{2}[.]{1}[0-9]{1}[,]{1} [0-9]{1}[.]{1}[0-9]{1}[,]{1} [0-9]{2}$/
                validList.add(s);
            }
        }

        return validList;
    }

}
