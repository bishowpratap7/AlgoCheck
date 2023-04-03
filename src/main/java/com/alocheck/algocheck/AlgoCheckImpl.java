package com.alocheck.algocheck;


import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * The {@code AlgoCheckImpl} class represents the core implementation logic on how an algorithmic complexity is calculated.
 * This takes String as a parameter.
 *
 * @author Bishow Pandey
 * @since 0.0.1-SNAPSHOT
 */
public class AlgoCheckImpl implements AlgoCheck {

    private static final String IF_CONDITION_CHECK = "if(";

    private static final String FOR_LOOP_CHECK = "for(";

    private static final String DO_LOOP_CHECK = "do{";

    private static final String WHILE_LOOP_CHECK = "while(";

    /**
     * @param s
     * @return
     */
    @Override
    public String checkAlgorithmicTimeComplexity(String s) {

        //Remove all whitespaces
        s = s.replaceAll("\\s", "");

        //Check if it is a valid request.
        boolean verifyItIsNotAValidControlFlowStatement = !s.contains(FOR_LOOP_CHECK) && !s.contains(DO_LOOP_CHECK)
                && !s.contains(WHILE_LOOP_CHECK) && !s.contains(IF_CONDITION_CHECK);

        if (verifyItIsNotAValidControlFlowStatement) {
            return "O(1)";
        } else if (s.contains(FOR_LOOP_CHECK) || s.contains(DO_LOOP_CHECK) || s.contains(WHILE_LOOP_CHECK)) {
            return checkOtherBigONotation(s);
        }
        return "Need More Information as this static code does not align with programming standard.";

    }

    String checkOtherBigONotation(String s) {
        int count = StringUtils.countMatches(s, FOR_LOOP_CHECK);
        int whileCount = StringUtils.countMatches(s, WHILE_LOOP_CHECK);
        int ifCount = StringUtils.countMatches(s, IF_CONDITION_CHECK);
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
            int countForNestedLoop = StringUtils.countMatches(checkForNestedLoop, FOR_LOOP_CHECK);

            if (countForNestedLoop > 0) {
                return "O(n)";
            }
            return "O(n^" + count + ")";
        }
    }
}
