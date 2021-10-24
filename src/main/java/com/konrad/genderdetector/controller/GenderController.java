package com.konrad.genderdetector.controller;

import com.konrad.genderdetector.service.GenderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/gender/{name}/{option}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String checkGenderType(@PathVariable("name") String name, @PathVariable("option") String option){
        return genderService.getGenderForSpecificOption(name,option);
    }
}
