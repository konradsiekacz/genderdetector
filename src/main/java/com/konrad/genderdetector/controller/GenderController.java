package com.konrad.genderdetector.controller;

import com.konrad.genderdetector.service.GenderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
public class GenderController {

    private final GenderService genderService;

    @GetMapping("/names/female")
    @ResponseStatus(HttpStatus.OK)
    public String getAllFemaleNames() {
        return genderService.getAllFemaleNames();
    }

    @GetMapping("names/male")
    @ResponseStatus(HttpStatus.OK)
    public String getAllMaleNames(){
        return genderService.getAllMaleNames();
    }

    @GetMapping("/gender/{name}/{option}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String checkGenderType(@PathVariable("name") String name, @PathVariable("option") String option){
        return genderService.getGenderForSpecificOption(name,option);
    }
}
