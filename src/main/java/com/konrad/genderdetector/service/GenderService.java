package com.konrad.genderdetector.service;

import com.konrad.genderdetector.dao.TokenNameDao;
import com.konrad.genderdetector.model.Gender;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GenderService {
    private final TokenNameDao tokenNameDao;

    public String getAllFemaleNames() {
        return tokenNameDao.getFemaleNames();
    }

    public String getAllMaleNames() {
        return tokenNameDao.getMaleNames();
    }


    public String checkFirstNameForGender(String name) {
        Scanner femaleNames = tokenNameDao.scanThroughFemaleName();
        Scanner maleNames = tokenNameDao.scanThroughMaleName();

        while (femaleNames.hasNextLine()){
            if(femaleNames.nextLine().equals(name)){
                return Gender.FEMALE.toString();
            }
        }

        while (maleNames.hasNext()){
            if (maleNames.nextLine().equals(name)){
                return Gender.MALE.toString();
            }
        }
        return Gender.INCONCLUSIVE.toString();
    }

    public String checkAllNameForGender(String name) {
        String[] femaleNames = tokenNameDao.getFemaleNames().split("\n");
        String[] maleNames = tokenNameDao.getMaleNames().split("\n");
        int counterFemaleNames = 0;
        int counterMaleNames = 0;
        List<String> listOfNames = getPersonNamesInList(name);

        for (String femaleName : femaleNames) {
            if (listOfNames.contains(femaleName)) {
                counterFemaleNames++;
            }
        }

        for (String maleName : maleNames) {
            if (listOfNames.contains(maleName)) {
                counterMaleNames++;
            }
        }
        if (counterFemaleNames == counterMaleNames) {
            return Gender.INCONCLUSIVE.toString();
        }else {
            return counterFemaleNames > counterMaleNames ? Gender.FEMALE.toString() : Gender.MALE.toString();
        }
    }

    public List<String> getPersonNamesInList(String name) {
        return Arrays.stream(name.split(" ")).collect(Collectors.toList());
    }

    public String getGenderForSpecificOption(String name, String option) {
        switch (option) {
            case "first":
                return checkFirstNameForGender(name);
            case "all":
                return checkAllNameForGender(name);
        }
        return Gender.INCONCLUSIVE.toString();
    }
}
