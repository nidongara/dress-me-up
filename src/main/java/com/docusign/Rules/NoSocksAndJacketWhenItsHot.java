package com.docusign.Rules;

import com.docusign.enums.Constants;
import com.docusign.enums.Temperature;

import java.util.*;

/**
 * Rule that checks if no socks and jackets are worn if its hot.
 */
public class NoSocksAndJacketWhenItsHot extends BasicRule {

    private List<Integer> input;
    private Temperature temperature;
    private List<Integer> listOfSockAndJAcketCommands = new ArrayList<>();

    public NoSocksAndJacketWhenItsHot(List<Integer> input, Temperature temperature) {
        this.input = input;
        this.temperature = temperature;
        listOfSockAndJAcketCommands.add(Constants.SOCKS_COMMAND);
        listOfSockAndJAcketCommands.add(Constants.JACKET_COMMAND);
    }


    @Override
    public boolean evaluate(List<Integer> commands) {
        if (commands != null) {
            if (this.temperature == Temperature.HOT && commands.containsAll(listOfSockAndJAcketCommands)) {
                return false;
            }
            return true;
        } else {
            return false;
        }

    }


}
