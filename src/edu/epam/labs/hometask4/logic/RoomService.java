package edu.epam.labs.hometask4.logic;

//Methods of sorting and searching toys.

import edu.epam.labs.hometask4.entity.AgeGroup;
import edu.epam.labs.hometask4.entity.RoomConfig;
import edu.epam.labs.hometask4.entity.Toy;
import edu.epam.labs.hometask4.entity.ToySize;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

public class RoomService {

    private static final Logger logger = Logger.getLogger(RoomService.class);

    public ArrayList<Toy> generateToys(RoomConfig roomConfig, ArrayList<Toy> toysInStock) {



        //1.search toys according to age group
        ArrayList<Toy> ageGroupToys = searchToys(toysInStock, roomConfig.getAgeGroups());
        ArrayList<Toy> resultToyList = new ArrayList<>();
        double budget = roomConfig.getCommonBudget();
        while (budget > 0) {

            //2.search toys according to budget
            ArrayList<Toy> budgetToys = searchToys(ageGroupToys, budget);
            if (budgetToys.size() == 0) {
                break;
            }

            //3.take random toy from filtered toys
            int toyIndex = (int) (Math.random() * budgetToys.size());
            Toy randomToy = budgetToys.get(toyIndex);
            resultToyList.add(randomToy);

            //4.decrease budget by the price of the generated toy
            budget -= randomToy.getPrice();

            //5.remove generated toy from age group list
            ageGroupToys.remove(randomToy);
        }

        //6.repeat from 2 while budget exists

        return resultToyList;
    }

    /*sortToys(resultToyList, new ToyByAgeGroup().thenComparing(new ToyByPrice()));
        resultToyList.sort(new ToyByAgeGroup());*/

    public ArrayList<Toy> sortToys(ArrayList<Toy> list, Comparator<Toy> comparator) {

        //list.sort(new ToyByAgeGroup().thenComparing(new ToyByPrice()));

        list.sort(comparator);

        return list;
    }

    public ArrayList<Toy> searchToys(ArrayList<Toy> source, Set<AgeGroup> ageGroups) {

        //Create a Stream from the source
        return source.stream().
                //filter the element to select only those with age group from ageGroups set
                        filter(t -> ageGroups.contains(t.getAgeGroup())).
                //put those filtered elements into a new ArrayList
                        collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Toy> searchToys(ArrayList<Toy> source, double budget) {

        /*ArrayList<Toy> resultToyBudget = new ArrayList<>();
        for (Toy t: source){
            if (t.getPrice() <= budget){
                resultToyBudget.add(t);,
            }
        }
        return resultToyBudget;*/
        // Implemented code does the same as above but in more effective way

        return source.stream().
                filter(t -> t.getPrice() <= budget).
                collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Toy> searchToys(ArrayList<Toy> source, double budget, ToySize toySize) {

        return source.stream().
                filter(t -> t.getPrice() <= budget && t.getToySize().equals(toySize)).
                collect(Collectors.toCollection(ArrayList::new));
    }
}
