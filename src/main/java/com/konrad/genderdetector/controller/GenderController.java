package com.konrad.genderdetector.controller;

import com.konrad.genderdetector.service.GenderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@AllArgsConstructor
public class GenderController {

    private final GenderService genderService;

    @GetMapping("/females")
    public String getAllFemaleNames() throws IOException {
        return genderService.getAllFemaleNames();
    }
}
