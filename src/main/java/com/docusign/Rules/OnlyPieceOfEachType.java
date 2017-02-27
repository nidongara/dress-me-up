package com.docusign.Rules;

import com.docusign.enums.Temperature;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Rule that validates if only piece of each clothing is worn
 */
public class OnlyPieceOfEachType extends BasicRule {

    private List<Integer> input;
    private Temperature temperature;

    public OnlyPieceOfEachType(List<Integer> input, Temperature temperature) {
        this.input = input;
        this.temperature = temperature;
    }


    @Override
    public boolean evaluate(List<Integer> commands) {
        if(commands!=null){
            Set<Integer> set1 = new HashSet<Integer>();
            for(Integer command : commands){
                if(!set1.add(command)){
                    return false;
                }
            }
            return true;
        }else{
            return false;
        }

    }


}
