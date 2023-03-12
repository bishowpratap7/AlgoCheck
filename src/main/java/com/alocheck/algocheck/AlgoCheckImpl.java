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

        //Gather if it is an array only initialization
        String[] checkIfItIsAConstantTime = StringUtils.substringsBetween(s, "[", "]");

        AtomicBoolean isAConstantTime = new AtomicBoolean(false);
        if (!ArrayUtils.isEmpty(checkIfItIsAConstantTime)) {
            Arrays.stream(checkIfItIsAConstantTime).forEach(s1 -> isAConstantTime.set(NumberUtils.isCreatable(s1)));
        }

        if (verifyItIsNotAValidControlFlowStatement && !isAConstantTime.get()) {
            return "PLEASE CHECK IF IT IS A VALID ALGORITHM REQUEST";
        }

        if (verifyItIsNotAValidControlFlowStatement && isAConstantTime.get()) {
            return "O(1)";
        } else if (s.contains("for(") || s.contains("do{") || !s.contains("while(")) {
            return checkOof1(s);
        }
        return "Need More Information";

    }

    String checkOof1(String s) {
        int count = StringUtils.countMatches(s, "for(");
        if (count == 1) {
            return "O(n)";
        } else {
            return "O(n^" + count + ")";
        }
    }

    String checkOofNSquare(String s) {
        return "Need More Information";

    }

    String checkIfValidLoop(String s) {

        // Check if the input starts with "for"
        if (s.startsWith("for")) {
            // Check if the input contains the required syntax elements
            if (s.matches("for\\s*\\(.*;.*;.*\\)\\s*\\{.*\\}")) {
                System.out.println("Valid for loop.");
            } else {
                System.out.println("Invalid for loop.");
            }
        } else {
            System.out.println("Not a for loop.");
        }

        return "Need More Information";

    }

    public boolean isWhileLoop(String code) {
        // Remove whitespace and comments from the code string
        code = code.replaceAll("\\s+", "").replaceAll("//.*|/\\*.*?\\*/", "");

        // Search for the "while" keyword followed by a condition in parentheses
        int index = code.indexOf("while(");
        if (index == -1) {
            return false; // Not a while loop
        }

        // Search for the matching closing brace of the loop block
        int braceCount = 1;
        index = code.indexOf('{', index + 1);
        while (index != -1) {
            int nextIndex = code.indexOf("{}'", index + 1);
            if (nextIndex == -1) {
                return false; // Missing closing brace
            }
            if (code.charAt(nextIndex) == '{') {
                braceCount++;
            } else if (code.charAt(nextIndex) == '}') {
                braceCount--;
                if (braceCount == 0) {
                    return true; // Found while loop
                }
            } else if (code.charAt(nextIndex) == '\'') {
                nextIndex = code.indexOf('\'', nextIndex + 1);
                if (nextIndex == -1) {
                    return false; // Missing closing quote
                }
            }
            index = code.indexOf('{', nextIndex + 1);
        }

        return false; // Missing loop block
    }


}
