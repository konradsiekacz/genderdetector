package com.konrad.genderdetector.controller;

import com.konrad.genderdetector.service.GenderService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
public class TestConfig {

    @Bean
    public GenderService genderService(){
        return Mockito.mock(GenderService.class);
    }

    @Bean
    public GenderController genderController(){
        return new GenderController(genderService());
    }
}
