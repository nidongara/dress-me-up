package com.docusign.managers;

import com.docusign.Rules.*;
import com.docusign.enums.Constants;
import com.docusign.enums.Temperature;
import com.docusign.interfaces.CommandsManager;
import com.docusign.interfaces.RulesManager;
import com.docusign.objects.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Created by nihardongara on 2/26/17.
 */
@Component
public class RulesManagerImpl implements RulesManager {

    private List<BasicRule> dressUpRules = new ArrayList<>();
    private boolean rulesRegistered = false;
    private List<Integer> input;
    private Temperature temperature;

    @Autowired
    CommandsManager commandsManager;


    public void registerRules(List<Integer> input, Temperature temperature) {
        this.input = input;
        this.temperature = temperature;
        this.dressUpRules = new ArrayList<>();
        this.dressUpRules.add(new PajamasFirst(input, temperature));
        this.dressUpRules.add(new OnlyPieceOfEachType(input, temperature));
        this.dressUpRules.add(new NoSocksAndJacketWhenItsHot(input, temperature));
        this.dressUpRules.add(new SocksBeforeShoes(input, temperature));
        this.dressUpRules.add(new PantsBeforeShoes(input, temperature));
        this.dressUpRules.add(new ShirtBeforeHeadWearOrJacket(input, temperature));
        this.dressUpRules.add(new AllClothesAreOn(input, temperature));
        this.dressUpRules.add(new ValidCommand(input, temperature,commandsManager.getCommandMap()));
        this.rulesRegistered = true;
    }

    @Override
    public StringJoiner runRules() {
        StringJoiner output = new StringJoiner(", ");
        Map<Integer,Command> commandMap = commandsManager.getCommandMap();
        if (rulesRegistered && dressUpRules.size() > 0) {
            int index = 1;
            for (Integer command : input) {
                boolean commandValid = true;
                for (BasicRule rule : dressUpRules) {
                    if (!rule.evaluate(this.input.subList(0,index))) {
                        output.add(Constants.FAIL);
                        commandValid = false;
                        break;
                    }
                }
                if (commandValid) {
                   String response = commandMap.get(command).getResponses().get(this.temperature);
                   if(Constants.FAIL.equalsIgnoreCase(response)){
                       output.add(Constants.FAIL);
                       break;
                   }else{
                       output.add(response);
                   }
                }else{
                    break;
                }
                index++;
            }

        } else {
            System.out.println("Register the rules first");
        }
        return output;
    }
}
