package com.docusign.Rules;

import com.docusign.enums.Temperature;

import java.util.List;

/**
 * Rule that validates if Pajama is take of first.
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
