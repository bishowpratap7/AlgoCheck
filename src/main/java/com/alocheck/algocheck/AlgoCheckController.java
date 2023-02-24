package com.alocheck.algocheck;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlgoCheckController {
    private final AlgoCheck algoCheck;

    public AlgoCheckController(AlgoCheck algoCheck) {
        this.algoCheck = algoCheck;
    }

    @PostMapping("/api/algoCheck")
    String checkForAlogorithmicTimeComplexity(@RequestBody String s) {
        return algoCheck.checkAlogirithTimeComplexity(s);
    }
}
