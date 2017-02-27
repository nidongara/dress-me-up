package com.docusign.Rules;

import com.docusign.enums.Constants;
import com.docusign.enums.Temperature;
import com.docusign.objects.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by nihardongara on 2/26/17.
 */
public class ValidCommand extends BasicRule {

    private List<Integer> input;
    private Temperature temperature;
    private Map<Integer, Command> commandMap;

    @Autowired
    ApplicationContext context;

    public ValidCommand(List<Integer> input, Temperature temperature, Map<Integer, Command> commandMap) {
        this.input = input;
        this.temperature = temperature;
        this.commandMap = commandMap;
    }


    @Override
    public boolean evaluate(List<Integer> commands) {
        return commandMap.keySet().containsAll(commands);
    }


}
