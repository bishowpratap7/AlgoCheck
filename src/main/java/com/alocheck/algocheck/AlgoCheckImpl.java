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
}
