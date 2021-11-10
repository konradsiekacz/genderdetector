package com.konrad.genderdetector.service;

import com.konrad.genderdetector.dao.TokenDao;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.mockito.Mockito.when;

public class GenderServiceTest {

    @InjectMocks
    GenderService genderService;

    @Mock
    TokenDao tokenDao;

    @BeforeEach
    public void init(){
        MockitoAnnotations.initMocks(this);
        when(tokenDao.getFemaleNames()).thenReturn(prepareMockFemaleNames());
        when(tokenDao.getMaleNames()).thenReturn(prepareMockMaleNames());
    }

    @Test
    public void should_return_string_of_female_names(){
        //when
        String femaleNames = genderService.getAllFemaleNames();

        //then
        Assertions.assertEquals("Karolina", femaleNames.split(" ")[0]);
    }

    private String prepareMockFemaleNames(){
        return "Karolina Magda Monika Bernadetta";
    }

    private String prepareMockMaleNames(){
        return "Konrad Rafał Dariusz Mariusz";
    }

    private Scanner prepareMockScanner(String pathFile){
        Scanner scanner = null;
        try {
            FileInputStream inputStream = new FileInputStream(pathFile);
            scanner = new Scanner(inputStream);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return scanner;
    }
}
