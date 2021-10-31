package com.konrad.genderdetector.service;

import com.konrad.genderdetector.dao.TokenNameDao;
import com.konrad.genderdetector.model.Gender;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Scanner;

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

    public String checkNameForGender(String name) {
        int indexOfName = 0;
        String[] splitName = name.split(" ");
        Scanner femaleNames = tokenNameDao.scanThroughFemaleName();
        Scanner maleNames = tokenNameDao.scanThroughMaleName();

        while (femaleNames.hasNext()) {
            if (femaleNames.nextLine().equals(splitName[indexOfName])) {
                return Gender.FEMALE.toString();
            }
        }

        while (maleNames.hasNext()) {
            if (maleNames.nextLine().equals(splitName[indexOfName])) {
                return Gender.MALE.toString();
            }
        }
        return Gender.INCONCLUSIVE.toString();
    }

    public String checkAllNameForGender(String name) {

        String[] splitName = name.split(" ");
        long numberOfFemaleNames = 0;
        long numberOfMaleNames = 0;

        for (String eachName : splitName) {
            if (checkNameForGender(eachName).equals(Gender.FEMALE.toString())) {
                numberOfFemaleNames++;
            } else if (checkNameForGender(eachName).equals(Gender.MALE.toString())) {
                numberOfMaleNames++;
            }
        }
        if (numberOfFemaleNames == numberOfMaleNames) {
            return Gender.INCONCLUSIVE.toString();
        }
        return numberOfFemaleNames > numberOfMaleNames ? Gender.FEMALE.toString() : Gender.MALE.toString();
    }


    public String getGenderForSpecificOption(String name, String option) {
        switch (option) {
            case "first":
                return checkNameForGender(name);
            case "all":
                return checkAllNameForGender(name);
        }
        return Gender.INCONCLUSIVE.toString();
    }
}
