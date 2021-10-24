package com.konrad.genderdetector.controller;

import com.konrad.genderdetector.service.GenderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class GenderController {

    private final GenderService genderService;

    @GetMapping("/names")
    @ResponseStatus(HttpStatus.OK)
    public List<?> getAllNames() {
        return genderService.getAllFemaleNames();
    }


}
