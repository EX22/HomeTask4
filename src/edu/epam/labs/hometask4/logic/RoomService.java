package edu.epam.labs.hometask4.logic;

import edu.epam.labs.hometask4.entity.AgeGroup;
import edu.epam.labs.hometask4.entity.RoomConfig;
import edu.epam.labs.hometask4.entity.Toy;
import edu.epam.labs.hometask4.entity.ToySize;
import edu.epam.labs.hometask4.exception.RoomConfigException;
import edu.epam.labs.hometask4.exception.RoomServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Generating, sorting and searching toys.
 */
public class RoomService {

    private static final Logger logger = LogManager.getLogger(RoomService.class);

    /**
     * Method generates list of toys for game room according to given parameters.
     *
     * @param roomConfig  contains age groups and budget parameters necessary for game room creation.
     * @param toysInStock list of toys that we got in stock.
     * @return particular list of toys generated from toys we got in stock for particular game room
     * within demanded age groups and budget.
     * @throws RoomConfigException  - in case if room configuration's parameters are not valid for room creation.
     * @throws RoomServiceException - in case if there are no toys in stock.
     */
    public ArrayList<Toy> generateToys(RoomConfig roomConfig, ArrayList<Toy> toysInStock) throws RoomConfigException,
            RoomServiceException {

        if (roomConfig.getAgeGroups() == null || roomConfig
                .getAgeGroups().isEmpty() || roomConfig.getCommonBudget() <= 0) {
            String message = "Invalid room config parameters";
            logger.warn(message);
            throw new RoomConfigException(message);
        }

        if (toysInStock == null || toysInStock.isEmpty()) {
            String message = "There are no toys in stock.";
            logger.error(message);
            throw new RoomServiceException(message);
        }

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

    /**
     * Sort list of toys as it demands.
     *
     * @param list       unsorted list of toys from game room.
     * @param comparator parameter according to that list of toys from game room will be sorted.
     * @return sorted according to demanded parameter list of toys from game room.
     */
    public ArrayList<Toy> sortToys(ArrayList<Toy> list, Comparator<Toy> comparator) {

        //list.sort(new ToyByAgeGroup().thenComparing(new ToyByPrice()));

        list.sort(comparator);

        return list;
    }

    /**
     * Search for toys in the game room within demanded age groups.
     *
     * @param source    list of toys from game room where we are going to find toys with needed parameter.
     * @param ageGroups set of age groups for demanded toys.
     * @return list of toys with needed age groups parameter.
     */
    public ArrayList<Toy> searchToys(ArrayList<Toy> source, Set<AgeGroup> ageGroups) {

        //Create a Stream from the source
        return source.stream().
                //filter the element to select only those with age group from ageGroups set
                        filter(t -> ageGroups.contains(t.getAgeGroup())).
                //put those filtered elements into a new ArrayList
                        collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Search for toys in the game room within demanded budget.
     *
     * @param source list of toys from game room where we are going to find toys with needed parameter.
     * @param budget set of age groups for demanded toys.
     * @return list of toys within demanded budget parameter.
     */
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

    /**
     * Search for toys in the game room within demanded budget and toy size.
     *
     * @param source  list of toys from game room where we are going to find toys with needed parameters.
     * @param budget  amount of money toys price from list need to be.
     * @param toySize toy size parameters for demanded toys.
     * @return list of toys within demanded budget and toy size parameters.
     */
    public ArrayList<Toy> searchToys(ArrayList<Toy> source, double budget, ToySize toySize) {

        return source.stream().
                filter(t -> t.getPrice() <= budget && t.getToySize().equals(toySize)).
                collect(Collectors.toCollection(ArrayList::new));
    }
}
