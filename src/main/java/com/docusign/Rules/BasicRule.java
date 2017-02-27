package com.docusign.Rules;

import java.util.List;

/**
 * Basic rule that can be overridden by more specific rule.
 */
public class BasicRule {

    public boolean evaluate(List<Integer> input) {
        return true;
    }
}
