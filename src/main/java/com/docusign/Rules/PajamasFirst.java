package com.docusign.Rules;

import com.docusign.enums.Temperature;

import java.util.List;

/**
 * Created by nihardongara on 2/26/17.
 */
public class PajamasFirst extends BasicRule {

    private List<Integer> input;
    private Temperature temperature;

    public PajamasFirst(List<Integer> input, Temperature temperature) {
        this.input = input;
        this.temperature = temperature;
    }


    @Override
    public boolean evaluate(List<Integer> commands) {
        return commands!=null && commands.get(0)==8;
    }


}
