package com.docusign.processors;

import com.docusign.enums.Constants;
import com.docusign.enums.Temperature;
import com.docusign.interfaces.CommandsProcessor;
import com.docusign.interfaces.RulesManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nihardongara on 2/27/17.
 */
@Component
public class CommandsProcessorImpl implements CommandsProcessor {

    @Autowired
    RulesManager rulesManager;

    private static final Logger LOGGER = LoggerFactory.getLogger(CommandsProcessorImpl.class);

    @Override
    public String process(String input) {
        try {

            Pattern pattern = Pattern.compile("([a-zA-Z]*)((\\s*\\d*,?)*)");
            Matcher matched = pattern.matcher(input);
            if (matched.find()) { // if there's a match
                Temperature temperature = getTemperature(matched.group(1));
                String newS = matched.group(2).replace(" ", "");
                ArrayList<Integer> commands = new ArrayList<Integer>();
                for (String s : newS.split(",")) {
                    commands.add(Integer.parseInt(s));
                }
                rulesManager.registerRules(commands, temperature);
                return rulesManager.runRules().toString();
            }

        } catch (Exception ex) {
            LOGGER.error("Error occurred running commands {}", ex);
        }
        return Constants.FAIL;
    }

    private Temperature getTemperature(String temp) {
        return Temperature.valueOf(temp.toUpperCase());
    }
}
