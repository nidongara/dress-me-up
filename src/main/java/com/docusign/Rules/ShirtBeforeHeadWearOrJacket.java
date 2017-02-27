package com.docusign.Rules;

import com.docusign.enums.Constants;
import com.docusign.enums.Temperature;

import java.util.ArrayList;
import java.util.List;

/**
 * Rule that validates if shirt is worn before wearing jacket or head wear.
 */
public class ShirtBeforeHeadWearOrJacket extends BasicRule {

    private List<Integer> input;
    private Temperature temperature;
    private List<String> listOfSockAndJAcketCommands = new ArrayList<>();

    public ShirtBeforeHeadWearOrJacket(List<Integer> input, Temperature temperature) {
        this.input = input;
        this.temperature = temperature;

    }


    @Override
    public boolean evaluate(List<Integer> commands) {
        if (commands != null) {
            if (commands.contains(Constants.HEADWEAR_COMMAND)) {
                int indexOfShirt= commands.indexOf(Constants.SHIRT_COMMAND);
                int indexOfHeadwear = commands.indexOf(Constants.HEADWEAR_COMMAND);
                if(indexOfShirt >-1 && indexOfHeadwear<indexOfShirt){
                    return false;
                }
            }else if (commands.contains(Constants.JACKET_COMMAND)) {
                int indexOfShirt= commands.indexOf(Constants.SHIRT_COMMAND);
                int indexOfJacket = commands.indexOf(Constants.JACKET_COMMAND);
                if(indexOfShirt >-1 && indexOfJacket<indexOfShirt){
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }


}
