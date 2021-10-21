package com.konrad.genderdetector.dao;

import java.io.*;
import java.util.Scanner;

public class TokenNameDao implements TokenDao {
    private final String FEMALE_NAME = "/femaleNames.txt";
    private final String MALE_NAME = "/maleNames.txt";

    @Override
    public String getFemaleNames(String fileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(FEMALE_NAME);
        String data = readFromInputStream(inputStream);
        return data;
    }

    @Override
    public String getMaleNames(String fileName) {
        return null;
    }

    private String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }
}
