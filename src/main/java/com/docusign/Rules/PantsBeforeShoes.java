package com.docusign.Rules;

import com.docusign.enums.Constants;
import com.docusign.enums.Temperature;

import java.util.List;

/**
 * Rule that validates if pants are worn before shoes
 */
public class PantsBeforeShoes extends BasicRule {

    private List<Integer> input;
    private Temperature temperature;

    public PantsBeforeShoes(List<Integer> input, Temperature temperature) {
        this.input = input;
        this.temperature = temperature;
    }


    @Override
    public boolean evaluate(List<Integer> commands) {
        if (commands != null) {
            if (commands.contains(Constants.SHOES_COMMAND)) {
                int indexOfPants = commands.indexOf(Constants.PANTS_COMMAND);
                int indexOfShoes = commands.indexOf(Constants.SHOES_COMMAND);
                if(indexOfPants >-1 && indexOfShoes<indexOfPants){
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }

    }


}
