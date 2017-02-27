package com.docusign.interfaces;

import com.docusign.enums.Temperature;

import java.util.List;
import java.util.StringJoiner;

/**
 * Interface for CommandsManager
 */
public interface RulesManager {
    void registerRules(List<Integer> input, Temperature temperature);
    StringJoiner runRules();
}
