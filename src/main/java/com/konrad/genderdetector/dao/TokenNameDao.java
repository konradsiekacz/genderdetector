package com.konrad.genderdetector.dao;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.stream.Collectors;

@Component
public class TokenNameDao implements TokenDao {
    private final String FEMALE_NAME = "femaleNames.txt";
    private final String MALE_NAME = "maleNames.txt";

    @Override
    public String getFemaleNames() {
        return readFromInputStream(FEMALE_NAME);
    }

    @Override
    public String getMaleNames() {
        return readFromInputStream(MALE_NAME);
    }


    public String readFromInputStream(String fileName) {
        String names = "";
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            names = br.lines().collect(Collectors.joining("\n"));
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("Files does not exist");
        } catch (IOException e) {
            System.err.println("File exists, but there was IOException");
        }
        return names;
    }
}
