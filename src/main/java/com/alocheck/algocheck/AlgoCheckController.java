package com.alocheck.algocheck;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The {@code AlgoCheckController} class represents the Controller layer and is in a REST form.
 * This takes String as a request body.
 *
 * @author Bishow Pandey
 * @since 0.0.1-SNAPSHOT
 */
@RestController
@CrossOrigin
public class AlgoCheckController {
    private final AlgoCheck algoCheck;

    public AlgoCheckController(AlgoCheck algoCheck) {
        this.algoCheck = algoCheck;
    }

    @PostMapping(value = "/api/algoCheck", produces = {"text/plain"})
    String checkForAlgorithmicTimeComplexity(@RequestBody String s) {
        return algoCheck.checkAlgorithmicTimeComplexity(s);
    }
}
