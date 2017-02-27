package com.docusign.interfaces;

import com.docusign.enums.Temperature;

import java.util.List;
import java.util.StringJoiner;

/**
 * Created by nihardongara on 2/26/17.
 */
public interface RulesManager {
    void registerRules(List<Integer> input, Temperature temperature);
    StringJoiner runRules();
}
