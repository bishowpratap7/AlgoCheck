package com.alocheck.algocheck;

import org.springframework.web.bind.annotation.*;

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
