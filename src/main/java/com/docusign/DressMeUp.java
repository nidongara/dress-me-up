package com.docusign;

import com.docusign.enums.Temperature;
import com.docusign.interfaces.CommandsManager;
import com.docusign.interfaces.CommandsProcessor;
import com.docusign.interfaces.RulesManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class DressMeUp {

    @Autowired
    CommandsProcessor commandsProcessor;

    @Autowired
    RulesManager rulesManager;

    private static final Logger LOGGER = LoggerFactory.getLogger(DressMeUp.class);

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new SpringApplicationBuilder()
                .sources(DressMeUp.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);

        DressMeUp app = context.getBean(DressMeUp.class);
        System.out.print("Please enter the input:");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

//        String input = "COLD 8, 6, 3, 4, 2, 5, 9, 1, 7";
        app.start(input);
    }

    private void start(String input) {
        try {

            System.out.println(commandsProcessor.process(input));

        } catch (Exception ex) {
            LOGGER.error("Error occurred running rules {}", ex);
        }
    }


}
