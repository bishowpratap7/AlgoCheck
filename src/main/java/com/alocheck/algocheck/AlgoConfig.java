package com.alocheck.algocheck;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlgoConfig {

    @Bean
    AlgoCheckImpl algoCheckImpl(){
        return new AlgoCheckImpl();
    }
}
