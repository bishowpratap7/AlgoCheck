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

}
