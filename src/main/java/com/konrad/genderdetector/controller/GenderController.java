package com.konrad.genderdetector.controller;

import com.konrad.genderdetector.service.GenderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
public class GenderController {

    private final GenderService genderService;

    @GetMapping("/females")
    public List<?> getAllFemaleNames() {
        return genderService.getAllFemaleNames();
    }


}
