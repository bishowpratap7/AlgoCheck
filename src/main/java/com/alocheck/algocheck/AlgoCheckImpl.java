package com.alocheck.algocheck;


import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class AlgoCheckImpl implements AlgoCheck {
    /**
     * @param s
     * @return
     */
    @Override
    public String checkAlogirithTimeComplexity(String s) {

        //Remove all whitespaces
        s = s.replaceAll("\\s", "");

        //Check if it is a valid request.
        boolean verifyItIsNotAValidControlFlowStatement = !s.contains("for(") && !s.contains("do{")
                && !s.contains("while(") && !s.contains("if(");

        if (verifyItIsNotAValidControlFlowStatement) {
            return "O(1)";
        } else if (s.contains("for(") || s.contains("do{") || s.contains("while(")) {
            return checkOtherBigONotation(s);
        }
        return "Need More Information";

    }

    String checkOtherBigONotation(String s) {
        int count = StringUtils.countMatches(s, "for(");
        int whileCount = StringUtils.countMatches(s, "while(");
        int ifCount = StringUtils.countMatches(s, "if(");
        if (whileCount > 0 && ifCount > 0) {
            return "O(log n)";
        }

        if (count == 1) {
            String[] checkIfItIsAConstantTime = StringUtils.substringsBetween(s, "<", ";");
            AtomicBoolean isAConstantTime = new AtomicBoolean(false);
            if (!ArrayUtils.isEmpty(checkIfItIsAConstantTime)) {
                Arrays.stream(checkIfItIsAConstantTime).forEach(s1 -> isAConstantTime.set(NumberUtils.isCreatable(s1)));
            }
            if (isAConstantTime.get()) {
                return "O(1)";
            }

            return "O(n)";
        } else {
            String checkForNestedLoop = StringUtils.substringAfter(s, "}");
            int countForNestedLoop = StringUtils.countMatches(checkForNestedLoop, "for(");

            if (countForNestedLoop > 0) {
                return "O(n)";
            }
            return "O(n^" + count + ")";
        }
    }
}
