package com.alocheck.algocheck;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlgoCheckController {
    private final AlgoCheck algoCheck;

    public AlgoCheckController(AlgoCheck algoCheck) {
        this.algoCheck = algoCheck;
    }

    @GetMapping("/api/algoCheck")
    String checkForAlogorithmicTimeComplexity(@RequestParam String s) {
        return algoCheck.checkAlogirithTimeComplexity(s);
    }
}
