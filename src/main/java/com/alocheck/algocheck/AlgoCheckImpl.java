package com.alocheck.algocheck;

public class AlgoCheckImpl implements AlgoCheck {
    /**
     * @param s
     * @return
     */
    @Override
    public String checkAlogirithTimeComplexity(String s) {
        if (!s.contains("for(")) {
            return "O(1)";
        }
        return "Need More Information";
    }

    String checkOof1(String s) {
        return "Need More Information";

    }

    String checkOofN(String s) {
        return "Need More Information";

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
