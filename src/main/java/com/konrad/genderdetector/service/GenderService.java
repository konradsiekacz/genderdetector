package com.konrad.genderdetector.service;

import com.konrad.genderdetector.dao.TokenNameDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
public class GenderService {
    private final TokenNameDao tokenNameDao;

    public String getAllFemaleNames() {
        return tokenNameDao.getFemaleNames();
    }

    public String getAllMaleNames(){
        return tokenNameDao.getMaleNames();
    }

}
