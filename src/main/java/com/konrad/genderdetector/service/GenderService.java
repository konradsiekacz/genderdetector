package com.konrad.genderdetector.service;

import com.konrad.genderdetector.dao.TokenNameDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class GenderService {
    private final TokenNameDao tokenNameDao;

    public List<?> getAllFemaleNames() {
        String names = tokenNameDao.getFemaleNames() + tokenNameDao.getMaleNames();
        List<String> allNames = Arrays.asList(names.split("\n"));
        return allNames;
    }
}
