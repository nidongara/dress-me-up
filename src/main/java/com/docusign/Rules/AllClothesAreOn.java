package com.docusign.Rules;

import com.docusign.enums.Constants;
import com.docusign.enums.Temperature;

import java.util.ArrayList;
import java.util.List;

/**
 * Rule that validates if all the clothes are worn before leaving the houe
 */
public class AllClothesAreOn extends BasicRule {

    private List<Integer> input;
    private Temperature temperature;
    private List<Integer> listOfAllHotWeatherClothes = new ArrayList<>();
    private List<Integer> listOfAllColdWeatherClothes = new ArrayList<>();

    public AllClothesAreOn(List<Integer> input, Temperature temperature) {
        this.input = input;
        this.temperature = temperature;
        listOfAllHotWeatherClothes.add(Constants.SHOES_COMMAND);
        listOfAllHotWeatherClothes.add(Constants.HEADWEAR_COMMAND);
        listOfAllHotWeatherClothes.add(Constants.SHIRT_COMMAND);
        listOfAllHotWeatherClothes.add(Constants.PANTS_COMMAND);

        listOfAllColdWeatherClothes.add(Constants.SHOES_COMMAND);
        listOfAllColdWeatherClothes.add(Constants.HEADWEAR_COMMAND);
        listOfAllColdWeatherClothes.add(Constants.SHIRT_COMMAND);
        listOfAllColdWeatherClothes.add(Constants.PANTS_COMMAND);
        listOfAllColdWeatherClothes.add(Constants.SOCKS_COMMAND);
        listOfAllColdWeatherClothes.add(Constants.JACKET_COMMAND);

    }


    @Override
    public boolean evaluate(List<Integer> commands) {

        if(commands!=null){
            if(this.temperature == Temperature.HOT && commands.get(commands.size()-1) == Constants.LEAVE_COMMAND){
                return commands.containsAll(listOfAllHotWeatherClothes);
            }else if(this.temperature == Temperature.COLD && commands.get(commands.size()-1) == Constants.LEAVE_COMMAND){
                return commands.containsAll(listOfAllColdWeatherClothes);
            }
            return true;
        }else{
            return false;
        }
    }


}
