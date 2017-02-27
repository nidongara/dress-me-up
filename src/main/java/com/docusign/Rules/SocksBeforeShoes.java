package com.docusign.Rules;

import com.docusign.enums.Constants;
import com.docusign.enums.Temperature;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nihardongara on 2/26/17.
 */
public class SocksBeforeShoes extends BasicRule {

    private List<Integer> input;
    private Temperature temperature;

    public SocksBeforeShoes(List<Integer> input, Temperature temperature) {
        this.input = input;
        this.temperature = temperature;
    }


    @Override
    public boolean evaluate(List<Integer> commands) {
        if (commands != null) {
            if (commands.contains(Constants.SHOES_COMMAND)) {
                int indexOfSocks = commands.indexOf(Constants.SOCKS_COMMAND);
                int indexOfShoes = commands.indexOf(Constants.SHOES_COMMAND);
                if(indexOfSocks >-1 && indexOfShoes<indexOfSocks){
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }

    }


}
